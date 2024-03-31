package com.genie.SecondSBProject.controller;


import com.genie.SecondSBProject.service.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //for denoting it as rest controller
@RequestMapping("engine") // for giving end point
public class EngineController {

    @Autowired

    App app; //instance variable

    @GetMapping("/checkEngine")
    public void checkEngine()
    {
        app.drive();
    }

}
