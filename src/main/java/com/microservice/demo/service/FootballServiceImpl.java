package com.microservice.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.demo.api_int.FootballService;
import com.microservice.demo.model.CountryInfo;
import com.microservice.demo.model.FootballMatchInformation;
import com.microservice.demo.model.LeagueInfo;
import com.microservice.demo.model.TeamInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class FootballServiceImpl implements FootballService {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<FootballMatchInformation> getAllFootBallMatchInformation() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String jsonArray = restTemplate.getForObject("https://apiv2.apifootball.com/?action=get_leagues&APIkey=" + apiKey, String.class);
        List<LeagueInfo> leagueInfos = objectMapper.readValue(jsonArray, new TypeReference<List<LeagueInfo>>() {
        });
        List<FootballMatchInformation> footballMatchInformations = new ArrayList<>();
        for (LeagueInfo info : leagueInfos) {
            jsonArray = restTemplate.getForObject("https://apiv2.apifootball.com/?action=get_standings&league_id=" + info.getLeague_id() + "&APIkey=" + apiKey, String.class);
            List<TeamInfo> teamInfos = objectMapper.readValue(jsonArray, new TypeReference<List<TeamInfo>>() {
            });
            for (TeamInfo teamInfo : teamInfos) {
                footballMatchInformations.add(new FootballMatchInformation(info.getCountry_id(), info.getCountry_name(), info.getLeague_id(), info.getLeague_name(), teamInfo.getTeam_id(), teamInfo.getTeam_name(), teamInfo.getOverall_league_position()));
            }
        }
        return footballMatchInformations;
    }
}
