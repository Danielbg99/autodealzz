package com.project.autodealz.data.models.view;

import com.project.autodealz.data.entities.Brand;
import com.project.autodealz.data.entities.enumerations.*;
import com.project.autodealz.service.models.BrandServiceModel;
import com.project.autodealz.service.models.CarModelServiceModel;

public class CarAnnouncementDetailsViewModel {

    private Usability usability;

    private String brand;

    private String model;

    private VehicleType vehicleType;

    private FuelType fuelType;

    private TransmissionType transmissionType;

    private String color;

    private Propulsion propulsion;

    private String pictureUrl;

    private String description;

    public CarAnnouncementDetailsViewModel() {
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
