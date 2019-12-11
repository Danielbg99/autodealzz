package com.project.autodealz.service;

import com.project.autodealz.data.entities.Brand;
import com.project.autodealz.service.models.BrandServiceModel;

public interface BrandService {

    Brand findBrandByName(Brand brand);
}
