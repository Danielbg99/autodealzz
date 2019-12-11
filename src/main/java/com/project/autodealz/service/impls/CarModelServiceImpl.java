package com.project.autodealz.service.impls;

import com.project.autodealz.data.entities.CarModel;
import com.project.autodealz.data.repository.CarModelRepository;
import com.project.autodealz.service.CarModelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarModelServiceImpl implements CarModelService {

    private final CarModelRepository carModelRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CarModelServiceImpl(CarModelRepository carModelRepository, ModelMapper modelMapper) {
        this.carModelRepository = carModelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CarModel findCarModelByName(CarModel carModel) {
        return this.carModelRepository.findByName(carModel.getName()).orElseThrow();
    }
}
