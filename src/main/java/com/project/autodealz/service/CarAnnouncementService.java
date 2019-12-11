package com.project.autodealz.service;

import com.project.autodealz.service.models.CarAnnouncementServiceModel;
import com.project.autodealz.service.models.SearchServiceModel;

import java.util.List;

public interface CarAnnouncementService {

    CarAnnouncementServiceModel createAnnouncement(CarAnnouncementServiceModel carAnnouncementServiceModel);

    List<CarAnnouncementServiceModel> findAllAnnouncements();

    List<CarAnnouncementServiceModel> findAllAnnouncements(SearchServiceModel searchServiceModel);

    CarAnnouncementServiceModel findAnnouncementById(String id);
}
