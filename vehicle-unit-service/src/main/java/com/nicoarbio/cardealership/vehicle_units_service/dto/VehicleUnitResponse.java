package com.nicoarbio.cardealership.vehicle_units_service.dto;

import com.nicoarbio.cardealership.vehicle_units_service.entity.LocationType;
import com.nicoarbio.cardealership.vehicle_units_service.entity.VehicleUnitStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record VehicleUnitResponse(
        UUID id,
        String licencePlate,
        String color,
        VehicleUnitStatus status,
        LocationType locationType,
        UUID branchId,
        UUID vehicleModelId,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
