package com.softuni.mobilelelesoftuni.repositories;

import com.softuni.mobilelelesoftuni.models.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
}
