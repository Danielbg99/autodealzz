package com.project.autodealz.data.entities;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity{
    @Column(name = "content")
    private String content;

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    private User user;

    @ManyToOne(targetEntity = CarAnnouncement.class, cascade = CascadeType.ALL)
    private CarAnnouncement carAnnouncement;

    public Comment() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CarAnnouncement getCarAnnouncement() {
        return carAnnouncement;
    }

    public void setCarAnnouncement(CarAnnouncement carAnnouncement) {
        this.carAnnouncement = carAnnouncement;
    }
}
