package com.nicoarbio.cardealership.salesservice.integration.customer.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record Customer(
        UUID id,
        String firstName,
        String lastName,
        String dni,
        String email,
        String phone,
        String address,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
