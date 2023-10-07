package com.softuni.mobilelelesoftuni.models.entities;

import com.softuni.mobilelelesoftuni.models.entities.enums.Engine;
import com.softuni.mobilelelesoftuni.models.entities.enums.Transmission;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "offer")
public class Offer extends BaseEntity{

    @Column
    private String description;
    @Column
    private Engine engine;
    @Column(length = 512)
    private String imageUrl;
    @Column
    private Long mileage;
    @Column
    private BigDecimal price;
    @Column
    private Transmission transmission;
    @Column
    private Integer year;
    @Column
    private Timestamp created;
    @Column
    private Timestamp modified;

    @OneToOne
    private Model model;

    @OneToOne
    private User seller;

    public Offer() {
    }

    public Offer(String description, Engine engine, String imageUrl, Long mileage, BigDecimal price, Transmission transmission, Integer year, Timestamp created, Timestamp modified, Model model, User seller) {
        this.description = description;
        this.engine = engine;
        this.imageUrl = imageUrl;
        this.mileage = mileage;
        this.price = price;
        this.transmission = transmission;
        this.year = year;
        this.created = created;
        this.modified = modified;
        this.model = model;
        this.seller = seller;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getMileage() {
        return mileage;
    }

    public void setMileage(Long mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getModified() {
        return modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }
}

