package com.example.springbootlecture.MyConfig;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI swagger(){
        Info info = new Info();
        info.title("spring boot lectur api")
                .version("1.0.0") //API의 버전 따라감
                .description("Hi");
        return new OpenAPI().info(info);
    }


}
