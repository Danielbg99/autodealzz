package com.project.autodealz.service.impls;

import com.project.autodealz.data.entities.Brand;
import com.project.autodealz.data.repository.BrandRepository;
import com.project.autodealz.service.BrandService;
import com.project.autodealz.service.models.BrandServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService {


    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

//    @Override
//    public BrandServiceModel findBrandByName(BrandServiceModel brandServiceModel) {
//        return this.brandRepository.findByName(brandServiceModel.getName())
//    }

    @Override
    public Brand findBrandByName(Brand brand) {
        return this.brandRepository.findByName(brand.getName()).orElseThrow();
    }
}
