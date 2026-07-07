package com.gesticar.backend.dto.engine;

import com.gesticar.backend.enums.AspirationType;
import com.gesticar.backend.enums.FuelType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * DTO returned when an engine is requested.
 *
 * @author Alejandro Tárraga
 * @since 1.0
 */
@Data
@Schema(description = "Engine response data.")
public class EngineResponseDTO {

    @Schema(description = "Engine ID", example = "1")
    private Long id;

    @Schema(description = "Engine name", example = "2.0 dCi 130")
    private String name;

    @Schema(description = "Manufacturer engine code", example = "M9R 780")
    private String engineCode;

    @Schema(description = "Fuel type")
    private FuelType fuelType;

    @Schema(description = "Engine displacement in cubic centimeters", example = "1995")
    private Integer displacement;

    @Schema(description = "Engine power in horsepower", example = "130")
    private Integer powerHp;

    @Schema(description = "Engine power in kilowatts", example = "96")
    private Integer powerKw;

    @Schema(description = "Number of cylinders", example = "4")
    private Integer cylinders;

    @Schema(description = "Engine aspiration type")
    private AspirationType aspirationType;

    @Schema(description = "Associated model ID", example = "1")
    private Long modelId;

    @Schema(description = "Associated model name", example = "Laguna III")
    private String modelName;

}