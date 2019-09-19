package com.example.wy.web.controller;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

/**
 * @author wuyang
 * @version 1.0
 * @date 2019/9/10 20:22
 */
@RestController
public class pertimall {

    @GetMapping("/permit/all")
    public String permit(String a, HttpServletRequest request) {

        return "helloword"+a;
    }
}
