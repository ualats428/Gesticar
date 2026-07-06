package com.gesticar.backend.controller;

import com.gesticar.backend.dto.brand.BrandRequestDTO;
import com.gesticar.backend.dto.brand.BrandResponseDTO;
import com.gesticar.backend.service.BrandService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BrandResponseDTO createBrand(@Valid @RequestBody BrandRequestDTO request) {
        return brandService.createBrand(request);
    }

    @GetMapping
    public List<BrandResponseDTO> getAllBrands() {
        return brandService.getAllBrands();
    }

    @GetMapping("/{id}")
    public BrandResponseDTO getBrandById(@PathVariable Long id) {
        return brandService.getBrandById(id);
    }

    @PutMapping("/{id}")
    public BrandResponseDTO updateBrand(
            @PathVariable Long id,
            @Valid @RequestBody BrandRequestDTO request) {

        return brandService.updateBrand(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBrand(@PathVariable Long id) {
        brandService.deleteBrand(id);
    }
}
