package com.mcalvaro.springbootdi;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.mcalvaro.springbootdi.domain.ItemInvoice;
import com.mcalvaro.springbootdi.domain.Product;
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

    @Bean
    public List<ItemInvoice> registerItems() {

        Product product1 = new Product("Corne Keyboard", 150);
        Product product2 = new Product("Soffle Keyboard", 250);

        ItemInvoice item1 = new ItemInvoice(product1, 2);
        ItemInvoice item2 = new ItemInvoice(product2 ,5);

        return Arrays.asList(item1, item2);
    }
}
