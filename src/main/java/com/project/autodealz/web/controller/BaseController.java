package com.project.autodealz.web.controller;

import com.project.autodealz.service.models.UserServiceModel;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

public abstract class BaseController {

    public ModelAndView view(String viewName, ModelAndView modelAndView) {
        modelAndView.setViewName(viewName);

        return modelAndView;
    }

    public ModelAndView view(String viewName) {
        return this.view(viewName, new ModelAndView());
    }

    public ModelAndView redirect(String url) {
        return this.view("redirect:" + url);
    }
}
