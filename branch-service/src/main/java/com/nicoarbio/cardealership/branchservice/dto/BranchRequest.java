package com.nicoarbio.cardealership.branchservice.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record BranchRequest(
        @NotBlank String name,
        @NotBlank String country,
        @NotBlank String province,
        @NotBlank String city,
        @NotBlank String address,
        @NotBlank @PastOrPresent LocalDate openingDate,
        @NotBlank @Min(1) @Max(14) Integer localDeliveryTimeDays,
        @NotBlank @Min(1) @Max(30) Integer centralDeliveryTimeDays
) {}
