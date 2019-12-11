package com.project.autodealz.data.entities;

import javax.persistence.*;

@Entity
@Table(name = "car_model")
public class CarModel extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(targetEntity = Brand.class, cascade = CascadeType.ALL)
    private Brand brand;

    public CarModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
