package com.project.autodealz.web.interseptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@Component
public class WelcomingInterceptor extends HandlerInterceptorAdapter {

//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//
//
//
//        super.postHandle(request, response, handler, modelAndView);
//    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Principal userPrincipal = request.getUserPrincipal();

        String username = userPrincipal == null ? "guest" : userPrincipal.getName();

        String attribute = "Welcome, " + username;
        request.getSession().setAttribute("WelcomingMessage",attribute);



        return super.preHandle(request, response, handler);
    }
}
