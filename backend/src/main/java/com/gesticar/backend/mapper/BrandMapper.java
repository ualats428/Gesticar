package com.gesticar.backend.mapper;

import com.gesticar.backend.dto.brand.BrandRequestDTO;
import com.gesticar.backend.dto.brand.BrandResponseDTO;
import com.gesticar.backend.entity.Brand;

public final class BrandMapper {

    private BrandMapper() {
        // Evita que se pueda instanciar la clase
    }

    public static Brand toEntity(BrandRequestDTO request) {
        Brand brand = new Brand();
        brand.setName(request.getName());
        return brand;
    }

    public static BrandResponseDTO toResponse(Brand brand) {
        BrandResponseDTO response = new BrandResponseDTO();
        response.setId(brand.getId());
        response.setName(brand.getName());
        return response;
    }
}
