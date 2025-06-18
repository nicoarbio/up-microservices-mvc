package com.nicoarbio.cardealership.vehicleservice.controller;

import com.nicoarbio.cardealership.vehicleservice.dto.VehicleRequest;
import com.nicoarbio.cardealership.vehicleservice.dto.VehicleResponse;
import com.nicoarbio.cardealership.vehicleservice.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleController {

    private final VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    @GetMapping
    public List<VehicleResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<VehicleResponse> create(@Valid @RequestBody VehicleRequest newVehicle) {
        return ResponseEntity.ok(service.create(newVehicle));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleResponse> update(@PathVariable UUID id, @Valid @RequestBody VehicleRequest updatedVehicle) {
        return ResponseEntity.ok(service.update(id, updatedVehicle));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
