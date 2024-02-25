package com.softuni.mobilelelesoftuni.services;

import com.softuni.mobilelelesoftuni.models.dtos.OfferDetailDTO;
import com.softuni.mobilelelesoftuni.models.dtos.OfferSummaryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface OfferService {

    Page<OfferSummaryDTO> getAllOffers(Pageable pageable);

    Optional<OfferDetailDTO> getOfferDetail(UUID offerUUID);

    void deleteOffer(UUID offerUUID);

}
