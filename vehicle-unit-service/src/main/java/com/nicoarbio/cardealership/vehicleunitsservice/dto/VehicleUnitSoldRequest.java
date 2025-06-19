package com.nicoarbio.cardealership.vehicleunitsservice.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record VehicleUnitSoldRequest(
        @NotNull UUID branchId
) {}
