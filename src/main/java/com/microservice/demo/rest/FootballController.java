package com.microservice.demo.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.microservice.demo.api_int.FootballService;
import com.microservice.demo.model.FootballMatchInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/football")
public class FootballController {
    private static final List<FootballMatchInformation> footballs = new ArrayList<>();

    @Autowired
    private FootballService footballService;

    @GetMapping("/get/info")
    @ResponseBody
    public List<FootballMatchInformation> getFootBallMatchInformationResponse() throws JsonProcessingException {
        return footballService.getAllFootBallMatchInformation();
    }

}
