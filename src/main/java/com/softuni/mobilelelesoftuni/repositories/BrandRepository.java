package com.softuni.mobilelelesoftuni.repositories;

import com.softuni.mobilelelesoftuni.models.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
}
