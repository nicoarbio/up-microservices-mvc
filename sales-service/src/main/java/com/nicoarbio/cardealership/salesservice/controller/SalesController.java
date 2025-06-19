package com.nicoarbio.cardealership.salesservice.controller;

import com.nicoarbio.cardealership.salesservice.dto.SaleSpecificVehicleUnitRequest;
import com.nicoarbio.cardealership.salesservice.dto.SalesResponse;
import com.nicoarbio.cardealership.salesservice.service.SalesService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/sales")
public class SalesController {

    private final SalesService service;

    public SalesController(SalesService service) {
        this.service = service;
    }

    @GetMapping
    public List<SalesResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalesResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<SalesResponse> registerSellOfSpecificVehicleUnit(@Valid @RequestBody SaleSpecificVehicleUnitRequest specificVehicleUnitRequest) {
        return ResponseEntity.ok(service.registerSellOfSpecificVehicleUnit(specificVehicleUnitRequest));
    }

}
