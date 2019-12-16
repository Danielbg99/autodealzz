package com.project.autodealz.scheduleJob;

import com.project.autodealz.data.entities.User;
import com.project.autodealz.service.EmailService;
import com.project.autodealz.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@EnableAsync
@Component
public class EmailScheduleJob {
    private final UserService userService;
    private final EmailService emailService;
    private final ModelMapper modelMapper;

    @Autowired
    public EmailScheduleJob(UserService userService, EmailService emailService, ModelMapper modelMapper) {
        this.userService = userService;
        this.emailService = emailService;
        this.modelMapper = modelMapper;
    }
    @Scheduled(cron = "0 0 0 25 12 ?")
    public void christmasScheduleJob() {
        List<User> users = userService.findAllUsers()
                .stream()
                .map(userServiceModel -> this.modelMapper.map(userServiceModel, User.class))
                .collect(Collectors.toList());

        users.forEach(user -> emailService.sendMessage(
                user.getEmail(), EmailConstants.CHRISTMAS_MESSAGE_TITLE, EmailConstants.CHRISTMAS_MESSAGE_TEXT));
    }
}
