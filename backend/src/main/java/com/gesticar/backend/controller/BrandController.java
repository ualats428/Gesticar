package com.gesticar.backend.controller;

import com.gesticar.backend.dto.brand.BrandRequestDTO;
import com.gesticar.backend.dto.brand.BrandResponseDTO;
import com.gesticar.backend.service.BrandService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @PostMapping
    public BrandResponseDTO createBrand(@Valid @RequestBody BrandRequestDTO request) {
        return brandService.createBrand(request);
    }
}
