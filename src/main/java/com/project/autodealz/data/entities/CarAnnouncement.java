package com.project.autodealz.data.entities;


import com.project.autodealz.data.entities.enumerations.*;

import javax.persistence.*;

@Entity
@Table(name = "car_announcement")
public class CarAnnouncement extends BaseEntity{
//    @Column(name = "announcement_number", nullable = false)
//    private String announcementNumber;
    //enum
    @Column(name = "picture_url")
    private String pictureUrl;
    @Enumerated(EnumType.STRING)
    @Column(name = "usability",updatable= false)
    private Usability usability;
    //enum
    @ManyToOne(targetEntity = Brand.class ,cascade = CascadeType.ALL)
    private Brand brand;
    //enum
    @ManyToOne(targetEntity = CarModel.class, cascade = CascadeType.ALL)
    private CarModel model;
    //enum
    @Enumerated(EnumType.STRING)
    @Column(name = "fuel_type",updatable= false)
    private FuelType fuelType;
    @Enumerated(EnumType.STRING)
    @Column(name = "transmission_type")
    private TransmissionType transmissionType;
    // TODO: maybe remake to Entity
    @Column(name = "color")
    private String color;
    @Enumerated(EnumType.STRING)
    @Column(name = "propulsion",updatable= false)
    private Propulsion propulsion;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "car_announcement_id", referencedColumnName = "id")
    private User user;


    public CarAnnouncement() {
    }

    public Usability getUsability() {
        return usability;
    }

    public void setUsability(Usability usability) {
        this.usability = usability;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public CarModel getModel() {
        return model;
    }

    public void setModel(CarModel model) {
        this.model = model;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public TransmissionType getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(TransmissionType transmissionType) {
        this.transmissionType = transmissionType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Propulsion getPropulsion() {
        return propulsion;
    }

    public void setPropulsion(Propulsion propulsion) {
        this.propulsion = propulsion;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //    public String getAnnouncementNumber() {
//        return announcementNumber;
//    }
//
//    public void setAnnouncementNumber(String announcementNumber) {
//        this.announcementNumber = announcementNumber;
//    }
}
