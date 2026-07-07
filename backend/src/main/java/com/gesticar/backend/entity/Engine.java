package com.gesticar.backend.entity;

import com.gesticar.backend.enums.AspirationType;
import com.gesticar.backend.enums.FuelType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * Represents an engine that belongs to a specific vehicle model.
 *
 * <p>An engine defines the technical characteristics shared by vehicles,
 * such as fuel type, displacement, power, and aspiration system.</p>
 *
 * <p>Each engine is associated with exactly one {@link Model}, while a model
 * can have multiple engine variants.</p>
 *
 * @author Alejandro Tárraga
 * @since 1.0
 */

@Entity
@Table(
        name = "engine",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_engine_model_name",
                        columnNames = {"model_id", "name"}
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Engine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Engine name is required.")
    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 50)
    private String engineCode;

    @NotNull(message = "Fuel type is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FuelType fuelType;

    @NotNull(message = "Displacement is required.")
    @Min(value = 1, message = "Displacement must be greater than 0.")
    @Column(nullable = false)
    private Integer displacement;

    @NotNull(message = "Power (HP) is required.")
    @Min(value = 1, message = "Power (HP) must be greater than 0.")
    @Column(nullable = false)
    private Integer powerHp;

    @NotNull(message = "Power (kW) is required.")
    @Min(value = 1, message = "Power (kW) must be greater than 0.")
    @Column(nullable = false)
    private Integer powerKw;

    @Min(value = 1, message = "Cylinders must be greater than 0.")
    private Integer cylinders;

    @NotNull(message = "Aspiration type is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AspirationType aspirationType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id", nullable = false)
    private Model model;

}