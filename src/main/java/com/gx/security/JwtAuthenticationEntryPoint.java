//package com.gx.security;
//
//import cn.hutool.json.JSONUtil;
//import com.baomidou.mybatisplus.extension.api.R;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
//        response.setContentType("application/json;charset=UTF-8");
//        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//
//        ServletOutputStream outputStream = response.getOutputStream();
//        R r = R.failed("未登录！");
//        outputStream.write(JSONUtil.toJsonStr(r).getBytes("UTF-8"));
//        outputStream.flush();
//        outputStream.close();
//    }
//}
