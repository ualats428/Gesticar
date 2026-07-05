package com.gesticar.backend.service.impl;

import com.gesticar.backend.dto.brand.BrandRequestDTO;
import com.gesticar.backend.dto.brand.BrandResponseDTO;
import com.gesticar.backend.entity.Brand;
import com.gesticar.backend.mapper.BrandMapper;
import com.gesticar.backend.repository.BrandRepository;
import com.gesticar.backend.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public BrandResponseDTO createBrand(BrandRequestDTO request) {

        if (brandRepository.existsByName(request.getName())) {
            throw new IllegalArgumentException("Brand already exists.");
        }

        Brand brand = BrandMapper.toEntity(request);

        Brand savedBrand = brandRepository.save(brand);

        return BrandMapper.toResponse(savedBrand);
    }

    @Override
    public List<BrandResponseDTO> getAllBrands() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public BrandResponseDTO getBrandById(Long id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public BrandResponseDTO updateBrand(Long id, BrandRequestDTO request) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void deleteBrand(Long id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}