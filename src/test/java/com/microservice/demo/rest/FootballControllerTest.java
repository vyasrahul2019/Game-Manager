package com.microservice.demo.rest;

import com.microservice.demo.api_int.FootballService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class FootballControllerTest {

    public static final String URL_FOOTBALL_INFO = "/football/get/info";

    @Mock
    private FootballService footballService;

    @InjectMocks
    FootballController footballController = new FootballController();

    private MockMvc mockMvc;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(footballController, footballService).build();
    }

    @Test
    public void shouldGetFootBallMatchInfoFromAPICall() throws Exception{
        mockMvc.perform(get(URL_FOOTBALL_INFO).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

}



