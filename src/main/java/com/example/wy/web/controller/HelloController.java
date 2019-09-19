package com.example.wy.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuyang
 * @version 1.0
 * @date 2019/8/19 16:01
 */
@RestController
public class HelloController {
    @GetMapping("/admin/hello")
    public String admin() {
        return "hello admin!";
    }

    @GetMapping("/user/hello")
    public String user(){
        return "hello user";
    }

    @GetMapping("/db/hello")
    public String dba(){
        return "hello dba!";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
