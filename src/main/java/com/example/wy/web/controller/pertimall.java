package com.example.wy.web.controller;

import com.alibaba.fastjson.JSONArray;
import com.example.wy.entity.Menu;
import com.example.wy.web.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * @author wuyang
 * @version 1.0
 * @date 2019/9/10 20:22
 */
@RestController
@RequestMapping("/permit")
public class pertimall {
    @Autowired
    private MenuService menuService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/all")
    public String permit(String a, HttpServletRequest request) {

        return "helloword"+a;
    }
    // 测试menu菜单
    @GetMapping("/RoleOrMenu")
    public JSONArray getRoleOrMenu(String username){
        System.out.println(username);
        return menuService.getRolerorMenu(username);
    }
    // 测试密码加密
    @GetMapping("/password")
    public String password(String password){
        return passwordEncoder.encode(password);
    }
}
