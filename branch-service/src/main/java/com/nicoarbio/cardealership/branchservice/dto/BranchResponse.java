package com.nicoarbio.cardealership.branchservice.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record BranchResponse(
        UUID id,
        String name,
        String country,
        String province,
        String city,
        String address,
        LocalDate openingDate,
        Integer localDeliveryTimeDays,
        Integer centralDeliveryTimeDays,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
