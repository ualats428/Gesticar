package com.gesticar.backend.mapper;

import com.gesticar.backend.dto.engine.EngineRequestDTO;
import com.gesticar.backend.dto.engine.EngineResponseDTO;
import com.gesticar.backend.entity.Engine;
import org.springframework.stereotype.Component;

/**
 * Mapper for converting between Engine entities and DTOs.
 *
 * @author Alejandro Tárraga
 * @since 1.0
 */
@Component
public class EngineMapper {

    public EngineResponseDTO toResponseDTO(Engine engine) {

        EngineResponseDTO dto = new EngineResponseDTO();

        dto.setId(engine.getId());
        dto.setName(engine.getName());
        dto.setEngineCode(engine.getEngineCode());
        dto.setFuelType(engine.getFuelType());
        dto.setDisplacement(engine.getDisplacement());
        dto.setPowerHp(engine.getPowerHp());
        dto.setPowerKw(engine.getPowerKw());
        dto.setCylinders(engine.getCylinders());
        dto.setAspirationType(engine.getAspirationType());

        dto.setModelId(engine.getModel().getId());
        dto.setModelName(engine.getModel().getName());

        return dto;
    }

    public Engine toEntity(EngineRequestDTO dto) {

        Engine engine = new Engine();

        engine.setName(dto.getName());
        engine.setEngineCode(dto.getEngineCode());
        engine.setFuelType(dto.getFuelType());
        engine.setDisplacement(dto.getDisplacement());
        engine.setPowerHp(dto.getPowerHp());
        engine.setPowerKw(dto.getPowerKw());
        engine.setCylinders(dto.getCylinders());
        engine.setAspirationType(dto.getAspirationType());

        return engine;
    }

    public void updateEntity(Engine engine, EngineRequestDTO dto) {

        engine.setName(dto.getName());
        engine.setEngineCode(dto.getEngineCode());
        engine.setFuelType(dto.getFuelType());
        engine.setDisplacement(dto.getDisplacement());
        engine.setPowerHp(dto.getPowerHp());
        engine.setPowerKw(dto.getPowerKw());
        engine.setCylinders(dto.getCylinders());
        engine.setAspirationType(dto.getAspirationType());
    }
}