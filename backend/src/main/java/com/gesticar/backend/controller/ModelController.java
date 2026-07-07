package com.gesticar.backend.controller;

import com.gesticar.backend.dto.model.*;
import com.gesticar.backend.service.ModelService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
public class ModelController {

    private final ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping
    public List<ModelResponseDTO> getAllModels() {
        return modelService.getAllModels();
    }

    @GetMapping("/{id}")
    public ModelResponseDTO getModelById(@PathVariable Long id) {
        return modelService.getModelById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ModelResponseDTO createModel(@Valid @RequestBody ModelRequestDTO request) {
        return modelService.createModel(request);
    }

    @PutMapping("/{id}")
    public ModelResponseDTO updateModel(
            @PathVariable Long id,
            @Valid @RequestBody ModelRequestDTO request) {

        return modelService.updateModel(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteModel(@PathVariable Long id) {
        modelService.deleteModel(id);
    }
}
