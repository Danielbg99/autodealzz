package com.project.autodealz.service.models;

import com.project.autodealz.data.entities.enumerations.FuelType;
import com.project.autodealz.data.entities.enumerations.Propulsion;
import com.project.autodealz.data.entities.enumerations.TransmissionType;
import com.project.autodealz.data.entities.enumerations.Usability;

public class SearchServiceModel {
    private Usability usability;
    private String brand;
    private String model;
    private TransmissionType transmissionType;
    private FuelType fuelType;
    private String carColor;
    private Propulsion propulsion;

    public SearchServiceModel() {
    }

    public Usability getUsability() {
        return usability;
    }

    public void setUsability(Usability usability) {
        this.usability = usability;
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

    public TransmissionType getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(TransmissionType transmissionType) {
        this.transmissionType = transmissionType;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public Propulsion getPropulsion() {
        return propulsion;
    }

    public void setPropulsion(Propulsion propulsion) {
        this.propulsion = propulsion;
    }
}
