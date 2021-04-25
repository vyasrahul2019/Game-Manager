package com.microservice.demo.model;

import lombok.Data;


public class TeamInfo {
    private String team_id;
    private String team_name;
    private String overall_league_position;

    public TeamInfo(String team_id, String team_name, String overall_league_position) {
        this.team_id = team_id;
        this.team_name = team_name;
        this.overall_league_position = overall_league_position;
    }

    public TeamInfo() {}

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getOverall_league_position() {
        return overall_league_position;
    }

    public void setOverall_league_position(String overall_league_position) {
        this.overall_league_position = overall_league_position;
    }
}
