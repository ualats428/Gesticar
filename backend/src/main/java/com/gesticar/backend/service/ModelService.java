package com.gesticar.backend.service;

import com.gesticar.backend.dto.model.ModelRequestDTO;
import com.gesticar.backend.dto.model.ModelResponseDTO;

import java.util.List;

public interface ModelService {

    List<ModelResponseDTO> getAllModels();

    ModelResponseDTO getModelById(Long id);

    ModelResponseDTO createModel(ModelRequestDTO request);

    ModelResponseDTO updateModel(Long id, ModelRequestDTO request);

    void deleteModel(Long id);
}
