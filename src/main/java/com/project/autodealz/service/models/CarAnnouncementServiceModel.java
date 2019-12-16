package com.project.autodealz.service.models;

import com.project.autodealz.data.entities.enumerations.*;

import java.util.List;

public class CarAnnouncementServiceModel {
    private String id;

    private Usability usability;

    private BrandServiceModel brand;

    private CarModelServiceModel model;

    private VehicleType vehicleType;

    private FuelType fuelType;

    private TransmissionType transmissionType;

    private String color;

    private Propulsion propulsion;

    private String pictureUrl;

    private String description;

    private List<CommentServiceModel> comments;

    public CarAnnouncementServiceModel() {
    }

    public Usability getUsability() {
        return usability;
    }

    public void setUsability(Usability usability) {
        this.usability = usability;
    }

    public BrandServiceModel getBrand() {
        return brand;
    }

    public void setBrand(BrandServiceModel brand) {
        this.brand = brand;
    }

    public CarModelServiceModel getModel() {
        return model;
    }

    public void setModel(CarModelServiceModel model) {
        this.model = model;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<CommentServiceModel> getComments() {
        return comments;
    }

    public void setComments(List<CommentServiceModel> comments) {
        this.comments = comments;
    }
}
