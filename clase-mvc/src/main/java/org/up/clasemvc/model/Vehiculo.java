package org.up.clasemvc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vehiculo {

    @Id
    @GeneratedValue
    private UUID id;

    @Min(value = 1, message = "El campo número de chasis debe ser mayor a 0")
    @NotBlank(message = "El campo número de chasis es obligatorio")
    @Column(nullable = false, unique = true)
    private String nroChasis;

    @Min(value = 1900, message = "El año de fabricación debe ser mayor o igual a 1900")
    @Max(value = 2025, message = "El año de fabricación debe ser menor o igual a 2025")
    private int anioFabricacion;

}
