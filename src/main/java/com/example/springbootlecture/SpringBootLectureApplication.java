package com.example.springbootlecture;

import com.example.springbootlecture.MyConfig.MyConfig;
import com.example.springbootlecture.MyConfig.MyConfigProto;
import com.example.springbootlecture.controller.MyController;
import com.example.springbootlecture.ioc.Chef;
import com.example.springbootlecture.ioc.IngredientFactory;
import com.example.springbootlecture.ioc.PrintBeans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootLectureApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootLectureApplication.class, args);


	}

}
