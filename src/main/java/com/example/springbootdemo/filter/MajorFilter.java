package com.example.springbootdemo.filter;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class MajorFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        CustomedHttpServletRequest customedHttpServletRequest = new CustomedHttpServletRequest((HttpServletRequest) servletRequest);
        String token = customedHttpServletRequest.getHeader("token");
        if (!StringUtils.isEmpty(token)) {
            customedHttpServletRequest.addHeader("new_token", token + "my_auth");
        }
        System.out.println("-----use filter to change http request header------");
        // 需要创建个定制的request来添加设置header的方法，同时重写父request的获取header的方法
        filterChain.doFilter(customedHttpServletRequest, servletResponse);
    }
}
