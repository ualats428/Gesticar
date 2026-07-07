package com.gesticar.backend.mapper;

import com.gesticar.backend.dto.model.ModelRequestDTO;
import com.gesticar.backend.dto.model.ModelResponseDTO;
import com.gesticar.backend.entity.Brand;
import com.gesticar.backend.entity.Model;
import org.springframework.stereotype.Component;

@Component
public class ModelMapper {

    public Model toEntity(ModelRequestDTO request, Brand brand) {

        Model model = new Model();

        model.setName(request.getName());
        model.setGeneration(request.getGeneration());
        model.setStartYear(request.getStartYear());
        model.setEndYear(request.getEndYear());
        model.setBrand(brand);

        return model;
    }

    public ModelResponseDTO toResponse(Model model) {

        ModelResponseDTO response = new ModelResponseDTO();

        response.setId(model.getId());
        response.setName(model.getName());
        response.setGeneration(model.getGeneration());
        response.setStartYear(model.getStartYear());
        response.setEndYear(model.getEndYear());

        response.setBrandId(model.getBrand().getId());
        response.setBrandName(model.getBrand().getName());

        return response;
    }

    public void updateEntity(Model model, ModelRequestDTO request, Brand brand) {

        model.setName(request.getName());
        model.setGeneration(request.getGeneration());
        model.setStartYear(request.getStartYear());
        model.setEndYear(request.getEndYear());
        model.setBrand(brand);
    }
}