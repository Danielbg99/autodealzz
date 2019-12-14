package com.project.autodealz.web.controller;

import com.project.autodealz.data.entities.Comment;
import com.project.autodealz.data.models.CarAnnouncementCreateBindingModel;
import com.project.autodealz.data.models.CommentBindingModel;
import com.project.autodealz.data.models.SearchAnnouncementBindingModel;
import com.project.autodealz.data.models.view.CarAnnouncementDetailsViewModel;
import com.project.autodealz.data.models.view.CommentViewModel;
import com.project.autodealz.data.models.view.UserProfileViewModel;
import com.project.autodealz.data.repository.BrandRepository;
import com.project.autodealz.data.repository.CarModelRepository;
import com.project.autodealz.service.CarAnnouncementService;
import com.project.autodealz.service.CloudinaryService;
import com.project.autodealz.service.UserService;
import com.project.autodealz.service.models.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/announcement")
public class AnnouncementController extends BaseController {

    private final CarAnnouncementService carAnnouncementService;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final BrandRepository brandRepository;
    private final CloudinaryService cloudinaryService;
    private final CarModelRepository carModelRepository;

    @Autowired
    public AnnouncementController(CarAnnouncementService carAnnouncementService, ModelMapper modelMapper, UserService userService, BrandRepository brandRepository, CloudinaryService cloudinaryService, CarModelRepository carModelRepository) {
        this.carAnnouncementService = carAnnouncementService;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.brandRepository = brandRepository;
        this.cloudinaryService = cloudinaryService;
        this.carModelRepository = carModelRepository;
    }

    @GetMapping("/create")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView createAnnouncementForm(Principal principal, ModelAndView modelAndView) {
        modelAndView.addObject("brands", this.brandRepository.findAll());
        modelAndView.addObject("carModels", this.carModelRepository.findAll());
        modelAndView.addObject("model", this.modelMapper.map(
                this.userService.findUserByUserName(principal.getName()), UserProfileViewModel.class));
        modelAndView.setViewName("announcement/create-announcement.html");
        return modelAndView;
    }

    @PostMapping("/create")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView createAnnouncementFormConfirm(@ModelAttribute CarAnnouncementCreateBindingModel model) throws IOException {
        CarAnnouncementServiceModel car = this.modelMapper.map(model, CarAnnouncementServiceModel.class);
        car.setBrand(new BrandServiceModel());
        car.getBrand().setName(model.getBrand());
        car.setModel(new CarModelServiceModel());
        car.getModel().setName(model.getModel());

        String pictureUrl = this.cloudinaryService.uploadImage(model.getAnnouncementPicture());

        if (pictureUrl == null) {
            throw new IllegalArgumentException("Event Picture upload failed.");
        }

        car.setPictureUrl(pictureUrl);

        this.carAnnouncementService.createAnnouncement(car);
        return super.redirect("/home");
    }

    @GetMapping("/all")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView showAll(@ModelAttribute SearchAnnouncementBindingModel searchAnnouncementBindingModel, ModelAndView modelAndView){
        SearchServiceModel searchServiceModel = this.modelMapper.map(searchAnnouncementBindingModel, SearchServiceModel.class);

        List<CarAnnouncementServiceModel> announcements = this.carAnnouncementService.findAllAnnouncements(searchServiceModel)
                .stream()
                .map(q -> this.modelMapper.map(q, CarAnnouncementServiceModel.class))
                .collect(Collectors.toList());



        modelAndView.addObject( "announcements", announcements);
        modelAndView.setViewName("announcement/all-announcements");
        return modelAndView;
    }
    //todo: edit
    @GetMapping("/details/{id}")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView detailsAnnouncement(@PathVariable String id, ModelAndView modelAndView) {
        modelAndView.addObject("announcement", this.modelMapper.map(this.carAnnouncementService.findAnnouncementById(id), CarAnnouncementServiceModel.class));
        modelAndView.setViewName("announcement/details-announcement");
        return modelAndView;
    }
    @PostMapping("/details/{id}/comment")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<CommentViewModel> commentAnnouncement(@PathVariable String id, CommentBindingModel commentBindingModel) {
        CommentServiceModel comment = this.modelMapper.map(commentBindingModel , CommentServiceModel.class);

        CommentViewModel commentViewModel = this.modelMapper.map(comment , CommentViewModel.class);

        return ResponseEntity.status(HttpStatus.OK).body(commentViewModel);
    }
}
