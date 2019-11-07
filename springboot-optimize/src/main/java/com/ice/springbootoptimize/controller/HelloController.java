package com.ice.springbootoptimize.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author liubin
 * @Date 2019/11/6 3:16 PM
 **/
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello world!";
    }
}
