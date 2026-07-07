package com.gesticar.backend.service.impl;

import com.gesticar.backend.dto.model.ModelRequestDTO;
import com.gesticar.backend.dto.model.ModelResponseDTO;
import com.gesticar.backend.entity.Brand;
import com.gesticar.backend.entity.Model;
import com.gesticar.backend.exception.BrandNotFoundException;
import com.gesticar.backend.exception.ModelNotFoundException;
import com.gesticar.backend.mapper.ModelMapper;
import com.gesticar.backend.repository.BrandRepository;
import com.gesticar.backend.repository.ModelRepository;
import com.gesticar.backend.service.ModelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;

    public ModelServiceImpl(ModelRepository modelRepository,
                            BrandRepository brandRepository,
                            ModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ModelResponseDTO> getAllModels() {
        return modelRepository.findAll()
                .stream()
                .map(modelMapper::toResponse)
                .toList();
    }

    @Override
    public ModelResponseDTO getModelById(Long id) {
        Model model = getModelOrThrow(id);
        return modelMapper.toResponse(model);
    }

    @Override
    public ModelResponseDTO createModel(ModelRequestDTO request) {

        Brand brand = getBrandOrThrow(request.getBrandId());

        Model model = modelMapper.toEntity(request, brand);

        model = modelRepository.save(model);

        return modelMapper.toResponse(model);
    }

    @Override
    public ModelResponseDTO updateModel(Long id, ModelRequestDTO request) {

        Model model = getModelOrThrow(id);

        Brand brand = getBrandOrThrow(request.getBrandId());

        modelMapper.updateEntity(model, request, brand);

        model = modelRepository.save(model);

        return modelMapper.toResponse(model);
    }

    @Override
    public void deleteModel(Long id) {

        Model model = getModelOrThrow(id);

        modelRepository.delete(model);
    }

    private Model getModelOrThrow(Long id) {
        return modelRepository.findById(id)
                .orElseThrow(() -> new ModelNotFoundException(id));
    }

    private Brand getBrandOrThrow(Long brandId) {
        return brandRepository.findById(brandId)
                .orElseThrow(() -> new BrandNotFoundException(brandId));
    }
}