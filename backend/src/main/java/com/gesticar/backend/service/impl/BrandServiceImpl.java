package com.gesticar.backend.service.impl;

import com.gesticar.backend.dto.brand.BrandRequestDTO;
import com.gesticar.backend.dto.brand.BrandResponseDTO;
import com.gesticar.backend.entity.Brand;
import com.gesticar.backend.exception.BrandAlreadyExistsException;
import com.gesticar.backend.exception.BrandNotFoundException;
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
            throw new BrandAlreadyExistsException(request.getName());
        }

        Brand brand = BrandMapper.toEntity(request);

        Brand savedBrand = brandRepository.save(brand);

        return BrandMapper.toResponse(savedBrand);
    }

    @Override
    public List<BrandResponseDTO> getAllBrands() {

        List<Brand> brands = brandRepository.findAll();

        return brands.stream()
                .map(BrandMapper::toResponse)
                .toList();
    }

    @Override
    public BrandResponseDTO getBrandById(Long id) {

        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new BrandNotFoundException(id));

        return BrandMapper.toResponse(brand);
    }

    @Override
    public BrandResponseDTO updateBrand(Long id, BrandRequestDTO request) {

        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new BrandNotFoundException(id));

        if (brandRepository.existsByName(request.getName())
                && !brand.getName().equalsIgnoreCase(request.getName())) {
            throw new BrandAlreadyExistsException(request.getName());
        }

        brand.setName(request.getName());

        Brand updatedBrand = brandRepository.save(brand);

        return BrandMapper.toResponse(updatedBrand);
    }

    @Override
    public void deleteBrand(Long id) {

        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new BrandNotFoundException(id));

        brandRepository.delete(brand);
    }
}