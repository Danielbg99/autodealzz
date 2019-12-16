package com.project.autodealz.data.models.view;

import com.project.autodealz.data.entities.Brand;
import com.project.autodealz.data.entities.enumerations.*;
import com.project.autodealz.service.models.BrandServiceModel;
import com.project.autodealz.service.models.CarModelServiceModel;

import java.util.List;

public class CarAnnouncementDetailsViewModel {

    private String id;

    private Usability usability;

    private String brandName;

    private String modelName;

    private VehicleType vehicleType;

    private FuelType fuelType;

    private TransmissionType transmissionType;

    private String color;

    private Propulsion propulsion;

    private String pictureUrl;

    private String description;

    private List<CommentViewModel> comments;

    public CarAnnouncementDetailsViewModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Usability getUsability() {
        return usability;
    }

    public void setUsability(Usability usability) {
        this.usability = usability;
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

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CommentViewModel> getComments() {
        return comments;
    }

    public void setComments(List<CommentViewModel> comments) {
        this.comments = comments;
    }
}
