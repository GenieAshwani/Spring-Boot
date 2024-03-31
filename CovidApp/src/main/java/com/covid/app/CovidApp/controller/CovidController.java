package com.covid.app.CovidApp.controller;


import com.covid.app.CovidApp.service.CovidDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/covid-data")
public class CovidController {


    @Autowired
    CovidDataService covidDataService;

    //localhost:8080/covid-data/citywise/delhi
    @GetMapping("/citywise/{city}")
    public String getCovidCases(@PathVariable String city)
    {
        Integer covidData = covidDataService.getCovidData(city);
        return "Covid Active Cases in "+city +" = "+covidData;
    }

}

















