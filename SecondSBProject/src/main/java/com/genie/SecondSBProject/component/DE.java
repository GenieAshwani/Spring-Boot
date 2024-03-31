package com.genie.SecondSBProject.component;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class DE implements Engine{
    @Override
    public int start() {
        return 1;
    }


    DE()
    {
        System.out.println("DE cons.........");
    }
    @PostConstruct
    public void getDataFromDb()
    {
        System.out.println("getting data from db.....");
    }


    @PreDestroy
    public void destroy()
    {
        System.out.println("running before destroy....");
    }

}
