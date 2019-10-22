package com.example.wy.web.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * spring security 处理session失效和维登录的异常处理
 * @author wuyang
 * @version 1.0
 * @date 2019/9/18 16:46
 */
@RestController
public class SessionController {
    @RequestMapping("/session/invalid")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public String SessionInvalid(){
        System.out.println("session失效");
        return "session失效";
    }

    @RequestMapping("/login_page")
    public String Login(){
        return "请登录";
    }
}
