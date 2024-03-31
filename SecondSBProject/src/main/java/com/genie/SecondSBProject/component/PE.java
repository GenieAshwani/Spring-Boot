package com.genie.SecondSBProject.component;


import org.springframework.stereotype.Component;

@Component
public class PE implements Engine{
    @Override
    public int start() {
        return 1;
    }
}
