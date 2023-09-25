package com.example.springbootlecture.controller;

import com.example.springbootlecture.MyConfig.MyConfig;
import com.example.springbootlecture.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    /*Constructor 주입 */
    private final MyService myService;
    private final MyConfig myConfig;

    @Autowired
    public MyController(MyService myService, MyConfig myConfig){
        this.myService = myService;
        this.myConfig = myConfig;
    }

    /*field 주입
    @Autowired
    private MyService myService;

    @Autowired
    private MyConfig myConfig;*/

   // @RequestMapping(method = org.springframework.web.bind.annotation.RequstMethod.GET ,"/teest");



}
