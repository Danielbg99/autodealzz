package com.project.autodealz.web.controller;

import com.project.autodealz.data.models.UserEditBindingModel;
import com.project.autodealz.data.models.UserRegisterBindingModel;
import com.project.autodealz.data.models.view.UserProfileViewModel;
import com.project.autodealz.service.UserService;
import com.project.autodealz.service.models.UserServiceModel;
import com.project.autodealz.validations.UserRegisterValidator;
import com.project.autodealz.web.annotations.PageTitle;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController{

    private final UserService userService;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserRegisterValidator userRegisterValidator;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper, BCryptPasswordEncoder passwordEncoder, UserRegisterValidator userRegisterValidator) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.userRegisterValidator = userRegisterValidator;
    }

    @GetMapping("/register")
    public ModelAndView register(ModelAndView modelAndView, @ModelAttribute(name = "model") UserRegisterBindingModel model) {
        modelAndView.addObject("model", model);
        modelAndView.setViewName("user/register.html");
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView registerConfirm(@ModelAttribute(name = "model") UserRegisterBindingModel model, ModelAndView modelAndView,BindingResult bindingResult) {
        this.userRegisterValidator.validate(model, bindingResult);

        if (bindingResult.hasErrors()) {
            model.setPassword(null);
            model.setConfirmPassword(null);
            modelAndView.addObject("model", model);


//        if (!model.getPassword().equals(model.getConfirmPassword())) {
            modelAndView.setViewName("user/register");
            return modelAndView;
//        }
        }

        userService.register(modelMapper.map(model, UserServiceModel.class));
        return redirect("user/login");
    }
    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName("user/login.html");
        return modelAndView;
    }
    @GetMapping("/profile")
    @PreAuthorize("isAuthenticated()")
    @PageTitle("Profile")
    public ModelAndView profile(Principal principal, ModelAndView modelAndView){
        modelAndView
                .addObject("model", this.modelMapper
                        .map(this.userService.findUserByUserName(principal.getName()), UserProfileViewModel.class));
        return super.view("user/profile.html", modelAndView);
    }
    @GetMapping("/edit")
    @PreAuthorize("isAuthenticated()")
    @PageTitle("Edit User")
    public ModelAndView editProfile(Principal principal, ModelAndView modelAndView) {
        modelAndView
                .addObject("model", this.modelMapper.map
                        (this.userService.findUserByUserName(principal.getName()), UserProfileViewModel.class));
        modelAndView.setViewName("user/edit-profile.html");
        return modelAndView;
    }
    @PostMapping("/edit")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView editProfileConfirm(@ModelAttribute UserEditBindingModel model){
        if (!model.getPassword().equals(model.getConfirmPassword())){
            return super.view("user/edit-profile");
        }

        this.userService.editUserProfile(this.modelMapper.map(model, UserServiceModel.class), model.getOldPassword());

        return super.redirect("/users/profile");
    }

    @GetMapping("/fanshop")
    @PreAuthorize("isAuthenticated()")
    public void fanshopRedirect(Authentication authentication, HttpServletResponse response) {
        response.addHeader("SM_USER", authentication.getName());
        response.addHeader("Location", "http://localhost:1022/create");
        response.setStatus(302);
    }
}
