package com.microservice.demo.api_int;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.microservice.demo.model.FootballMatchInformation;

import java.util.List;

public interface FootballService {
    public List<FootballMatchInformation> getAllFootBallMatchInformation() throws JsonProcessingException;
}
