package com.project.autodealz.web.controller;

import com.project.autodealz.data.repository.BrandRepository;
import com.project.autodealz.data.repository.CarModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class HomeController extends BaseController {

    private final BrandRepository brandRepository;

    private final CarModelRepository carModelRepository;

    @Autowired
    public HomeController(BrandRepository repository, CarModelRepository carModelRepository) {
        this.brandRepository = repository;
        this.carModelRepository = carModelRepository;
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView){
        modelAndView.setViewName("index.html");
        return modelAndView;
    }
    @GetMapping("/home")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView home(ModelAndView modelAndView) {
        modelAndView.addObject("brands", this.brandRepository.findAll());
        modelAndView.addObject("carModels", this.carModelRepository.findAll());
        modelAndView.setViewName("home.html");
        return modelAndView;
    }
}
