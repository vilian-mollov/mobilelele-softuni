package com.softuni.mobilelelesoftuni.services.impl;

import com.softuni.mobilelelesoftuni.models.entities.Brand;
import com.softuni.mobilelelesoftuni.repositories.BrandRepository;
import com.softuni.mobilelelesoftuni.services.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.getAllBrands();
    }
}
