package com.nicoarbio.cardealership.salesservice.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record SalesResponse(
        UUID id,
        BigDecimal amount,
        LocalDate saleDate,
        LocalDate deliveryDate,
        UUID customerId,
        UUID vehicleUnitId,
        UUID branchId,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
