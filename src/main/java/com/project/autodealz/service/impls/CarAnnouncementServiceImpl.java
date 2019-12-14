package com.project.autodealz.service.impls;

import com.project.autodealz.data.entities.Brand;
import com.project.autodealz.data.entities.CarAnnouncement;
import com.project.autodealz.data.entities.CarModel;
import com.project.autodealz.data.repository.CarAnnouncementRepository;
import com.project.autodealz.errors.Constants;
import com.project.autodealz.service.BrandService;
import com.project.autodealz.service.CarAnnouncementService;
import com.project.autodealz.service.CarModelService;
import com.project.autodealz.service.models.CarAnnouncementServiceModel;
import com.project.autodealz.service.models.SearchServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarAnnouncementServiceImpl implements CarAnnouncementService {

    private final CarAnnouncementRepository carAnnouncementRepository;
    private final ModelMapper modelMapper;
    private final BrandService brandService;
    private final CarModelService carModelService;


    @Autowired
    public CarAnnouncementServiceImpl(CarAnnouncementRepository carAnnouncementRepository, ModelMapper modelMapper, BrandService brandService, CarModelService carModelService) {
        this.carAnnouncementRepository = carAnnouncementRepository;
        this.modelMapper = modelMapper;
        this.brandService = brandService;
        this.carModelService = carModelService;
    }




    @Override
    public CarAnnouncementServiceModel createAnnouncement(CarAnnouncementServiceModel carAnnouncementServiceModel) {
        CarAnnouncement carAnnouncement = this.modelMapper.map(carAnnouncementServiceModel , CarAnnouncement.class);

        Brand  brand = this.brandService.findBrandByName(carAnnouncement.getBrand());
        CarModel carModel = this.carModelService.findCarModelByName(carAnnouncement.getModel());
        carAnnouncement.setBrand(brand);
        carAnnouncement.setModel(carModel);

        return this.modelMapper.map(this.carAnnouncementRepository.saveAndFlush(carAnnouncement),
                CarAnnouncementServiceModel.class);
    }

    @Override
    public List<CarAnnouncementServiceModel> findAllAnnouncements() {
        return this.carAnnouncementRepository.findAll()
                .stream()
                .map(ca -> this.modelMapper.map(ca, CarAnnouncementServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CarAnnouncementServiceModel> findAllAnnouncements(SearchServiceModel searchServiceModel) {
        return this.carAnnouncementRepository.findAll()
                .stream()
                .filter(ca -> {
                    if(searchServiceModel.getBrand() != null) {
                        return ca.getBrand().getName().equals(searchServiceModel.getBrand());
                    }

                    return true;
                })
                .filter(ca -> {
                    if(searchServiceModel.getModel() != null) {
                        return ca.getModel().getName().equals(searchServiceModel.getModel());
                    }

                    return true;
                })
                .filter(ca -> {
                    if(searchServiceModel.getTransmissionType() != null) {
                        return ca.getTransmissionType() == searchServiceModel.getTransmissionType();
                    }

                    return true;
                })
                .filter(ca -> {
                    if(searchServiceModel.getFuelType() != null) {
                        return ca.getFuelType() == searchServiceModel.getFuelType();
                    }

                    return true;
                })
                .filter(ca -> {
                    if(searchServiceModel.getCarColor() != null) {
                        return ca.getColor().equals(searchServiceModel.getCarColor());
                    }

                    return true;
                })
                .filter(ca -> {
                    if(searchServiceModel.getPropulsion() != null) {
                        return ca.getPropulsion() == searchServiceModel.getPropulsion();
                    }

                    return true;
                })
                .map(ca -> this.modelMapper.map(ca, CarAnnouncementServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public CarAnnouncementServiceModel findAnnouncementById(String id) {
        return this.carAnnouncementRepository.findById(id)
                .map(q -> this.modelMapper.map(q, CarAnnouncementServiceModel.class))
                .orElseThrow(() -> new ExpressionException(Constants.ANNOUNCEMENT_NOT_FOUND));
    }
}
