package com.example.demo.model.repository;

import com.example.demo.model.entity.AdvertisingData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertisingDataRepository extends JpaRepository<AdvertisingData, Integer> {

    List<AdvertisingData> findByPriceGreaterThanEqualAndPriceLessThanEqualAndMinCpmGreaterThanEqualAndMinCpmLessThanEqual(double minPrice, double maxPrice, int minMinCpm, int maxMinCpm);
}
