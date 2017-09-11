package com.keessi.springMVC_tutorial.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        System.out.println("---------LogInterceptor.preHandle----------");
        System.out.println("REQUEST URL : " + request.getRequestURL());
        System.out.println("START TIME : " + System.currentTimeMillis());
        request.setAttribute("startTime", startTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("--------LogInterceptor.postHandle----------");
        System.out.println("REQUEST URL : " + request.getRequestURL());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("--------LogInterceptor.afterCompletion-----");
        long startTime = (long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        System.out.println("REQUEST URL : " + request.getRequestURL());
        System.out.println("END TIME : " + endTime);
        System.out.println("TIME TAKEN : " + (endTime - startTime));
    }
}
