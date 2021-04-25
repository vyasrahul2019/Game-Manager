package com.microservice.demo.model;

import lombok.Data;

@Data
public class FootballMatchInformation {
    private String countryId;
    private String countryName;
    private String leagueId;
    private String leagueInfo;
    private String teamId;
    private String teamInfo;
    private String leaguePosition;

    public FootballMatchInformation(String countryId, String countryName, String leagueId, String leagueInfo, String teamId, String teamInfo, String leaguePosition) {
        this.countryId = countryId;
        this.countryName = countryName;
        this.leagueId = leagueId;
        this.leagueInfo = leagueInfo;
        this.teamId = teamId;
        this.teamInfo = teamInfo;
        this.leaguePosition = leaguePosition;
    }

    public FootballMatchInformation(){}
}
