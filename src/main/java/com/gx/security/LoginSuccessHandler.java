//package com.gx.security;
//
//import cn.hutool.json.JSONUtil;
//import com.baomidou.mybatisplus.extension.api.R;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//public class LoginSuccessHandler implements AuthenticationSuccessHandler {
//
//    //@Autowired
//    //JwtUtil jwtUtil;
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//
//        response.setContentType("application/json;charset=UTF-8");
//        ServletOutputStream outputStream = response.getOutputStream();
//
//        //生成jwt
//        UserLogin userLogin = (UserLogin)authentication.getPrincipal();
//        //String token = jwtUtil.setToken(userLogin.getUserId().toString());
//        //response.setHeader(jwtUtil.getHeader(),token);
//        R r = R.ok(userLogin.getUserId()).setMsg("登录成功").setCode(1);
//
//        outputStream.write(JSONUtil.toJsonStr(r).getBytes("UTF-8"));
//        outputStream.flush();
//        outputStream.close();
//    }
//}
