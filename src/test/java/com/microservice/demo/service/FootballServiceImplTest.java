package com.microservice.demo.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.microservice.demo.api_int.FootballService;
import com.microservice.demo.model.FootballMatchInformation;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class FootballServiceImplTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private FootballService footballService = new FootballServiceImpl();


    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(footballService, "apiKey", "12");
    }

    @Test
    public void shouldGetFootBallMatchInformation() throws JsonProcessingException {
        prepareMockResponse();
        List<FootballMatchInformation> allFootBallMatchInformation = footballService.getAllFootBallMatchInformation();
        Assert.assertEquals(44, allFootBallMatchInformation.size());

    }

    private void prepareMockResponse() {
        String leagueStatusResp = "[\n" +
                "    {\n" +
                "        \"country_id\": \"41\",\n" +
                "        \"country_name\": \"England\",\n" +
                "        \"league_id\": \"149\",\n" +
                "        \"league_name\": \"Championship\",\n" +
                "        \"league_season\": \"2020/2021\",\n" +
                "        \"league_logo\": \"https://apiv2.apifootball.com/badges/logo_leagues/149_championship.png\",\n" +
                "        \"country_logo\": \"https://apiv2.apifootball.com/badges/logo_country/41_england.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_id\": \"46\",\n" +
                "        \"country_name\": \"France\",\n" +
                "        \"league_id\": \"177\",\n" +
                "        \"league_name\": \"Ligue 2\",\n" +
                "        \"league_season\": \"2020/2021\",\n" +
                "        \"league_logo\": \"https://apiv2.apifootball.com/badges/logo_leagues/177_ligue-2.png\",\n" +
                "        \"country_logo\": \"https://apiv2.apifootball.com/badges/logo_country/46_france.png\"\n" +
                "    }\n" +
                "]";

        String leagueIdResp1 = "[\n" +
                "    {\n" +
                "        \"country_name\": \"England\",\n" +
                "        \"league_id\": \"149\",\n" +
                "        \"league_name\": \"Championship\",\n" +
                "        \"team_id\": \"2641\",\n" +
                "        \"team_name\": \"Norwich\",\n" +
                "        \"overall_promotion\": \"Promotion - Premier League\",\n" +
                "        \"overall_league_position\": \"1\",\n" +
                "        \"overall_league_payed\": \"44\",\n" +
                "        \"overall_league_W\": \"28\",\n" +
                "        \"overall_league_D\": \"9\",\n" +
                "        \"overall_league_L\": \"7\",\n" +
                "        \"overall_league_GF\": \"69\",\n" +
                "        \"overall_league_GA\": \"33\",\n" +
                "        \"overall_league_PTS\": \"93\",\n" +
                "        \"home_league_position\": \"2\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"22\",\n" +
                "        \"home_league_W\": \"13\",\n" +
                "        \"home_league_D\": \"6\",\n" +
                "        \"home_league_L\": \"3\",\n" +
                "        \"home_league_GF\": \"35\",\n" +
                "        \"home_league_GA\": \"14\",\n" +
                "        \"home_league_PTS\": \"45\",\n" +
                "        \"away_league_position\": \"1\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"22\",\n" +
                "        \"away_league_W\": \"15\",\n" +
                "        \"away_league_D\": \"3\",\n" +
                "        \"away_league_L\": \"4\",\n" +
                "        \"away_league_GF\": \"34\",\n" +
                "        \"away_league_GA\": \"19\",\n" +
                "        \"away_league_PTS\": \"48\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/2641_norwich.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"England\",\n" +
                "        \"league_id\": \"149\",\n" +
                "        \"league_name\": \"Championship\",\n" +
                "        \"team_id\": \"2623\",\n" +
                "        \"team_name\": \"Watford\",\n" +
                "        \"overall_promotion\": \"Promotion - Premier League\",\n" +
                "        \"overall_league_position\": \"2\",\n" +
                "        \"overall_league_payed\": \"44\",\n" +
                "        \"overall_league_W\": \"26\",\n" +
                "        \"overall_league_D\": \"10\",\n" +
                "        \"overall_league_L\": \"8\",\n" +
                "        \"overall_league_GF\": \"61\",\n" +
                "        \"overall_league_GA\": \"28\",\n" +
                "        \"overall_league_PTS\": \"88\",\n" +
                "        \"home_league_position\": \"1\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"22\",\n" +
                "        \"home_league_W\": \"18\",\n" +
                "        \"home_league_D\": \"2\",\n" +
                "        \"home_league_L\": \"2\",\n" +
                "        \"home_league_GF\": \"42\",\n" +
                "        \"home_league_GA\": \"12\",\n" +
                "        \"home_league_PTS\": \"56\",\n" +
                "        \"away_league_position\": \"7\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"22\",\n" +
                "        \"away_league_W\": \"8\",\n" +
                "        \"away_league_D\": \"8\",\n" +
                "        \"away_league_L\": \"6\",\n" +
                "        \"away_league_GF\": \"19\",\n" +
                "        \"away_league_GA\": \"16\",\n" +
                "        \"away_league_PTS\": \"32\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/2623_watford.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"England\",\n" +
                "        \"league_id\": \"149\",\n" +
                "        \"league_name\": \"Championship\",\n" +
                "        \"team_id\": \"2644\",\n" +
                "        \"team_name\": \"Brentford\",\n" +
                "        \"overall_promotion\": \"Promotion - Championship (Play Offs)\",\n" +
                "        \"overall_league_position\": \"3\",\n" +
                "        \"overall_league_payed\": \"43\",\n" +
                "        \"overall_league_W\": \"21\",\n" +
                "        \"overall_league_D\": \"15\",\n" +
                "        \"overall_league_L\": \"7\",\n" +
                "        \"overall_league_GF\": \"73\",\n" +
                "        \"overall_league_GA\": \"41\",\n" +
                "        \"overall_league_PTS\": \"78\",\n" +
                "        \"home_league_position\": \"5\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"21\",\n" +
                "        \"home_league_W\": \"10\",\n" +
                "        \"home_league_D\": \"9\",\n" +
                "        \"home_league_L\": \"2\",\n" +
                "        \"home_league_GF\": \"36\",\n" +
                "        \"home_league_GA\": \"20\",\n" +
                "        \"home_league_PTS\": \"39\",\n" +
                "        \"away_league_position\": \"2\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"22\",\n" +
                "        \"away_league_W\": \"11\",\n" +
                "        \"away_league_D\": \"6\",\n" +
                "        \"away_league_L\": \"5\",\n" +
                "        \"away_league_GF\": \"37\",\n" +
                "        \"away_league_GA\": \"21\",\n" +
                "        \"away_league_PTS\": \"39\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/2644_brentford.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"England\",\n" +
                "        \"league_id\": \"149\",\n" +
                "        \"league_name\": \"Championship\",\n" +
                "        \"team_id\": \"2615\",\n" +
                "        \"team_name\": \"Bournemouth\",\n" +
                "        \"overall_promotion\": \"Promotion - Championship (Play Offs)\",\n" +
                "        \"overall_league_position\": \"4\",\n" +
                "        \"overall_league_payed\": \"44\",\n" +
                "        \"overall_league_W\": \"22\",\n" +
                "        \"overall_league_D\": \"11\",\n" +
                "        \"overall_league_L\": \"11\",\n" +
                "        \"overall_league_GF\": \"73\",\n" +
                "        \"overall_league_GA\": \"43\",\n" +
                "        \"overall_league_PTS\": \"77\",\n" +
                "        \"home_league_position\": \"3\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"22\",\n" +
                "        \"home_league_W\": \"13\",\n" +
                "        \"home_league_D\": \"3\",\n" +
                "        \"home_league_L\": \"6\",\n" +
                "        \"home_league_GF\": \"40\",\n" +
                "        \"home_league_GA\": \"22\",\n" +
                "        \"home_league_PTS\": \"42\",\n" +
                "        \"away_league_position\": \"5\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"22\",\n" +
                "        \"away_league_W\": \"9\",\n" +
                "        \"away_league_D\": \"8\",\n" +
                "        \"away_league_L\": \"5\",\n" +
                "        \"away_league_GF\": \"33\",\n" +
                "        \"away_league_GA\": \"21\",\n" +
                "        \"away_league_PTS\": \"35\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/2615_bournemouth.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"England\",\n" +
                "        \"league_id\": \"149\",\n" +
                "        \"league_name\": \"Championship\",\n" +
                "        \"team_id\": \"2618\",\n" +
                "        \"team_name\": \"Swansea\",\n" +
                "        \"overall_promotion\": \"Promotion - Championship (Play Offs)\",\n" +
                "        \"overall_league_position\": \"5\",\n" +
                "        \"overall_league_payed\": \"44\",\n" +
                "        \"overall_league_W\": \"22\",\n" +
                "        \"overall_league_D\": \"11\",\n" +
                "        \"overall_league_L\": \"11\",\n" +
                "        \"overall_league_GF\": \"54\",\n" +
                "        \"overall_league_GA\": \"36\",\n" +
                "        \"overall_league_PTS\": \"77\",\n" +
                "        \"home_league_position\": \"7\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"22\",\n" +
                "        \"home_league_W\": \"11\",\n" +
                "        \"home_league_D\": \"6\",\n" +
                "        \"home_league_L\": \"5\",\n" +
                "        \"home_league_GF\": \"25\",\n" +
                "        \"home_league_GA\": \"15\",\n" +
                "        \"home_league_PTS\": \"39\",\n" +
                "        \"away_league_position\": \"3\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"22\",\n" +
                "        \"away_league_W\": \"11\",\n" +
                "        \"away_league_D\": \"5\",\n" +
                "        \"away_league_L\": \"6\",\n" +
                "        \"away_league_GF\": \"29\",\n" +
                "        \"away_league_GA\": \"21\",\n" +
                "        \"away_league_PTS\": \"38\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/2618_swansea.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"England\",\n" +
                "        \"league_id\": \"149\",\n" +
                "        \"league_name\": \"Championship\",\n" +
                "        \"team_id\": \"2652\",\n" +
                "        \"team_name\": \"Barnsley\",\n" +
                "        \"overall_promotion\": \"Promotion - Championship (Play Offs)\",\n" +
                "        \"overall_league_position\": \"6\",\n" +
                "        \"overall_league_payed\": \"44\",\n" +
                "        \"overall_league_W\": \"23\",\n" +
                "        \"overall_league_D\": \"8\",\n" +
                "        \"overall_league_L\": \"13\",\n" +
                "        \"overall_league_GF\": \"56\",\n" +
                "        \"overall_league_GA\": \"46\",\n" +
                "        \"overall_league_PTS\": \"77\",\n" +
                "        \"home_league_position\": \"4\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"22\",\n" +
                "        \"home_league_W\": \"12\",\n" +
                "        \"home_league_D\": \"5\",\n" +
                "        \"home_league_L\": \"5\",\n" +
                "        \"home_league_GF\": \"28\",\n" +
                "        \"home_league_GA\": \"20\",\n" +
                "        \"home_league_PTS\": \"41\",\n" +
                "        \"away_league_position\": \"4\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"22\",\n" +
                "        \"away_league_W\": \"11\",\n" +
                "        \"away_league_D\": \"3\",\n" +
                "        \"away_league_L\": \"8\",\n" +
                "        \"away_league_GF\": \"28\",\n" +
                "        \"away_league_GA\": \"26\",\n" +
                "        \"away_league_PTS\": \"36\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/2652_barnsley.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"England\",\n" +
                "        \"league_id\": \"149\",\n" +
                "        \"league_name\": \"Championship\",\n" +
                "        \"team_id\": \"2647\",\n" +
                "        \"team_name\": \"Reading\",\n" +
                "        \"overall_promotion\": \"\",\n" +
                "        \"overall_league_position\": \"7\",\n" +
                "        \"overall_league_payed\": \"44\",\n" +
                "        \"overall_league_W\": \"19\",\n" +
                "        \"overall_league_D\": \"12\",\n" +
                "        \"overall_league_L\": \"13\",\n" +
                "        \"overall_league_GF\": \"59\",\n" +
                "        \"overall_league_GA\": \"48\",\n" +
                "        \"overall_league_PTS\": \"69\",\n" +
                "        \"home_league_position\": \"6\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"22\",\n" +
                "        \"home_league_W\": \"12\",\n" +
                "        \"home_league_D\": \"3\",\n" +
                "        \"home_league_L\": \"7\",\n" +
                "        \"home_league_GF\": \"35\",\n" +
                "        \"home_league_GA\": \"25\",\n" +
                "        \"home_league_PTS\": \"39\",\n" +
                "        \"away_league_position\": \"10\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"22\",\n" +
                "        \"away_league_W\": \"7\",\n" +
                "        \"away_league_D\": \"9\",\n" +
                "        \"away_league_L\": \"6\",\n" +
                "        \"away_league_GF\": \"24\",\n" +
                "        \"away_league_GA\": \"23\",\n" +
                "        \"away_league_PTS\": \"30\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/2647_reading.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"England\",\n" +
                "        \"league_id\": \"149\",\n" +
                "        \"league_name\": \"Championship\",\n" +
                "        \"team_id\": \"2637\",\n" +
                "        \"team_name\": \"Cardiff\",\n" +
                "        \"overall_promotion\": \"\",\n" +
                "        \"overall_league_position\": \"8\",\n" +
                "        \"overall_league_payed\": \"44\",\n" +
                "        \"overall_league_W\": \"17\",\n" +
                "        \"overall_league_D\": \"13\",\n" +
                "        \"overall_league_L\": \"14\",\n" +
                "        \"overall_league_GF\": \"61\",\n" +
                "        \"overall_league_GA\": \"48\",\n" +
                "        \"overall_league_PTS\": \"64\",\n" +
                "        \"home_league_position\": \"16\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"22\",\n" +
                "        \"home_league_W\": \"8\",\n" +
                "        \"home_league_D\": \"5\",\n" +
                "        \"home_league_L\": \"9\",\n" +
                "        \"home_league_GF\": \"36\",\n" +
                "        \"home_league_GA\": \"25\",\n" +
                "        \"home_league_PTS\": \"29\",\n" +
                "        \"away_league_position\": \"6\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"22\",\n" +
                "        \"away_league_W\": \"9\",\n" +
                "        \"away_league_D\": \"8\",\n" +
                "        \"away_league_L\": \"5\",\n" +
                "        \"away_league_GF\": \"25\",\n" +
                "        \"away_league_GA\": \"23\",\n" +
                "        \"away_league_PTS\": \"35\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/2637_cardiff.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"England\",\n" +
                "        \"league_id\": \"149\",\n" +
                "        \"league_name\": \"Championship\",\n" +
                "        \"team_id\": \"2648\",\n" +
                "        \"team_name\": \"Middlesbrough\",\n" +
                "        \"overall_promotion\": \"\",\n" +
                "        \"overall_league_position\": \"9\",\n" +
                "        \"overall_league_payed\": \"44\",\n" +
                "        \"overall_league_W\": \"18\",\n" +
                "        \"overall_league_D\": \"9\",\n" +
                "        \"overall_league_L\": \"17\",\n" +
                "        \"overall_league_GF\": \"54\",\n" +
                "        \"overall_league_GA\": \"49\",\n" +
                "        \"overall_league_PTS\": \"63\",\n" +
                "        \"home_league_position\": \"8\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"22\",\n" +
                "        \"home_league_W\": \"11\",\n" +
                "        \"home_league_D\": \"4\",\n" +
                "        \"home_league_L\": \"7\",\n" +
                "        \"home_league_GF\": \"30\",\n" +
                "        \"home_league_GA\": \"22\",\n" +
                "        \"home_league_PTS\": \"37\",\n" +
                "        \"away_league_position\": \"15\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"22\",\n" +
                "        \"away_league_W\": \"7\",\n" +
                "        \"away_league_D\": \"5\",\n" +
                "        \"away_league_L\": \"10\",\n" +
                "        \"away_league_GF\": \"24\",\n" +
                "        \"away_league_GA\": \"27\",\n" +
                "        \"away_league_PTS\": \"26\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/2648_middlesbrough.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"England\",\n" +
                "        \"league_id\": \"149\",\n" +
                "        \"league_name\": \"Championship\",\n" +
                "        \"team_id\": \"2645\",\n" +
                "        \"team_name\": \"QPR\",\n" +
                "        \"overall_promotion\": \"\",\n" +
                "        \"overall_league_position\": \"10\",\n" +
                "        \"overall_league_payed\": \"44\",\n" +
                "        \"overall_league_W\": \"17\",\n" +
                "        \"overall_league_D\": \"11\",\n" +
                "        \"overall_league_L\": \"16\",\n" +
                "        \"overall_league_GF\": \"52\",\n" +
                "        \"overall_league_GA\": \"54\",\n" +
                "        \"overall_league_PTS\": \"62\",\n" +
                "        \"home_league_position\": \"9\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"22\",\n" +
                "        \"home_league_W\": \"10\",\n" +
                "        \"home_league_D\": \"4\",\n" +
                "        \"home_league_L\": \"8\",\n" +
                "        \"home_league_GF\": \"29\",\n" +
                "        \"home_league_GA\": \"26\",\n" +
                "        \"home_league_PTS\": \"34\",\n" +
                "        \"away_league_position\": \"13\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"22\",\n" +
                "        \"away_league_W\": \"7\",\n" +
                "        \"away_league_D\": \"7\",\n" +
                "        \"away_league_L\": \"8\",\n" +
                "        \"away_league_GF\": \"23\",\n" +
                "        \"away_league_GA\": \"28\",\n" +
                "        \"away_league_PTS\": \"28\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/2645_qpr.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"England\",\n" +
                "        \"league_id\": \"149\",\n" +
                "        \"league_name\": \"Championship\",\n" +
                "        \"team_id\": \"2695\",\n" +
                "        \"team_name\": \"Luton\",\n" +
                "        \"overall_promotion\": \"\",\n" +
                "        \"overall_league_position\": \"11\",\n" +
                "        \"overall_league_payed\": \"43\",\n" +
                "        \"overall_league_W\": \"17\",\n" +
                "        \"overall_league_D\": \"9\",\n" +
                "        \"overall_league_L\": \"17\",\n" +
                "        \"overall_league_GF\": \"39\",\n" +
                "        \"overall_league_GA\": \"48\",\n" +
                "        \"overall_league_PTS\": \"60\",\n" +
                "        \"home_league_position\": \"14\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"21\",\n" +
                "        \"home_league_W\": \"8\",\n" +
                "        \"home_league_D\": \"7\",\n" +
                "        \"home_league_L\": \"6\",\n" +
                "        \"home_league_GF\": \"24\",\n" +
                "        \"home_league_GA\": \"22\",\n" +
                "        \"home_league_PTS\": \"31\",\n" +
                "        \"away_league_position\": \"12\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"22\",\n" +
                "        \"away_league_W\": \"9\",\n" +
                "        \"away_league_D\": \"2\",\n" +
                "        \"away_league_L\": \"11\",\n" +
                "        \"away_league_GF\": \"15\",\n" +
                "        \"away_league_GA\": \"26\",\n" +
                "        \"away_league_PTS\": \"29\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/2695_luton.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"England\",\n" +
                "        \"league_id\": \"149\",\n" +
                "        \"league_name\": \"Championship\",\n" +
                "        \"team_id\": \"2638\",\n" +
                "        \"team_name\": \"Millwall\",\n" +
                "        \"overall_promotion\": \"\",\n" +
                "        \"overall_league_position\": \"12\",\n" +
                "        \"overall_league_payed\": \"44\",\n" +
                "        \"overall_league_W\": \"14\",\n" +
                "        \"overall_league_D\": \"17\",\n" +
                "        \"overall_league_L\": \"13\",\n" +
                "        \"overall_league_GF\": \"42\",\n" +
                "        \"overall_league_GA\": \"45\",\n" +
                "        \"overall_league_PTS\": \"59\",\n" +
                "        \"home_league_position\": \"17\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"22\",\n" +
                "        \"home_league_W\": \"6\",\n" +
                "        \"home_league_D\": \"10\",\n" +
                "        \"home_league_L\": \"6\",\n" +
                "        \"home_league_GF\": \"20\",\n" +
                "        \"home_league_GA\": \"23\",\n" +
                "        \"home_league_PTS\": \"28\",\n" +
                "        \"away_league_position\": \"9\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"22\",\n" +
                "        \"away_league_W\": \"8\",\n" +
                "        \"away_league_D\": \"7\",\n" +
                "        \"away_league_L\": \"7\",\n" +
                "        \"away_league_GF\": \"22\",\n" +
                "        \"away_league_GA\": \"22\",\n" +
                "        \"away_league_PTS\": \"31\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/2638_millwall.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"England\",\n" +
                "        \"league_id\": \"149\",\n" +
                "        \"league_name\": \"Championship\",\n" +
                "        \"team_id\": \"2624\",\n" +
                "        \"team_name\": \"Stoke\",\n" +
                "        \"overall_promotion\": \"\",\n" +
                "        \"overall_league_position\": \"13\",\n" +
                "        \"overall_league_payed\": \"44\",\n" +
                "        \"overall_league_W\": \"14\",\n" +
                "        \"overall_league_D\": \"15\",\n" +
                "        \"overall_league_L\": \"15\",\n" +
                "        \"overall_league_GF\": \"48\",\n" +
                "        \"overall_league_GA\": \"50\",\n" +
                "        \"overall_league_PTS\": \"57\",\n" +
                "        \"home_league_position\": \"11\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"22\",\n" +
                "        \"home_league_W\": \"9\",\n" +
                "        \"home_league_D\": \"5\",\n" +
                "        \"home_league_L\": \"8\",\n" +
                "        \"home_league_GF\": \"29\",\n" +
                "        \"home_league_GA\": \"26\",\n" +
                "        \"home_league_PTS\": \"32\",\n" +
                "        \"away_league_position\": \"16\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"22\",\n" +
                "        \"away_league_W\": \"5\",\n" +
                "        \"away_league_D\": \"10\",\n" +
                "        \"away_league_L\": \"7\",\n" +
                "        \"away_league_GF\": \"19\",\n" +
                "        \"away_league_GA\": \"24\",\n" +
                "        \"away_league_PTS\": \"25\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/2624_stoke-city.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"England\",\n" +
                "        \"league_id\": \"149\",\n" +
                "        \"league_name\": \"Championship\",\n" +
                "        \"team_id\": \"2643\",\n" +
                "        \"team_name\": \"Preston\",\n" +
                "        \"overall_promotion\": \"\",\n" +
                "        \"overall_league_position\": \"14\",\n" +
                "        \"overall_league_payed\": \"44\",\n" +
                "        \"overall_league_W\": \"16\",\n" +
                "        \"overall_league_D\": \"7\",\n" +
                "        \"overall_league_L\": \"21\",\n" +
                "        \"overall_league_GF\": \"45\",\n" +
                "        \"overall_league_GA\": \"55\",\n" +
                "        \"overall_league_PTS\": \"55\",\n" +
                "        \"home_league_position\": \"21\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"22\",\n" +
                "        \"home_league_W\": \"6\",\n" +
                "        \"home_league_D\": \"5\",\n" +
                "        \"home_league_L\": \"11\",\n" +
                "        \"home_league_GF\": \"19\",\n" +
                "        \"home_league_GA\": \"24\",\n" +
                "        \"home_league_PTS\": \"23\",\n" +
                "        \"away_league_position\": \"8\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"22\",\n" +
                "        \"away_league_W\": \"10\",\n" +
                "        \"away_league_D\": \"2\",\n" +
                "        \"away_league_L\": \"10\",\n" +
                "        \"away_league_GF\": \"26\",\n" +
                "        \"away_league_GA\": \"31\",\n" +
                "        \"away_league_PTS\": \"32\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/2643_preston.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"England\",\n" +
                "        \"league_id\": \"149\",\n" +
                "        \"league_name\": \"Championship\",\n" +
                "        \"team_id\": \"2680\",\n" +
                "        \"team_name\": \"Blackburn\",\n" +
                "        \"overall_promotion\": \"\",\n" +
                "        \"overall_league_position\": \"15\",\n" +
                "        \"overall_league_payed\": \"44\",\n" +
                "        \"overall_league_W\": \"14\",\n" +
                "        \"overall_league_D\": \"11\",\n" +
                "        \"overall_league_L\": \"19\",\n" +
                "        \"overall_league_GF\": \"59\",\n" +
                "        \"overall_league_GA\": \"51\",\n" +
                "        \"overall_league_PTS\": \"53\",\n" +
                "        \"home_league_position\": \"12\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"22\",\n" +
                "        \"home_league_W\": \"8\",\n" +
                "        \"home_league_D\": \"7\",\n" +
                "        \"home_league_L\": \"7\",\n" +
                "        \"home_league_GF\": \"32\",\n" +
                "        \"home_league_GA\": \"26\",\n" +
                "        \"home_league_PTS\": \"31\",\n" +
                "        \"away_league_position\": \"18\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"22\",\n" +
                "        \"away_league_W\": \"6\",\n" +
                "        \"away_league_D\": \"4\",\n" +
                "        \"away_league_L\": \"12\",\n" +
                "        \"away_league_GF\": \"27\",\n" +
                "        \"away_league_GA\": \"25\",\n" +
                "        \"away_league_PTS\": \"22\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/2680_blackburn.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"England\",\n" +
                "        \"league_id\": \"149\",\n" +
                "        \"league_name\": \"Championship\",\n" +
                "        \"team_id\": \"2631\",\n" +
                "        \"team_name\": \"Birmingham\",\n" +
                "        \"overall_promotion\": \"\",\n" +
                "        \"overall_league_position\": \"16\",\n" +
                "        \"overall_league_payed\": \"44\",\n" +
                "        \"overall_league_W\": \"13\",\n" +
                "        \"overall_league_D\": \"13\",\n" +
                "        \"overall_league_L\": \"18\",\n" +
                "        \"overall_league_GF\": \"35\",\n" +
                "        \"overall_league_GA\": \"52\",\n" +
                "        \"overall_league_PTS\": \"52\",\n" +
                "        \"home_league_position\": \"23\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"22\",\n" +
                "        \"home_league_W\": \"6\",\n" +
                "        \"home_league_D\": \"4\",\n" +
                "        \"home_league_L\": \"12\",\n" +
                "        \"home_league_GF\": \"18\",\n" +
                "        \"home_league_GA\": \"33\",\n" +
                "        \"home_league_PTS\": \"22\",\n" +
                "        \"away_league_position\": \"11\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"22\",\n" +
                "        \"away_league_W\": \"7\",\n" +
                "        \"away_league_D\": \"9\",\n" +
                "        \"away_league_L\": \"6\",\n" +
                "        \"away_league_GF\": \"17\",\n" +
                "        \"away_league_GA\": \"19\",\n" +
                "        \"away_league_PTS\": \"30\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/2631_birmingham.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"England\",\n" +
                "        \"league_id\": \"149\",\n" +
                "        \"league_name\": \"Championship\",\n" +
                "        \"team_id\": \"2634\",\n" +
                "        \"team_name\": \"Nottingham\",\n" +
                "        \"overall_promotion\": \"\",\n" +
                "        \"overall_league_position\": \"17\",\n" +
                "        \"overall_league_payed\": \"44\",\n" +
                "        \"overall_league_W\": \"12\",\n" +
                "        \"overall_league_D\": \"15\",\n" +
                "        \"overall_league_L\": \"17\",\n" +
                "        \"overall_league_GF\": \"36\",\n" +
                "        \"overall_league_GA\": \"43\",\n" +
                "        \"overall_league_PTS\": \"51\",\n" +
                "        \"home_league_position\": \"18\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"22\",\n" +
                "        \"home_league_W\": \"6\",\n" +
                "        \"home_league_D\": \"8\",\n" +
                "        \"home_league_L\": \"8\",\n" +
                "        \"home_league_GF\": \"20\",\n" +
                "        \"home_league_GA\": \"22\",\n" +
                "        \"home_league_PTS\": \"26\",\n" +
                "        \"away_league_position\": \"17\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"22\",\n" +
                "        \"away_league_W\": \"6\",\n" +
                "        \"away_league_D\": \"7\",\n" +
                "        \"away_league_L\": \"9\",\n" +
                "        \"away_league_GF\": \"16\",\n" +
                "        \"away_league_GA\": \"21\",\n" +
                "        \"away_league_PTS\": \"25\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/2634_nottingham.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"England\",\n" +
                "        \"league_id\": \"149\",\n" +
                "        \"league_name\": \"Championship\",\n" +
                "        \"team_id\": \"2650\",\n" +
                "        \"team_name\": \"Bristol City\",\n" +
                "        \"overall_promotion\": \"\",\n" +
                "        \"overall_league_position\": \"18\",\n" +
                "        \"overall_league_payed\": \"44\",\n" +
                "        \"overall_league_W\": \"15\",\n" +
                "        \"overall_league_D\": \"6\",\n" +
                "        \"overall_league_L\": \"23\",\n" +
                "        \"overall_league_GF\": \"44\",\n" +
                "        \"overall_league_GA\": \"61\",\n" +
                "        \"overall_league_PTS\": \"51\",\n" +
                "        \"home_league_position\": \"20\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"22\",\n" +
                "        \"home_league_W\": \"7\",\n" +
                "        \"home_league_D\": \"3\",\n" +
                "        \"home_league_L\": \"12\",\n" +
                "        \"home_league_GF\": \"17\",\n" +
                "        \"home_league_GA\": \"27\",\n" +
                "        \"home_league_PTS\": \"24\",\n" +
                "        \"away_league_position\": \"14\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"22\",\n" +
                "        \"away_league_W\": \"8\",\n" +
                "        \"away_league_D\": \"3\",\n" +
                "        \"away_league_L\": \"11\",\n" +
                "        \"away_league_GF\": \"27\",\n" +
                "        \"away_league_GA\": \"34\",\n" +
                "        \"away_league_PTS\": \"27\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/2650_bristol-city.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"England\",\n" +
                "        \"league_id\": \"149\",\n" +
                "        \"league_name\": \"Championship\",\n" +
                "        \"team_id\": \"2696\",\n" +
                "        \"team_name\": \"Coventry\",\n" +
                "        \"overall_promotion\": \"\",\n" +
                "        \"overall_league_position\": \"19\",\n" +
                "        \"overall_league_payed\": \"44\",\n" +
                "        \"overall_league_W\": \"13\",\n" +
                "        \"overall_league_D\": \"12\",\n" +
                "        \"overall_league_L\": \"19\",\n" +
                "        \"overall_league_GF\": \"42\",\n" +
                "        \"overall_league_GA\": \"59\",\n" +
                "        \"overall_league_PTS\": \"51\",\n" +
                "        \"home_league_position\": \"10\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"22\",\n" +
                "        \"home_league_W\": \"9\",\n" +
                "        \"home_league_D\": \"7\",\n" +
                "        \"home_league_L\": \"6\",\n" +
                "        \"home_league_GF\": \"24\",\n" +
                "        \"home_league_GA\": \"21\",\n" +
                "        \"home_league_PTS\": \"34\",\n" +
                "        \"away_league_position\": \"21\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"22\",\n" +
                "        \"away_league_W\": \"4\",\n" +
                "        \"away_league_D\": \"5\",\n" +
                "        \"away_league_L\": \"13\",\n" +
                "        \"away_league_GF\": \"18\",\n" +
                "        \"away_league_GA\": \"38\",\n" +
                "        \"away_league_PTS\": \"17\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/2696_coventry.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"England\",\n" +
                "        \"league_id\": \"149\",\n" +
                "        \"league_name\": \"Championship\",\n" +
                "        \"team_id\": \"2622\",\n" +
                "        \"team_name\": \"Huddersfield\",\n" +
                "        \"overall_promotion\": \"\",\n" +
                "        \"overall_league_position\": \"20\",\n" +
                "        \"overall_league_payed\": \"44\",\n" +
                "        \"overall_league_W\": \"12\",\n" +
                "        \"overall_league_D\": \"11\",\n" +
                "        \"overall_league_L\": \"21\",\n" +
                "        \"overall_league_GF\": \"47\",\n" +
                "        \"overall_league_GA\": \"68\",\n" +
                "        \"overall_league_PTS\": \"47\",\n" +
                "        \"home_league_position\": \"15\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"22\",\n" +
                "        \"home_league_W\": \"8\",\n" +
                "        \"home_league_D\": \"6\",\n" +
                "        \"home_league_L\": \"8\",\n" +
                "        \"home_league_GF\": \"27\",\n" +
                "        \"home_league_GA\": \"22\",\n" +
                "        \"home_league_PTS\": \"30\",\n" +
                "        \"away_league_position\": \"22\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"22\",\n" +
                "        \"away_league_W\": \"4\",\n" +
                "        \"away_league_D\": \"5\",\n" +
                "        \"away_league_L\": \"13\",\n" +
                "        \"away_league_GF\": \"20\",\n" +
                "        \"away_league_GA\": \"46\",\n" +
                "        \"away_league_PTS\": \"17\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/2622_huddersfield.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"England\",\n" +
                "        \"league_id\": \"149\",\n" +
                "        \"league_name\": \"Championship\",\n" +
                "        \"team_id\": \"2642\",\n" +
                "        \"team_name\": \"Derby\",\n" +
                "        \"overall_promotion\": \"\",\n" +
                "        \"overall_league_position\": \"21\",\n" +
                "        \"overall_league_payed\": \"44\",\n" +
                "        \"overall_league_W\": \"11\",\n" +
                "        \"overall_league_D\": \"10\",\n" +
                "        \"overall_league_L\": \"23\",\n" +
                "        \"overall_league_GF\": \"32\",\n" +
                "        \"overall_league_GA\": \"53\",\n" +
                "        \"overall_league_PTS\": \"43\",\n" +
                "        \"home_league_position\": \"19\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"22\",\n" +
                "        \"home_league_W\": \"6\",\n" +
                "        \"home_league_D\": \"6\",\n" +
                "        \"home_league_L\": \"10\",\n" +
                "        \"home_league_GF\": \"17\",\n" +
                "        \"home_league_GA\": \"23\",\n" +
                "        \"home_league_PTS\": \"24\",\n" +
                "        \"away_league_position\": \"20\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"22\",\n" +
                "        \"away_league_W\": \"5\",\n" +
                "        \"away_league_D\": \"4\",\n" +
                "        \"away_league_L\": \"13\",\n" +
                "        \"away_league_GF\": \"15\",\n" +
                "        \"away_league_GA\": \"30\",\n" +
                "        \"away_league_PTS\": \"19\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/2642_derby.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"England\",\n" +
                "        \"league_id\": \"149\",\n" +
                "        \"league_name\": \"Championship\",\n" +
                "        \"team_id\": \"2675\",\n" +
                "        \"team_name\": \"Rotherham\",\n" +
                "        \"overall_promotion\": \"Relegation\",\n" +
                "        \"overall_league_position\": \"22\",\n" +
                "        \"overall_league_payed\": \"42\",\n" +
                "        \"overall_league_W\": \"11\",\n" +
                "        \"overall_league_D\": \"6\",\n" +
                "        \"overall_league_L\": \"25\",\n" +
                "        \"overall_league_GF\": \"42\",\n" +
                "        \"overall_league_GA\": \"57\",\n" +
                "        \"overall_league_PTS\": \"39\",\n" +
                "        \"home_league_position\": \"24\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"22\",\n" +
                "        \"home_league_W\": \"5\",\n" +
                "        \"home_league_D\": \"3\",\n" +
                "        \"home_league_L\": \"14\",\n" +
                "        \"home_league_GF\": \"25\",\n" +
                "        \"home_league_GA\": \"34\",\n" +
                "        \"home_league_PTS\": \"18\",\n" +
                "        \"away_league_position\": \"19\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"20\",\n" +
                "        \"away_league_W\": \"6\",\n" +
                "        \"away_league_D\": \"3\",\n" +
                "        \"away_league_L\": \"11\",\n" +
                "        \"away_league_GF\": \"17\",\n" +
                "        \"away_league_GA\": \"23\",\n" +
                "        \"away_league_PTS\": \"21\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/2675_rotherham.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"England\",\n" +
                "        \"league_id\": \"149\",\n" +
                "        \"league_name\": \"Championship\",\n" +
                "        \"team_id\": \"2651\",\n" +
                "        \"team_name\": \"Sheffield Wed\",\n" +
                "        \"overall_promotion\": \"Relegation\",\n" +
                "        \"overall_league_position\": \"23\",\n" +
                "        \"overall_league_payed\": \"44\",\n" +
                "        \"overall_league_W\": \"12\",\n" +
                "        \"overall_league_D\": \"9\",\n" +
                "        \"overall_league_L\": \"23\",\n" +
                "        \"overall_league_GF\": \"37\",\n" +
                "        \"overall_league_GA\": \"58\",\n" +
                "        \"overall_league_PTS\": \"39\",\n" +
                "        \"home_league_position\": \"13\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"22\",\n" +
                "        \"home_league_W\": \"8\",\n" +
                "        \"home_league_D\": \"7\",\n" +
                "        \"home_league_L\": \"7\",\n" +
                "        \"home_league_GF\": \"22\",\n" +
                "        \"home_league_GA\": \"17\",\n" +
                "        \"home_league_PTS\": \"31\",\n" +
                "        \"away_league_position\": \"24\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"22\",\n" +
                "        \"away_league_W\": \"4\",\n" +
                "        \"away_league_D\": \"2\",\n" +
                "        \"away_league_L\": \"16\",\n" +
                "        \"away_league_GF\": \"15\",\n" +
                "        \"away_league_GA\": \"41\",\n" +
                "        \"away_league_PTS\": \"14\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/2651_sheffield-wed.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"England\",\n" +
                "        \"league_id\": \"149\",\n" +
                "        \"league_name\": \"Championship\",\n" +
                "        \"team_id\": \"2703\",\n" +
                "        \"team_name\": \"Wycombe\",\n" +
                "        \"overall_promotion\": \"Relegation\",\n" +
                "        \"overall_league_position\": \"24\",\n" +
                "        \"overall_league_payed\": \"44\",\n" +
                "        \"overall_league_W\": \"9\",\n" +
                "        \"overall_league_D\": \"10\",\n" +
                "        \"overall_league_L\": \"25\",\n" +
                "        \"overall_league_GF\": \"35\",\n" +
                "        \"overall_league_GA\": \"69\",\n" +
                "        \"overall_league_PTS\": \"37\",\n" +
                "        \"home_league_position\": \"22\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"22\",\n" +
                "        \"home_league_W\": \"6\",\n" +
                "        \"home_league_D\": \"5\",\n" +
                "        \"home_league_L\": \"11\",\n" +
                "        \"home_league_GF\": \"16\",\n" +
                "        \"home_league_GA\": \"28\",\n" +
                "        \"home_league_PTS\": \"23\",\n" +
                "        \"away_league_position\": \"23\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"22\",\n" +
                "        \"away_league_W\": \"3\",\n" +
                "        \"away_league_D\": \"5\",\n" +
                "        \"away_league_L\": \"14\",\n" +
                "        \"away_league_GF\": \"19\",\n" +
                "        \"away_league_GA\": \"41\",\n" +
                "        \"away_league_PTS\": \"14\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/2703_wycombe.png\"\n" +
                "    }\n" +
                "]";

        String leagueIdResp2 = "[\n" +
                "    {\n" +
                "        \"country_name\": \"France\",\n" +
                "        \"league_id\": \"177\",\n" +
                "        \"league_name\": \"Ligue 2\",\n" +
                "        \"team_id\": \"3029\",\n" +
                "        \"team_name\": \"Troyes\",\n" +
                "        \"overall_promotion\": \"Promotion - Ligue 1\",\n" +
                "        \"overall_league_position\": \"1\",\n" +
                "        \"overall_league_payed\": \"35\",\n" +
                "        \"overall_league_W\": \"21\",\n" +
                "        \"overall_league_D\": \"8\",\n" +
                "        \"overall_league_L\": \"6\",\n" +
                "        \"overall_league_GF\": \"54\",\n" +
                "        \"overall_league_GA\": \"32\",\n" +
                "        \"overall_league_PTS\": \"71\",\n" +
                "        \"home_league_position\": \"1\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"18\",\n" +
                "        \"home_league_W\": \"14\",\n" +
                "        \"home_league_D\": \"3\",\n" +
                "        \"home_league_L\": \"1\",\n" +
                "        \"home_league_GF\": \"30\",\n" +
                "        \"home_league_GA\": \"15\",\n" +
                "        \"home_league_PTS\": \"45\",\n" +
                "        \"away_league_position\": \"2\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"17\",\n" +
                "        \"away_league_W\": \"7\",\n" +
                "        \"away_league_D\": \"5\",\n" +
                "        \"away_league_L\": \"5\",\n" +
                "        \"away_league_GF\": \"24\",\n" +
                "        \"away_league_GA\": \"17\",\n" +
                "        \"away_league_PTS\": \"26\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/3029_troyes.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"France\",\n" +
                "        \"league_id\": \"177\",\n" +
                "        \"league_name\": \"Ligue 2\",\n" +
                "        \"team_id\": \"3042\",\n" +
                "        \"team_name\": \"Clermont\",\n" +
                "        \"overall_promotion\": \"Promotion - Ligue 1\",\n" +
                "        \"overall_league_position\": \"2\",\n" +
                "        \"overall_league_payed\": \"34\",\n" +
                "        \"overall_league_W\": \"18\",\n" +
                "        \"overall_league_D\": \"9\",\n" +
                "        \"overall_league_L\": \"7\",\n" +
                "        \"overall_league_GF\": \"53\",\n" +
                "        \"overall_league_GA\": \"20\",\n" +
                "        \"overall_league_PTS\": \"63\",\n" +
                "        \"home_league_position\": \"4\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"17\",\n" +
                "        \"home_league_W\": \"11\",\n" +
                "        \"home_league_D\": \"5\",\n" +
                "        \"home_league_L\": \"1\",\n" +
                "        \"home_league_GF\": \"32\",\n" +
                "        \"home_league_GA\": \"7\",\n" +
                "        \"home_league_PTS\": \"38\",\n" +
                "        \"away_league_position\": \"3\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"17\",\n" +
                "        \"away_league_W\": \"7\",\n" +
                "        \"away_league_D\": \"4\",\n" +
                "        \"away_league_L\": \"6\",\n" +
                "        \"away_league_GF\": \"21\",\n" +
                "        \"away_league_GA\": \"13\",\n" +
                "        \"away_league_PTS\": \"25\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/3042_clermont.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"France\",\n" +
                "        \"league_id\": \"177\",\n" +
                "        \"league_name\": \"Ligue 2\",\n" +
                "        \"team_id\": \"3024\",\n" +
                "        \"team_name\": \"Toulouse\",\n" +
                "        \"overall_promotion\": \"Promotion - Ligue 1 (Promotion)\",\n" +
                "        \"overall_league_position\": \"3\",\n" +
                "        \"overall_league_payed\": \"33\",\n" +
                "        \"overall_league_W\": \"18\",\n" +
                "        \"overall_league_D\": \"8\",\n" +
                "        \"overall_league_L\": \"7\",\n" +
                "        \"overall_league_GF\": \"61\",\n" +
                "        \"overall_league_GA\": \"34\",\n" +
                "        \"overall_league_PTS\": \"62\",\n" +
                "        \"home_league_position\": \"2\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"17\",\n" +
                "        \"home_league_W\": \"12\",\n" +
                "        \"home_league_D\": \"3\",\n" +
                "        \"home_league_L\": \"2\",\n" +
                "        \"home_league_GF\": \"39\",\n" +
                "        \"home_league_GA\": \"16\",\n" +
                "        \"home_league_PTS\": \"39\",\n" +
                "        \"away_league_position\": \"6\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"16\",\n" +
                "        \"away_league_W\": \"6\",\n" +
                "        \"away_league_D\": \"5\",\n" +
                "        \"away_league_L\": \"5\",\n" +
                "        \"away_league_GF\": \"22\",\n" +
                "        \"away_league_GA\": \"18\",\n" +
                "        \"away_league_PTS\": \"23\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/3024_toulouse.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"France\",\n" +
                "        \"league_id\": \"177\",\n" +
                "        \"league_name\": \"Ligue 2\",\n" +
                "        \"team_id\": \"3078\",\n" +
                "        \"team_name\": \"Grenoble\",\n" +
                "        \"overall_promotion\": \"Promotion - Ligue 1 (Promotion)\",\n" +
                "        \"overall_league_position\": \"4\",\n" +
                "        \"overall_league_payed\": \"35\",\n" +
                "        \"overall_league_W\": \"17\",\n" +
                "        \"overall_league_D\": \"10\",\n" +
                "        \"overall_league_L\": \"8\",\n" +
                "        \"overall_league_GF\": \"48\",\n" +
                "        \"overall_league_GA\": \"32\",\n" +
                "        \"overall_league_PTS\": \"61\",\n" +
                "        \"home_league_position\": \"3\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"17\",\n" +
                "        \"home_league_W\": \"11\",\n" +
                "        \"home_league_D\": \"6\",\n" +
                "        \"home_league_L\": \"0\",\n" +
                "        \"home_league_GF\": \"33\",\n" +
                "        \"home_league_GA\": \"12\",\n" +
                "        \"home_league_PTS\": \"39\",\n" +
                "        \"away_league_position\": \"8\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"18\",\n" +
                "        \"away_league_W\": \"6\",\n" +
                "        \"away_league_D\": \"4\",\n" +
                "        \"away_league_L\": \"8\",\n" +
                "        \"away_league_GF\": \"15\",\n" +
                "        \"away_league_GA\": \"20\",\n" +
                "        \"away_league_PTS\": \"22\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/3078_grenoble.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"France\",\n" +
                "        \"league_id\": \"177\",\n" +
                "        \"league_name\": \"Ligue 2\",\n" +
                "        \"team_id\": \"3051\",\n" +
                "        \"team_name\": \"Auxerre\",\n" +
                "        \"overall_promotion\": \"Promotion - Ligue 1 (Promotion)\",\n" +
                "        \"overall_league_position\": \"5\",\n" +
                "        \"overall_league_payed\": \"35\",\n" +
                "        \"overall_league_W\": \"15\",\n" +
                "        \"overall_league_D\": \"12\",\n" +
                "        \"overall_league_L\": \"8\",\n" +
                "        \"overall_league_GF\": \"60\",\n" +
                "        \"overall_league_GA\": \"40\",\n" +
                "        \"overall_league_PTS\": \"57\",\n" +
                "        \"home_league_position\": \"5\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"18\",\n" +
                "        \"home_league_W\": \"10\",\n" +
                "        \"home_league_D\": \"5\",\n" +
                "        \"home_league_L\": \"3\",\n" +
                "        \"home_league_GF\": \"37\",\n" +
                "        \"home_league_GA\": \"17\",\n" +
                "        \"home_league_PTS\": \"35\",\n" +
                "        \"away_league_position\": \"7\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"17\",\n" +
                "        \"away_league_W\": \"5\",\n" +
                "        \"away_league_D\": \"7\",\n" +
                "        \"away_league_L\": \"5\",\n" +
                "        \"away_league_GF\": \"23\",\n" +
                "        \"away_league_GA\": \"23\",\n" +
                "        \"away_league_PTS\": \"22\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/3051_auxerre.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"France\",\n" +
                "        \"league_id\": \"177\",\n" +
                "        \"league_name\": \"Ligue 2\",\n" +
                "        \"team_id\": \"3055\",\n" +
                "        \"team_name\": \"Paris FC\",\n" +
                "        \"overall_promotion\": \"\",\n" +
                "        \"overall_league_position\": \"6\",\n" +
                "        \"overall_league_payed\": \"35\",\n" +
                "        \"overall_league_W\": \"15\",\n" +
                "        \"overall_league_D\": \"12\",\n" +
                "        \"overall_league_L\": \"8\",\n" +
                "        \"overall_league_GF\": \"46\",\n" +
                "        \"overall_league_GA\": \"35\",\n" +
                "        \"overall_league_PTS\": \"57\",\n" +
                "        \"home_league_position\": \"6\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"17\",\n" +
                "        \"home_league_W\": \"9\",\n" +
                "        \"home_league_D\": \"5\",\n" +
                "        \"home_league_L\": \"3\",\n" +
                "        \"home_league_GF\": \"25\",\n" +
                "        \"home_league_GA\": \"17\",\n" +
                "        \"home_league_PTS\": \"32\",\n" +
                "        \"away_league_position\": \"4\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"18\",\n" +
                "        \"away_league_W\": \"6\",\n" +
                "        \"away_league_D\": \"7\",\n" +
                "        \"away_league_L\": \"5\",\n" +
                "        \"away_league_GF\": \"21\",\n" +
                "        \"away_league_GA\": \"18\",\n" +
                "        \"away_league_PTS\": \"25\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/3055_paris-fc.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"France\",\n" +
                "        \"league_id\": \"177\",\n" +
                "        \"league_name\": \"Ligue 2\",\n" +
                "        \"team_id\": \"3058\",\n" +
                "        \"team_name\": \"Sochaux\",\n" +
                "        \"overall_promotion\": \"\",\n" +
                "        \"overall_league_position\": \"7\",\n" +
                "        \"overall_league_payed\": \"35\",\n" +
                "        \"overall_league_W\": \"12\",\n" +
                "        \"overall_league_D\": \"15\",\n" +
                "        \"overall_league_L\": \"8\",\n" +
                "        \"overall_league_GF\": \"42\",\n" +
                "        \"overall_league_GA\": \"30\",\n" +
                "        \"overall_league_PTS\": \"51\",\n" +
                "        \"home_league_position\": \"12\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"18\",\n" +
                "        \"home_league_W\": \"6\",\n" +
                "        \"home_league_D\": \"7\",\n" +
                "        \"home_league_L\": \"5\",\n" +
                "        \"home_league_GF\": \"22\",\n" +
                "        \"home_league_GA\": \"19\",\n" +
                "        \"home_league_PTS\": \"25\",\n" +
                "        \"away_league_position\": \"1\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"17\",\n" +
                "        \"away_league_W\": \"6\",\n" +
                "        \"away_league_D\": \"8\",\n" +
                "        \"away_league_L\": \"3\",\n" +
                "        \"away_league_GF\": \"20\",\n" +
                "        \"away_league_GA\": \"11\",\n" +
                "        \"away_league_PTS\": \"26\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/3058_sochaux.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"France\",\n" +
                "        \"league_id\": \"177\",\n" +
                "        \"league_name\": \"Ligue 2\",\n" +
                "        \"team_id\": \"3047\",\n" +
                "        \"team_name\": \"Nancy\",\n" +
                "        \"overall_promotion\": \"\",\n" +
                "        \"overall_league_position\": \"8\",\n" +
                "        \"overall_league_payed\": \"35\",\n" +
                "        \"overall_league_W\": \"11\",\n" +
                "        \"overall_league_D\": \"12\",\n" +
                "        \"overall_league_L\": \"12\",\n" +
                "        \"overall_league_GF\": \"49\",\n" +
                "        \"overall_league_GA\": \"47\",\n" +
                "        \"overall_league_PTS\": \"45\",\n" +
                "        \"home_league_position\": \"13\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"17\",\n" +
                "        \"home_league_W\": \"6\",\n" +
                "        \"home_league_D\": \"7\",\n" +
                "        \"home_league_L\": \"4\",\n" +
                "        \"home_league_GF\": \"25\",\n" +
                "        \"home_league_GA\": \"23\",\n" +
                "        \"home_league_PTS\": \"25\",\n" +
                "        \"away_league_position\": \"9\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"18\",\n" +
                "        \"away_league_W\": \"5\",\n" +
                "        \"away_league_D\": \"5\",\n" +
                "        \"away_league_L\": \"8\",\n" +
                "        \"away_league_GF\": \"24\",\n" +
                "        \"away_league_GA\": \"24\",\n" +
                "        \"away_league_PTS\": \"20\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/3047_nancy.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"France\",\n" +
                "        \"league_id\": \"177\",\n" +
                "        \"league_name\": \"Ligue 2\",\n" +
                "        \"team_id\": \"3033\",\n" +
                "        \"team_name\": \"Amiens\",\n" +
                "        \"overall_promotion\": \"\",\n" +
                "        \"overall_league_position\": \"9\",\n" +
                "        \"overall_league_payed\": \"34\",\n" +
                "        \"overall_league_W\": \"11\",\n" +
                "        \"overall_league_D\": \"11\",\n" +
                "        \"overall_league_L\": \"12\",\n" +
                "        \"overall_league_GF\": \"31\",\n" +
                "        \"overall_league_GA\": \"34\",\n" +
                "        \"overall_league_PTS\": \"44\",\n" +
                "        \"home_league_position\": \"9\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"17\",\n" +
                "        \"home_league_W\": \"7\",\n" +
                "        \"home_league_D\": \"7\",\n" +
                "        \"home_league_L\": \"3\",\n" +
                "        \"home_league_GF\": \"15\",\n" +
                "        \"home_league_GA\": \"9\",\n" +
                "        \"home_league_PTS\": \"28\",\n" +
                "        \"away_league_position\": \"12\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"17\",\n" +
                "        \"away_league_W\": \"4\",\n" +
                "        \"away_league_D\": \"4\",\n" +
                "        \"away_league_L\": \"9\",\n" +
                "        \"away_league_GF\": \"16\",\n" +
                "        \"away_league_GA\": \"25\",\n" +
                "        \"away_league_PTS\": \"16\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/3033_amiens.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"France\",\n" +
                "        \"league_id\": \"177\",\n" +
                "        \"league_name\": \"Ligue 2\",\n" +
                "        \"team_id\": \"3048\",\n" +
                "        \"team_name\": \"Valenciennes\",\n" +
                "        \"overall_promotion\": \"\",\n" +
                "        \"overall_league_position\": \"10\",\n" +
                "        \"overall_league_payed\": \"35\",\n" +
                "        \"overall_league_W\": \"11\",\n" +
                "        \"overall_league_D\": \"11\",\n" +
                "        \"overall_league_L\": \"13\",\n" +
                "        \"overall_league_GF\": \"41\",\n" +
                "        \"overall_league_GA\": \"49\",\n" +
                "        \"overall_league_PTS\": \"44\",\n" +
                "        \"home_league_position\": \"10\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"18\",\n" +
                "        \"home_league_W\": \"7\",\n" +
                "        \"home_league_D\": \"6\",\n" +
                "        \"home_league_L\": \"5\",\n" +
                "        \"home_league_GF\": \"21\",\n" +
                "        \"home_league_GA\": \"18\",\n" +
                "        \"home_league_PTS\": \"27\",\n" +
                "        \"away_league_position\": \"11\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"17\",\n" +
                "        \"away_league_W\": \"4\",\n" +
                "        \"away_league_D\": \"5\",\n" +
                "        \"away_league_L\": \"8\",\n" +
                "        \"away_league_GF\": \"20\",\n" +
                "        \"away_league_GA\": \"31\",\n" +
                "        \"away_league_PTS\": \"17\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/3048_valenciennes.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"France\",\n" +
                "        \"league_id\": \"177\",\n" +
                "        \"league_name\": \"Ligue 2\",\n" +
                "        \"team_id\": \"3043\",\n" +
                "        \"team_name\": \"AC Ajaccio\",\n" +
                "        \"overall_promotion\": \"\",\n" +
                "        \"overall_league_position\": \"11\",\n" +
                "        \"overall_league_payed\": \"35\",\n" +
                "        \"overall_league_W\": \"11\",\n" +
                "        \"overall_league_D\": \"10\",\n" +
                "        \"overall_league_L\": \"14\",\n" +
                "        \"overall_league_GF\": \"33\",\n" +
                "        \"overall_league_GA\": \"42\",\n" +
                "        \"overall_league_PTS\": \"43\",\n" +
                "        \"home_league_position\": \"7\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"18\",\n" +
                "        \"home_league_W\": \"8\",\n" +
                "        \"home_league_D\": \"5\",\n" +
                "        \"home_league_L\": \"5\",\n" +
                "        \"home_league_GF\": \"20\",\n" +
                "        \"home_league_GA\": \"16\",\n" +
                "        \"home_league_PTS\": \"29\",\n" +
                "        \"away_league_position\": \"17\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"17\",\n" +
                "        \"away_league_W\": \"3\",\n" +
                "        \"away_league_D\": \"5\",\n" +
                "        \"away_league_L\": \"9\",\n" +
                "        \"away_league_GF\": \"13\",\n" +
                "        \"away_league_GA\": \"26\",\n" +
                "        \"away_league_PTS\": \"14\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/3043_ac-ajaccio.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"France\",\n" +
                "        \"league_id\": \"177\",\n" +
                "        \"league_name\": \"Ligue 2\",\n" +
                "        \"team_id\": \"3065\",\n" +
                "        \"team_name\": \"Rodez\",\n" +
                "        \"overall_promotion\": \"\",\n" +
                "        \"overall_league_position\": \"12\",\n" +
                "        \"overall_league_payed\": \"35\",\n" +
                "        \"overall_league_W\": \"8\",\n" +
                "        \"overall_league_D\": \"17\",\n" +
                "        \"overall_league_L\": \"10\",\n" +
                "        \"overall_league_GF\": \"36\",\n" +
                "        \"overall_league_GA\": \"41\",\n" +
                "        \"overall_league_PTS\": \"41\",\n" +
                "        \"home_league_position\": \"11\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"18\",\n" +
                "        \"home_league_W\": \"6\",\n" +
                "        \"home_league_D\": \"8\",\n" +
                "        \"home_league_L\": \"4\",\n" +
                "        \"home_league_GF\": \"22\",\n" +
                "        \"home_league_GA\": \"19\",\n" +
                "        \"home_league_PTS\": \"26\",\n" +
                "        \"away_league_position\": \"14\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"17\",\n" +
                "        \"away_league_W\": \"2\",\n" +
                "        \"away_league_D\": \"9\",\n" +
                "        \"away_league_L\": \"6\",\n" +
                "        \"away_league_GF\": \"14\",\n" +
                "        \"away_league_GA\": \"22\",\n" +
                "        \"away_league_PTS\": \"15\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/3065_rodez.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"France\",\n" +
                "        \"league_id\": \"177\",\n" +
                "        \"league_name\": \"Ligue 2\",\n" +
                "        \"team_id\": \"3057\",\n" +
                "        \"team_name\": \"Le Havre\",\n" +
                "        \"overall_promotion\": \"\",\n" +
                "        \"overall_league_position\": \"13\",\n" +
                "        \"overall_league_payed\": \"34\",\n" +
                "        \"overall_league_W\": \"9\",\n" +
                "        \"overall_league_D\": \"14\",\n" +
                "        \"overall_league_L\": \"11\",\n" +
                "        \"overall_league_GF\": \"28\",\n" +
                "        \"overall_league_GA\": \"38\",\n" +
                "        \"overall_league_PTS\": \"41\",\n" +
                "        \"home_league_position\": \"19\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"16\",\n" +
                "        \"home_league_W\": \"3\",\n" +
                "        \"home_league_D\": \"8\",\n" +
                "        \"home_league_L\": \"5\",\n" +
                "        \"home_league_GF\": \"11\",\n" +
                "        \"home_league_GA\": \"16\",\n" +
                "        \"home_league_PTS\": \"17\",\n" +
                "        \"away_league_position\": \"5\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"18\",\n" +
                "        \"away_league_W\": \"6\",\n" +
                "        \"away_league_D\": \"6\",\n" +
                "        \"away_league_L\": \"6\",\n" +
                "        \"away_league_GF\": \"17\",\n" +
                "        \"away_league_GA\": \"22\",\n" +
                "        \"away_league_PTS\": \"24\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/3057_le-havre.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"France\",\n" +
                "        \"league_id\": \"177\",\n" +
                "        \"league_name\": \"Ligue 2\",\n" +
                "        \"team_id\": \"3076\",\n" +
                "        \"team_name\": \"Pau FC\",\n" +
                "        \"overall_promotion\": \"\",\n" +
                "        \"overall_league_position\": \"14\",\n" +
                "        \"overall_league_payed\": \"34\",\n" +
                "        \"overall_league_W\": \"10\",\n" +
                "        \"overall_league_D\": \"9\",\n" +
                "        \"overall_league_L\": \"15\",\n" +
                "        \"overall_league_GF\": \"36\",\n" +
                "        \"overall_league_GA\": \"43\",\n" +
                "        \"overall_league_PTS\": \"39\",\n" +
                "        \"home_league_position\": \"8\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"17\",\n" +
                "        \"home_league_W\": \"8\",\n" +
                "        \"home_league_D\": \"4\",\n" +
                "        \"home_league_L\": \"5\",\n" +
                "        \"home_league_GF\": \"22\",\n" +
                "        \"home_league_GA\": \"16\",\n" +
                "        \"home_league_PTS\": \"28\",\n" +
                "        \"away_league_position\": \"18\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"17\",\n" +
                "        \"away_league_W\": \"2\",\n" +
                "        \"away_league_D\": \"5\",\n" +
                "        \"away_league_L\": \"10\",\n" +
                "        \"away_league_GF\": \"14\",\n" +
                "        \"away_league_GA\": \"27\",\n" +
                "        \"away_league_PTS\": \"11\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/3076_pau.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"France\",\n" +
                "        \"league_id\": \"177\",\n" +
                "        \"league_name\": \"Ligue 2\",\n" +
                "        \"team_id\": \"3059\",\n" +
                "        \"team_name\": \"Niort\",\n" +
                "        \"overall_promotion\": \"\",\n" +
                "        \"overall_league_position\": \"15\",\n" +
                "        \"overall_league_payed\": \"35\",\n" +
                "        \"overall_league_W\": \"9\",\n" +
                "        \"overall_league_D\": \"12\",\n" +
                "        \"overall_league_L\": \"14\",\n" +
                "        \"overall_league_GF\": \"33\",\n" +
                "        \"overall_league_GA\": \"55\",\n" +
                "        \"overall_league_PTS\": \"39\",\n" +
                "        \"home_league_position\": \"15\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"17\",\n" +
                "        \"home_league_W\": \"6\",\n" +
                "        \"home_league_D\": \"5\",\n" +
                "        \"home_league_L\": \"6\",\n" +
                "        \"home_league_GF\": \"16\",\n" +
                "        \"home_league_GA\": \"22\",\n" +
                "        \"home_league_PTS\": \"23\",\n" +
                "        \"away_league_position\": \"13\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"18\",\n" +
                "        \"away_league_W\": \"3\",\n" +
                "        \"away_league_D\": \"7\",\n" +
                "        \"away_league_L\": \"8\",\n" +
                "        \"away_league_GF\": \"17\",\n" +
                "        \"away_league_GA\": \"33\",\n" +
                "        \"away_league_PTS\": \"16\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/3059_niort.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"France\",\n" +
                "        \"league_id\": \"177\",\n" +
                "        \"league_name\": \"Ligue 2\",\n" +
                "        \"team_id\": \"3032\",\n" +
                "        \"team_name\": \"Guingamp\",\n" +
                "        \"overall_promotion\": \"\",\n" +
                "        \"overall_league_position\": \"16\",\n" +
                "        \"overall_league_payed\": \"35\",\n" +
                "        \"overall_league_W\": \"7\",\n" +
                "        \"overall_league_D\": \"17\",\n" +
                "        \"overall_league_L\": \"11\",\n" +
                "        \"overall_league_GF\": \"34\",\n" +
                "        \"overall_league_GA\": \"43\",\n" +
                "        \"overall_league_PTS\": \"38\",\n" +
                "        \"home_league_position\": \"18\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"18\",\n" +
                "        \"home_league_W\": \"3\",\n" +
                "        \"home_league_D\": \"10\",\n" +
                "        \"home_league_L\": \"5\",\n" +
                "        \"home_league_GF\": \"17\",\n" +
                "        \"home_league_GA\": \"23\",\n" +
                "        \"home_league_PTS\": \"19\",\n" +
                "        \"away_league_position\": \"10\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"17\",\n" +
                "        \"away_league_W\": \"4\",\n" +
                "        \"away_league_D\": \"7\",\n" +
                "        \"away_league_L\": \"6\",\n" +
                "        \"away_league_GF\": \"17\",\n" +
                "        \"away_league_GA\": \"20\",\n" +
                "        \"away_league_PTS\": \"19\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/3032_guingamp.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"France\",\n" +
                "        \"league_id\": \"177\",\n" +
                "        \"league_name\": \"Ligue 2\",\n" +
                "        \"team_id\": \"3028\",\n" +
                "        \"team_name\": \"Caen\",\n" +
                "        \"overall_promotion\": \"\",\n" +
                "        \"overall_league_position\": \"17\",\n" +
                "        \"overall_league_payed\": \"35\",\n" +
                "        \"overall_league_W\": \"8\",\n" +
                "        \"overall_league_D\": \"13\",\n" +
                "        \"overall_league_L\": \"14\",\n" +
                "        \"overall_league_GF\": \"32\",\n" +
                "        \"overall_league_GA\": \"45\",\n" +
                "        \"overall_league_PTS\": \"37\",\n" +
                "        \"home_league_position\": \"14\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"17\",\n" +
                "        \"home_league_W\": \"5\",\n" +
                "        \"home_league_D\": \"8\",\n" +
                "        \"home_league_L\": \"4\",\n" +
                "        \"home_league_GF\": \"15\",\n" +
                "        \"home_league_GA\": \"18\",\n" +
                "        \"home_league_PTS\": \"23\",\n" +
                "        \"away_league_position\": \"16\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"18\",\n" +
                "        \"away_league_W\": \"3\",\n" +
                "        \"away_league_D\": \"5\",\n" +
                "        \"away_league_L\": \"10\",\n" +
                "        \"away_league_GF\": \"17\",\n" +
                "        \"away_league_GA\": \"27\",\n" +
                "        \"away_league_PTS\": \"14\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/3028_caen.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"France\",\n" +
                "        \"league_id\": \"177\",\n" +
                "        \"league_name\": \"Ligue 2\",\n" +
                "        \"team_id\": \"3064\",\n" +
                "        \"team_name\": \"Dunkerque\",\n" +
                "        \"overall_promotion\": \"Ligue 2 (Relegation)\",\n" +
                "        \"overall_league_position\": \"18\",\n" +
                "        \"overall_league_payed\": \"34\",\n" +
                "        \"overall_league_W\": \"9\",\n" +
                "        \"overall_league_D\": \"9\",\n" +
                "        \"overall_league_L\": \"16\",\n" +
                "        \"overall_league_GF\": \"29\",\n" +
                "        \"overall_league_GA\": \"41\",\n" +
                "        \"overall_league_PTS\": \"36\",\n" +
                "        \"home_league_position\": \"16\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"16\",\n" +
                "        \"home_league_W\": \"5\",\n" +
                "        \"home_league_D\": \"6\",\n" +
                "        \"home_league_L\": \"5\",\n" +
                "        \"home_league_GF\": \"17\",\n" +
                "        \"home_league_GA\": \"14\",\n" +
                "        \"home_league_PTS\": \"21\",\n" +
                "        \"away_league_position\": \"15\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"18\",\n" +
                "        \"away_league_W\": \"4\",\n" +
                "        \"away_league_D\": \"3\",\n" +
                "        \"away_league_L\": \"11\",\n" +
                "        \"away_league_GF\": \"12\",\n" +
                "        \"away_league_GA\": \"27\",\n" +
                "        \"away_league_PTS\": \"15\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/3064_dunkerque.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"France\",\n" +
                "        \"league_id\": \"177\",\n" +
                "        \"league_name\": \"Ligue 2\",\n" +
                "        \"team_id\": \"3071\",\n" +
                "        \"team_name\": \"Chambly\",\n" +
                "        \"overall_promotion\": \"Relegation\",\n" +
                "        \"overall_league_position\": \"19\",\n" +
                "        \"overall_league_payed\": \"35\",\n" +
                "        \"overall_league_W\": \"7\",\n" +
                "        \"overall_league_D\": \"11\",\n" +
                "        \"overall_league_L\": \"17\",\n" +
                "        \"overall_league_GF\": \"36\",\n" +
                "        \"overall_league_GA\": \"59\",\n" +
                "        \"overall_league_PTS\": \"32\",\n" +
                "        \"home_league_position\": \"17\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"18\",\n" +
                "        \"home_league_W\": \"6\",\n" +
                "        \"home_league_D\": \"3\",\n" +
                "        \"home_league_L\": \"9\",\n" +
                "        \"home_league_GF\": \"20\",\n" +
                "        \"home_league_GA\": \"27\",\n" +
                "        \"home_league_PTS\": \"21\",\n" +
                "        \"away_league_position\": \"19\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"17\",\n" +
                "        \"away_league_W\": \"1\",\n" +
                "        \"away_league_D\": \"8\",\n" +
                "        \"away_league_L\": \"8\",\n" +
                "        \"away_league_GF\": \"16\",\n" +
                "        \"away_league_GA\": \"32\",\n" +
                "        \"away_league_PTS\": \"11\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/3071_chambly.png\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"country_name\": \"France\",\n" +
                "        \"league_id\": \"177\",\n" +
                "        \"league_name\": \"Ligue 2\",\n" +
                "        \"team_id\": \"3061\",\n" +
                "        \"team_name\": \"Chateauroux\",\n" +
                "        \"overall_promotion\": \"Relegation\",\n" +
                "        \"overall_league_position\": \"20\",\n" +
                "        \"overall_league_payed\": \"34\",\n" +
                "        \"overall_league_W\": \"4\",\n" +
                "        \"overall_league_D\": \"10\",\n" +
                "        \"overall_league_L\": \"20\",\n" +
                "        \"overall_league_GF\": \"30\",\n" +
                "        \"overall_league_GA\": \"52\",\n" +
                "        \"overall_league_PTS\": \"22\",\n" +
                "        \"home_league_position\": \"20\",\n" +
                "        \"home_promotion\": \"\",\n" +
                "        \"home_league_payed\": \"17\",\n" +
                "        \"home_league_W\": \"3\",\n" +
                "        \"home_league_D\": \"4\",\n" +
                "        \"home_league_L\": \"10\",\n" +
                "        \"home_league_GF\": \"20\",\n" +
                "        \"home_league_GA\": \"29\",\n" +
                "        \"home_league_PTS\": \"13\",\n" +
                "        \"away_league_position\": \"20\",\n" +
                "        \"away_promotion\": \"\",\n" +
                "        \"away_league_payed\": \"17\",\n" +
                "        \"away_league_W\": \"1\",\n" +
                "        \"away_league_D\": \"6\",\n" +
                "        \"away_league_L\": \"10\",\n" +
                "        \"away_league_GF\": \"10\",\n" +
                "        \"away_league_GA\": \"23\",\n" +
                "        \"away_league_PTS\": \"9\",\n" +
                "        \"league_round\": \"\",\n" +
                "        \"team_badge\": \"https://apiv2.apifootball.com/badges/3061_chateauroux.png\"\n" +
                "    }\n" +
                "]";
        Mockito.when(restTemplate.getForObject("https://apiv2.apifootball.com/?action=get_leagues&APIkey=12", String.class))
                .thenReturn(leagueStatusResp);
        Mockito.when(restTemplate.getForObject("https://apiv2.apifootball.com/?action=get_standings&league_id=149&APIkey=12", String.class))
                .thenReturn(leagueIdResp1);
        Mockito.when(restTemplate.getForObject("https://apiv2.apifootball.com/?action=get_standings&league_id=177&APIkey=12", String.class))
                .thenReturn(leagueIdResp2);
    }


}
