package com.example.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AdvertisingDataDto {

    private String advertisingId;
    private String country;
    private double price;
    private int eventTypeId;
    private int gdpr;
    private double minCpm;
    private double priority;
    private double bidPrice;
}
