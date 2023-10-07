package com.softuni.mobilelelesoftuni.repositories;

import com.softuni.mobilelelesoftuni.models.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {
}
