package org.up.clasemvc.vehiculo.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record VehiculoRequest(
        @Min(value = 1, message = "El campo número de chasis debe ser mayor a 0")
        @NotBlank(message = "El campo número de chasis es obligatorio")
        String nroChasis,

        @Min(value = 1900, message = "El año de fabricación debe ser mayor o igual a 1900")
        @Max(value = 2025, message = "El año de fabricación debe ser menor o igual a 2025")
        int anioFabricacion
) {
}
