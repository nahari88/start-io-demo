package com.example.demo.controller;

import com.example.demo.model.dto.AdvertisingDataDto;
import com.example.demo.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class DataController {

    @Autowired
    private DataService dataService;

    @GetMapping("listings")
    public List<AdvertisingDataDto> getListings(@RequestParam(value = "min_price") double minPrice,
                                                @RequestParam(value = "max_price") double maxPrice,
                                                @RequestParam(value = "min_min_cpm") int minMinCpm,
                                                @RequestParam(value = "max_min_cpm") int maxMinCpm) {

        return dataService.getListings(minPrice, maxPrice, minMinCpm, maxMinCpm);
    }
}
