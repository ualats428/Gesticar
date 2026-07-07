package com.gesticar.backend.dto.engine;

import com.gesticar.backend.enums.AspirationType;
import com.gesticar.backend.enums.FuelType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * DTO used to create or update an engine.
 *
 * @author Alejandro Tárraga
 * @since 1.0
 */
@Data
@Schema(description = "Request data for creating or updating an engine.")
public class EngineRequestDTO {

    @Schema(description = "Engine name", example = "2.0 dCi 130")
    @NotBlank(message = "Engine name is required.")
    private String name;

    @Schema(description = "Manufacturer engine code", example = "M9R 780")
    private String engineCode;

    @Schema(description = "Fuel type")
    @NotNull(message = "Fuel type is required.")
    private FuelType fuelType;

    @Schema(description = "Engine displacement in cubic centimeters", example = "1995")
    @NotNull(message = "Displacement is required.")
    @Min(value = 1, message = "Displacement must be greater than 0.")
    private Integer displacement;

    @Schema(description = "Engine power in horsepower", example = "130")
    @NotNull(message = "Power (HP) is required.")
    @Min(value = 1, message = "Power (HP) must be greater than 0.")
    private Integer powerHp;

    @Schema(description = "Engine power in kilowatts", example = "96")
    @NotNull(message = "Power (kW) is required.")
    @Min(value = 1, message = "Power (kW) must be greater than 0.")
    private Integer powerKw;

    @Schema(description = "Number of cylinders", example = "4")
    @Min(value = 1, message = "Cylinders must be greater than 0.")
    private Integer cylinders;

    @Schema(description = "Engine aspiration type")
    @NotNull(message = "Aspiration type is required.")
    private AspirationType aspirationType;

    @Schema(description = "Associated model ID", example = "1")
    @NotNull(message = "Model is required.")
    private Long modelId;

}