package com.example.springbootlecture.MyConfig;

import com.example.springbootlecture.controller.MyController;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Component
public class MyConfig {
    @Bean
    public void config(){

    }
}
