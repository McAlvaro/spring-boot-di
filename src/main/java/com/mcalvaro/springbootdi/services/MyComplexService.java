package com.mcalvaro.springbootdi.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("MyComplexService")
@Primary
public class MyComplexService implements IService {

	@Override
	public String run() {
        return "Running a complex process";
	}
 
}
