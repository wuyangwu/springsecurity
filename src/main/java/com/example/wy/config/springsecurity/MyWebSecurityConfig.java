package com.example.wy.config.springsecurity;

import com.example.wy.web.service.UserService;
import com.example.wy.web.util.AuthenticationAccessDeniedHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wuyang
 * @version 1.0
 * @date 2019/8/19 14:43
 */
@Configuration
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationAccessDeniedHandler authenticationAccessDeniedHandler;

    @Bean
    PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder();
    }



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userService);
//        auth.inMemoryAuthentication()
//                .withUser("root").password("123").roles("ADMIN", "DBA")
//                .and()
//                .withUser("admin").password("123").roles("ADMIN","USER")
//                .and()
//                .withUser("sang").password("123").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/admin/**").hasRole("admin")
//                .antMatchers("/admin/**").hasRole("dba")
//                .antMatchers("/user/**").hasRole("user")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginProcessingUrl("/login").permitAll()
//                .and()
//                .csrf().disable();
        http.authorizeRequests()
                .antMatchers("/admin/**")
                .hasRole("ADMIN")
                .antMatchers("/user/**")
                .access("hasAnyRole('ADMIN','USER')")
                .antMatchers("/db/**")
                .access("hasRole('ADMIN') and hasRole('DBA')")
                .antMatchers("/permit/**").permitAll()
                .antMatchers("/session/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login_page")
                .loginProcessingUrl("/login")
                .usernameParameter("name")
                .passwordParameter("passwd")
                .successHandler(new AuthenticationSuccessHandler() {
                    // 登录成功处理
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        Object principal = authentication.getPrincipal();
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        PrintWriter out = httpServletResponse.getWriter();
                        httpServletResponse.setStatus(200);
                        Map<String, Object> map = new HashMap<String, Object>();
                        map.put("status",200);
                        map.put("msg",principal);
                        ObjectMapper om = new ObjectMapper();
                        out.write(om.writeValueAsString(map));
                        out.flush();
                        out.close();
                    }
                })
                .failureHandler(new AuthenticationFailureHandler() {
                    // 登录失败处理
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json:charset=utf-8");
                        PrintWriter out = httpServletResponse.getWriter();
                        httpServletResponse.setStatus(200);
                        Map<String, Object> map = new HashMap<String, Object>();
                        map.put("status",401);
                        if(e instanceof LockedException) {
                            map.put("msg","帐号锁定，登陆失败");
                        } else if ( e instanceof BadCredentialsException) {
                            map.put("msg","帐号名或密码输入错误，登陆失败");
                        } else if (e instanceof DisabledException) {
                            map.put("msg", "帐号被禁用，登陆失败");
                        } else if (e instanceof AccountExpiredException) {
                            map.put("msg", "帐号已过期，登陆失败");
                        } else if (e instanceof CredentialsExpiredException) {
                            map.put("msg", "密码已过期，登陆失败");
                        } else {
                            map.put("msg", "登陆失败");
                        }
                        ObjectMapper om = new ObjectMapper();
                        out.write(om.writeValueAsString(map));
                        out.flush();
                        out.close();
                    }
                })
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .addLogoutHandler(new LogoutHandler() {
                    // 注销接口
                    @Override
                    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {

                    }
                })
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    // 注销成功后的业务处理
                    @Override
                    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        httpServletResponse.sendRedirect("/login");
                    }
                })
                .and()
                .csrf()
                .disable();
        // session管理
        // session失效后跳转的url
        http.sessionManagement().invalidSessionUrl("/session/invalid");
        // 权限不足异常
        http.exceptionHandling().accessDeniedHandler(authenticationAccessDeniedHandler);
    }

}
