package com.example.wy.web.util;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;

/**
 * 无效的方法
 * 全局异常处理用户权限不足
 * @author wuyang
 * @version 1.0
 * @date 2019/9/18 19:25
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = AccessDeniedException.class)
    public void AccessDeniedExceptionHandler(AccessDeniedException a){
        System.out.println("权限不足");
    }
}
