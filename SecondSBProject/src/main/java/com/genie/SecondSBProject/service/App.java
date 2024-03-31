package com.genie.SecondSBProject.service;

import com.genie.SecondSBProject.component.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class App {

    @Autowired
    @Qualifier("PE")
    Engine engine;


    public void drive()
    {
        int res = engine.start();
        if(res>=1)
        {
            System.out.println("Drive Started.........");
        }
        else{
            System.out.println("Engine kharab hai....");
        }
    }
}
