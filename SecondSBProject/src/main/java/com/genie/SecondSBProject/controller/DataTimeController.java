package com.genie.SecondSBProject.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("check")
public class DataTimeController {


    @GetMapping("/dataTime")
    public String getDataAndTime()
    {
        LocalDateTime currTime=LocalDateTime.now();
        return ""+currTime;

    }
}
