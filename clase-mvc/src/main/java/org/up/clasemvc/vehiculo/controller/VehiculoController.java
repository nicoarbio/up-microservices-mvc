package org.up.clasemvc.vehiculo.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.up.clasemvc.vehiculo.dto.VehiculoRequest;
import org.up.clasemvc.vehiculo.dto.VehiculoResponse;
import org.up.clasemvc.vehiculo.service.VehiculoService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/vehiculos")
@RequiredArgsConstructor
public class VehiculoController {

    private final VehiculoService vehiculoService;

    @PostMapping
    public ResponseEntity<VehiculoResponse> crearVehiculo(@Valid @RequestBody VehiculoRequest vehiculo) {
        VehiculoResponse creado = vehiculoService.crear(vehiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehiculoResponse> obtenerVehiculo(@PathVariable UUID id) {
        Optional<VehiculoResponse> vehiculo = vehiculoService.obtenerPorId(id);
        return vehiculo.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<VehiculoResponse>> obtenerTodos() {
        List<VehiculoResponse> vehiculos = vehiculoService.obtenerTodos();
        if (vehiculos.isEmpty()) {
            return ResponseEntity.ok().body(Collections.emptyList()); // o .noContent().build()
        }
        return ResponseEntity.ok(vehiculos);
    }

}
