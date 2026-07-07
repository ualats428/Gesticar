package com.gesticar.backend.service.impl;

import com.gesticar.backend.dto.engine.EngineRequestDTO;
import com.gesticar.backend.dto.engine.EngineResponseDTO;
import com.gesticar.backend.entity.Engine;
import com.gesticar.backend.entity.Model;
import com.gesticar.backend.exception.EngineAlreadyExistsException;
import com.gesticar.backend.exception.EngineNotFoundException;
import com.gesticar.backend.exception.ModelNotFoundException;
import com.gesticar.backend.mapper.EngineMapper;
import com.gesticar.backend.repository.EngineRepository;
import com.gesticar.backend.repository.ModelRepository;
import com.gesticar.backend.service.EngineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service implementation for managing engines.
 *
 * @author Alejandro Tárraga
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
@Transactional
public class EngineServiceImpl implements EngineService {

    private final EngineRepository engineRepository;
    private final ModelRepository modelRepository;
    private final EngineMapper engineMapper;

    @Override
    @Transactional(readOnly = true)
    public List<EngineResponseDTO> getAllEngines() {
        return engineRepository.findAll()
                .stream()
                .map(engineMapper::toResponseDTO)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public EngineResponseDTO getEngineById(Long id) {
        return engineMapper.toResponseDTO(getEngineOrThrow(id));
    }

    @Override
    public EngineResponseDTO createEngine(EngineRequestDTO requestDTO) {

        validateEngineUniqueness(requestDTO.getModelId(), requestDTO.getName());

        Model model = getModelOrThrow(requestDTO.getModelId());

        Engine engine = engineMapper.toEntity(requestDTO);
        engine.setModel(model);

        Engine savedEngine = engineRepository.save(engine);

        return engineMapper.toResponseDTO(savedEngine);
    }

    @Override
    public EngineResponseDTO updateEngine(Long id, EngineRequestDTO requestDTO) {

        Engine engine = getEngineOrThrow(id);

        if (!engine.getModel().getId().equals(requestDTO.getModelId())
                || !engine.getName().equalsIgnoreCase(requestDTO.getName())) {

            validateEngineUniqueness(requestDTO.getModelId(), requestDTO.getName());
        }

        Model model = getModelOrThrow(requestDTO.getModelId());

        engineMapper.updateEntity(engine, requestDTO);
        engine.setModel(model);

        Engine updatedEngine = engineRepository.save(engine);

        return engineMapper.toResponseDTO(updatedEngine);
    }

    @Override
    public void deleteEngine(Long id) {
        engineRepository.delete(getEngineOrThrow(id));
    }

    private Engine getEngineOrThrow(Long id) {
        return engineRepository.findById(id)
                .orElseThrow(() -> new EngineNotFoundException(id));
    }

    private Model getModelOrThrow(Long id) {
        return modelRepository.findById(id)
                .orElseThrow(() -> new ModelNotFoundException(id));
    }

    private void validateEngineUniqueness(Long modelId, String name) {
        if (engineRepository.existsByModelIdAndName(modelId, name)) {
            throw new EngineAlreadyExistsException(name);
        }
    }
}