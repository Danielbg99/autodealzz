package com.project.autodealz.service;

import com.project.autodealz.data.entities.CarModel;
import com.project.autodealz.service.models.CarModelServiceModel;

public interface CarModelService {

    CarModel findCarModelByName(CarModel carModel);
}
