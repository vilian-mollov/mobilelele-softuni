package com.softuni.mobilelelesoftuni.models.entities;

import com.softuni.mobilelelesoftuni.models.entities.enums.Category;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "model")
public class Model extends BaseEntity{

    @Column
    private String name;

    @Column
    private Category category;

    @Column(length = 512)
    private String imageUrl;

    @Column
    private Integer startYear;

    @Column
    private Integer endYear;

    @Column
    private Timestamp created;

    @Column
    private Timestamp modified;

    @OneToOne(targetEntity = Brand.class)
    private Brand brand;

    public Model() {
    }

    public Model(String name, Category category, String imageUrl, Integer startYear, Integer endYear, Timestamp created, Timestamp modified, Brand brand) {
        this.name = name;
        this.category = category;
        this.imageUrl = imageUrl;
        this.startYear = startYear;
        this.endYear = endYear;
        this.created = created;
        this.modified = modified;
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
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

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}

