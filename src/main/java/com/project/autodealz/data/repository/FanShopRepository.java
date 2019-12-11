package com.project.autodealz.data.repository;

import com.project.autodealz.data.entities.FanShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FanShopRepository extends JpaRepository<FanShop,String> {
}
