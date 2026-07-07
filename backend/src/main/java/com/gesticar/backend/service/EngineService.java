package com.gesticar.backend.service;

import com.gesticar.backend.dto.engine.EngineRequestDTO;
import com.gesticar.backend.dto.engine.EngineResponseDTO;

import java.util.List;

/**
 * Service interface for managing engines.
 *
 * @author Alejandro Tárraga
 * @since 1.0
 */
public interface EngineService {

    /**
     * Retrieves all engines.
     *
     * @return list of all engines.
     */
    List<EngineResponseDTO> getAllEngines();

    /**
     * Retrieves an engine by its ID.
     *
     * @param id engine ID.
     * @return the requested engine.
     */
    EngineResponseDTO getEngineById(Long id);

    /**
     * Creates a new engine.
     *
     * @param requestDTO engine data.
     * @return the created engine.
     */
    EngineResponseDTO createEngine(EngineRequestDTO requestDTO);

    /**
     * Updates an existing engine.
     *
     * @param id engine ID.
     * @param requestDTO updated engine data.
     * @return the updated engine.
     */
    EngineResponseDTO updateEngine(Long id, EngineRequestDTO requestDTO);

    /**
     * Deletes an engine by its ID.
     *
     * @param id engine ID.
     */
    void deleteEngine(Long id);

}