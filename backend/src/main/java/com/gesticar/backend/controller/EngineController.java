package com.gesticar.backend.controller;

import com.gesticar.backend.dto.engine.EngineRequestDTO;
import com.gesticar.backend.dto.engine.EngineResponseDTO;
import com.gesticar.backend.service.EngineService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing engines.
 *
 * @author Alejandro Tárraga
 * @since 1.0
 */
@RestController
@RequestMapping("/api/engines")
@RequiredArgsConstructor
@Tag(name = "Engines", description = "Operations related to vehicle engines.")
public class EngineController {

    private final EngineService engineService;

    @GetMapping
    @Operation(summary = "Get all engines")
    @ApiResponse(responseCode = "200", description = "Engines retrieved successfully")
    public List<EngineResponseDTO> getAllEngines() {
        return engineService.getAllEngines();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get an engine by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Engine found"),
            @ApiResponse(responseCode = "404", description = "Engine not found",
                    content = @Content(schema = @Schema()))
    })
    public EngineResponseDTO getEngineById(@PathVariable Long id) {
        return engineService.getEngineById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new engine")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Engine created successfully"),
            @ApiResponse(responseCode = "404", description = "Model not found"),
            @ApiResponse(responseCode = "409", description = "Engine already exists")
    })
    public EngineResponseDTO createEngine(@Valid @RequestBody EngineRequestDTO requestDTO) {
        return engineService.createEngine(requestDTO);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing engine")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Engine updated successfully"),
            @ApiResponse(responseCode = "404", description = "Engine or model not found"),
            @ApiResponse(responseCode = "409", description = "Engine already exists")
    })
    public EngineResponseDTO updateEngine(
            @PathVariable Long id,
            @Valid @RequestBody EngineRequestDTO requestDTO) {

        return engineService.updateEngine(id, requestDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete an engine")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Engine deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Engine not found")
    })
    public void deleteEngine(@PathVariable Long id) {
        engineService.deleteEngine(id);
    }

}