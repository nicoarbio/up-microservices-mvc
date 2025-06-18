package com.nicoarbio.cardealership.vehicle_units_service.dto;

import com.nicoarbio.cardealership.vehicle_units_service.entity.LocationType;
import com.nicoarbio.cardealership.vehicle_units_service.entity.VehicleUnitStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Includes information from {@link com.nicoarbio.cardealership.vehicle_units_service.integration.dto.VehicleModel}
 */
public record VehicleUnitFullResponse(
        UUID id,
        String licencePlate,
        String color,
        VehicleUnitStatus status,
        LocationType locationType,
        UUID branchId,
        String brand,
        String model,
        Integer manufactureYear,
        String type,
        BigDecimal price,
        Integer warrantyYears,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
