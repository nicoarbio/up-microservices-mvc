package org.up.clasemvc.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.up.clasemvc.model.Vehiculo;
import org.up.clasemvc.service.VehiculoService;

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
    public ResponseEntity<Vehiculo> crearVehiculo(@Valid @RequestBody Vehiculo vehiculo) {
        Vehiculo creado = vehiculoService.crear(vehiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> obtenerVehiculo(@PathVariable UUID id) {
        Optional<Vehiculo> vehiculo = vehiculoService.obtenerPorId(id);
        return vehiculo.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Vehiculo>> obtenerTodos() {
        List<Vehiculo> vehiculos = vehiculoService.obtenerTodos();
        if (vehiculos.isEmpty()) {
            return ResponseEntity.ok().body(Collections.emptyList()); // o .noContent().build()
        }
        return ResponseEntity.ok(vehiculos);
    }

}
