package com.softuni.mobilelelesoftuni.services;

import com.softuni.mobilelelesoftuni.models.dtos.OfferSummaryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OfferService {

    Page<OfferSummaryDTO> getAllOffers(Pageable pageable);

}
