package com.nicoarbio.cardealership.vehicleunitsservice.dto;

import com.nicoarbio.cardealership.vehicleunitsservice.entity.LocationType;
import com.nicoarbio.cardealership.vehicleunitsservice.entity.VehicleUnitStatus;
import jakarta.validation.constraints.*;

import java.util.UUID;

public record VehicleUnitRequest(
        @NotBlank @Size(min = 1, max = 9) String licencePlate,
        @NotBlank @Size(min = 1, max = 30) String color,
        @NotNull VehicleUnitStatus status,
        @NotNull LocationType locationType,
        @NotNull UUID vehicleModelId,
        @NotNull UUID branchId
) {}
