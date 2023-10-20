package com.softuni.mobilelelesoftuni.models.dtos;

import jakarta.validation.constraints.*;
import com.softuni.mobilelelesoftuni.models.entities.enums.Engine;
import com.softuni.mobilelelesoftuni.models.entities.enums.Transmission;

public final class CreateOfferDTO {

    @NotEmpty
    @Size(min = 5, max = 512)
    private String description;

    @Positive
    @NotNull
    private Long modelId;

    @NotNull
    private  Engine engine;

    @NotNull
    private Transmission transmission;

    @NotEmpty
    private String imageUrl;

    @Positive
    @NotNull
    private   Integer mileage;

    @Positive
    @NotNull
    private  Integer price;

    @NotNull(message = "Year must be provided!")
    @Min(1930)
    @Max(2099)
    private  Integer year;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
