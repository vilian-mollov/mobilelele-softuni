package com.softuni.mobilelelesoftuni.models.dtos;

import com.softuni.mobilelelesoftuni.models.entities.enums.Engine;
import com.softuni.mobilelelesoftuni.models.entities.enums.Transmission;

import java.math.BigDecimal;

public record OfferSummaryDTO(
        String id,
        String brand,
        String model,
        Integer year,
        Long mileage,
        BigDecimal price,
        Engine engine,
        Transmission transmission,
        String imageUrl
) {
    public String summary() {
        return brand + " " + model + ", " + year;
    }
}
