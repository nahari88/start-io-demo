package com.example.demo.services;

import com.example.demo.model.dto.AdvertisingDataDto;
import com.example.demo.model.entity.AdvertisingData;
import com.example.demo.model.repository.AdvertisingDataRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DataService {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final Logger logger = LoggerFactory.getLogger(DataService.class);

    @Autowired
    private AdvertisingDataRepository advertisingDataRepository;
    public List<AdvertisingDataDto> getListings(double minPrice, double maxPrice, int minMinCpm, int maxMinCpm) {
        List<AdvertisingDataDto> result = new ArrayList<>();

        // preform sql query (or mongo aggregation) to collect relevant records according to these parameters

        List<AdvertisingData> advertisingDataList = advertisingDataRepository.findByPriceGreaterThanEqualAndPriceLessThanEqualAndMinCpmGreaterThanEqualAndMinCpmLessThanEqual(minPrice, maxPrice, minMinCpm, maxMinCpm);

        //map between records to dto list of AdvertisingDataDto
        try {
            result = Arrays.asList(objectMapper.convertValue(advertisingDataList, AdvertisingDataDto[].class));
        } catch (Exception e) {
            logger.warn("Failed to convert db records to dto list");
        }

        // return result
        return result;
    }
}
