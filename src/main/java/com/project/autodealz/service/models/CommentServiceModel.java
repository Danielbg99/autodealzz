package com.project.autodealz.service.models;

import com.project.autodealz.data.entities.CarAnnouncement;
import com.project.autodealz.data.entities.User;

public class CommentServiceModel {

    private String content;

    private UserServiceModel user;

    private CarAnnouncementServiceModel carAnnouncement;

    public CommentServiceModel() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserServiceModel getUser() {
        return user;
    }

    public void setUser(UserServiceModel user) {
        this.user = user;
    }

    public CarAnnouncementServiceModel getCarAnnouncement() {
        return carAnnouncement;
    }

    public void setCarAnnouncement(CarAnnouncementServiceModel carAnnouncement) {
        this.carAnnouncement = carAnnouncement;
    }
}
