package com.project.autodealz.data.repository;

import com.project.autodealz.data.entities.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarModelRepository extends JpaRepository<CarModel, String> {

    Optional<CarModel> findByName(String name);
}
