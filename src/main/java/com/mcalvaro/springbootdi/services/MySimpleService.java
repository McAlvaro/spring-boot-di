package com.mcalvaro.springbootdi.services;

import org.springframework.stereotype.Component;

@Component("MySimpleService")
public class MySimpleService implements IService {

    @Override
    public String run() {
        return "Running a simple process";
    }
}
