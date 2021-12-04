package com.djn.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 * @author ChristmasKey
 * @date 2021-12-04-21:54
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        if (request.getSession().getAttribute("user") == null) { //用户未登录
            request.setAttribute("message", "你还没有登录，请登录");
            request.getRequestDispatcher("/admin").forward(request, response);
            return false;
        }

        //用户已登录
        return true;
    }
}