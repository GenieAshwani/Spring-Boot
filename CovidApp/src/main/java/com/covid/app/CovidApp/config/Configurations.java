package com.covid.app.CovidApp.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Configurations {


    @Bean
    public RestTemplate getInstance()
    {
        return new RestTemplate();
    }
}
