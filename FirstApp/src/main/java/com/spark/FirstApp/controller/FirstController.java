package com.spark.FirstApp.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/genie")
public class FirstController {


            @GetMapping("/test")
            public String kaiseHo()
            {
                return "Kaise ho bhaiya...";
            }

}
