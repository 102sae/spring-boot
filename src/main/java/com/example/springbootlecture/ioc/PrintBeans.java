package com.example.springbootlecture.ioc;

import com.example.springbootlecture.MyConfig.MyConfig;
import com.example.springbootlecture.MyConfig.MyConfigProto;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PrintBeans {
    private final ApplicationContext applicationContext;
    private final MyConfig myConfig;
    private final MyConfigProto myConfigProto;

    @Bean
    public void PrintBeansMethod(){

        System.out.println(applicationContext);
        System.out.println(myConfig);
        System.out.println(myConfig);

        System.out.println(myConfigProto);
        System.out.println(myConfigProto);
        System.out.println(myConfigProto);
//
//        List<String> beans = Arrays.stream(applicationContext.getBeanDefinitionNames()).toList();
//
//        for(String beanName: beans)
//        {
//            System.out.println(beanName);
//        }
//        System.out.println();
    }
}
