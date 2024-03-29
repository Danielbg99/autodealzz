package com.project.autodealz.web.interseptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class FaviconInterceptor extends HandlerInterceptorAdapter {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String link = "data:image/png;base64,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";

        if (modelAndView != null) {
            modelAndView.addObject("favicon", link);
        }
    }
}
