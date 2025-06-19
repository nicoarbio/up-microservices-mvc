package com.nicoarbio.cardealership.salesservice.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record SaleSpecificVehicleUnitRequest(
    @NotNull UUID vehicleUnitId,
    @NotNull UUID customerId,
    @NotNull UUID branchId
) {}
