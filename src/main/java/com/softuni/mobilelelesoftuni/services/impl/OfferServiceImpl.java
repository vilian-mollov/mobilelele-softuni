package com.softuni.mobilelelesoftuni.services.impl;

import com.softuni.mobilelelesoftuni.models.dtos.OfferDetailDTO;
import com.softuni.mobilelelesoftuni.models.dtos.OfferSummaryDTO;
import com.softuni.mobilelelesoftuni.models.entities.Offer;
import com.softuni.mobilelelesoftuni.repositories.OfferRepository;
import com.softuni.mobilelelesoftuni.services.OfferService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }


    @Override
    public Page<OfferSummaryDTO> getAllOffers(Pageable pageable) {
        return offerRepository.findAll(pageable)
                .map(OfferServiceImpl::mapAsSummary);
    }

    @Override
    public Optional<OfferDetailDTO> getOfferDetail(UUID offerUUID) {
        return offerRepository
                .findByUuid(offerUUID)
                .map(OfferServiceImpl::mapAsDetails);
    }

    @Override
    @Transactional
    public void deleteOffer(UUID offerUUID) {
        offerRepository.deleteByUuid(offerUUID);
    }


    private static OfferSummaryDTO mapAsSummary(Offer offer) {
        return new OfferSummaryDTO(
                offer.getUuid().toString(),
                offer.getModel().getBrand().getName(),
                offer.getModel().getName(),
                offer.getYear(),
                offer.getMileage(),
                offer.getPrice(),
                offer.getEngine(),
                offer.getTransmission(),
                offer.getImageUrl());
    }

    private static OfferDetailDTO mapAsDetails(Offer offer) {
        // TODO: reuse
        return new OfferDetailDTO(
                offer.getUuid().toString(),
                offer.getModel().getBrand().getName(),
                offer.getModel().getName(),
                offer.getYear(),
                offer.getMileage(),
                offer.getPrice(),
                offer.getEngine(),
                offer.getTransmission(),
                offer.getImageUrl());
    }

}
