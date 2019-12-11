package com.project.autodealz.data.entities;

import org.hibernate.validator.constraints.CodePointLength;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "brand")
public class Brand extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "brand", targetEntity = CarModel.class)
    private List<CarModel> models;

    public Brand() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CarModel> getModels() {
        return models;
    }

    public void setModels(List<CarModel> models) {
        this.models = models;
    }
}
