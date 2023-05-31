package com.example.tcm_kgsystem.interceptor;

import com.example.tcm_kgsystem.service.Util.JWTUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JWTInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getMethod().equals("OPTIONS")) {
            return true;
        }
        String token = request.getHeader("token");
        response.setContentType("text/html;charset=UTF-8");

        if(JWTUtil.verify(token)){
            return true;
        }
        else{
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.setHeader("msg","token");
            return false;
        }
    }
}
