package com.project.autodealz.data.repository;

import com.project.autodealz.data.entities.CarAnnouncement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarAnnouncementRepository extends JpaRepository<CarAnnouncement, String> {

   // CarAnnouncement createAnnouncement();

   // void delete(String id);
}
