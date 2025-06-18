package com.nicoarbio.cardealership.vehicle_units_service.integration.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record VehicleModel(
        UUID id,
        String brand,
        String model,
        Integer manufactureYear,
        String type,
        BigDecimal price,
        Integer warrantyYears,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
