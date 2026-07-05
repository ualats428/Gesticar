package com.gesticar.backend.service;

import com.gesticar.backend.dto.brand.BrandRequestDTO;
import com.gesticar.backend.dto.brand.BrandResponseDTO;

import java.util.List;

public interface BrandService {

    BrandResponseDTO createBrand(BrandRequestDTO request);

    List<BrandResponseDTO> getAllBrands();

    BrandResponseDTO getBrandById(Long id);

    BrandResponseDTO updateBrand(Long id, BrandRequestDTO request);

    void deleteBrand(Long id);
}