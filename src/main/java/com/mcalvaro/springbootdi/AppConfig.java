package com.mcalvaro.springbootdi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.mcalvaro.springbootdi.services.IService;
import com.mcalvaro.springbootdi.services.MyComplexService;
import com.mcalvaro.springbootdi.services.MySimpleService;

@Configuration
public class AppConfig {
 
    @Bean("MySimpleService")
    public IService registerMySimpleService() {
        return new MySimpleService();
    }

    @Bean("MyComplexService")
    @Primary
    public IService registerMyComplexService() {
        return new MyComplexService();
    }
}
