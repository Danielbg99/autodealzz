package com.project.autodealz.web.controller;

import com.project.autodealz.data.repository.ArticleRepository;
import com.project.autodealz.data.repository.FanShopRepository;
import com.project.autodealz.service.ArticleService;
import com.project.autodealz.service.FanShopService;
import com.project.autodealz.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/fanShop")
public class FanShopController {

    private final ModelMapper modelMapper;
    private final ArticleService articleService;
    private final FanShopService fanShopService;
    private final UserService userService;
    private final ArticleRepository articleRepository;
    private final FanShopRepository fanShopRepository;

    @Autowired
    public FanShopController(ModelMapper modelMapper, ArticleService articleService, FanShopService fanShopService, UserService userService, ArticleRepository articleRepository, FanShopRepository fanShopRepository) {
        this.modelMapper = modelMapper;
        this.articleService = articleService;
        this.fanShopService = fanShopService;
        this.userService = userService;
        this.articleRepository = articleRepository;
        this.fanShopRepository = fanShopRepository;
    }

    @GetMapping("/create")
    public ModelAndView createArticle(ModelAndView modelAndView) {
        modelAndView.setViewName("fanShop/createArticle");
        return modelAndView;
    }

}
