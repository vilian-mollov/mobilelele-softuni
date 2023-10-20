package com.softuni.mobilelelesoftuni.models.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "brand")
public class Brand extends BaseEntity{

    @Column
    private String name;

    @Column
    private Timestamp created;

    @Column
    private Timestamp modified;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "brand"
    )
    private List<Model> models;

    public Brand() {
    }

    public Brand(String name, Timestamp created, Timestamp modified) {
        this.name = name;
        this.created = created;
        this.modified = modified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }
}
