package com.gx.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //@Autowired  //登录成功
    //LoginFailureHandler loginFailureHandler;
    //
    //@Autowired  //登录失败
    //LoginSuccessHandler loginSuccessHandler;
    //
    //@Autowired  //登录异常
    //JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    //
    //@Autowired  //权限异常
    //JwtAccessDeniedHandler jwtAccessDeniedHandler;

    //@Autowired  //实现类
    //UserDetailsServiceImpl userDetailsService;

    @Bean       //过滤器
    JwtAuthorizationFilter jwtAuthorizationFilter() throws Exception {
        JwtAuthorizationFilter jwtAuthorizationFilter = new JwtAuthorizationFilter(authenticationManager());
        return jwtAuthorizationFilter;
    }

    //@Bean       //加密
    //BCryptPasswordEncoder bCryptPasswordEncoder(){
    //    return new BCryptPasswordEncoder();
    //}

    //@Autowired  //验证码
    //CaptchaFilter captchaFilter;

    private static final String[] URL_WHITELIST = {
            "/login","/user/login","/user/logout","/user/register"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                //登录配置
                .formLogin()
                //.successHandler(loginSuccessHandler)
                //.failureHandler(loginFailureHandler)
                //禁用session
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                //配置拦截规则
                .and().authorizeRequests()
                .antMatchers(URL_WHITELIST).permitAll()
                //.anyRequest().authenticated()
                //异常处理器
                //.and().exceptionHandling()
                //.authenticationEntryPoint(jwtAuthenticationEntryPoint)
                //.accessDeniedHandler(jwtAccessDeniedHandler)
                //配置过滤器
                //.and().addFilterBefore(captchaFilter, UsernamePasswordAuthenticationFilter.class);
                .and().addFilter(jwtAuthorizationFilter());
    }

    //@Override
    //protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //    auth.userDetailsService(userDetailsService);
    //}
}
