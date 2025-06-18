package com.nicoarbio.cardealership.vehicle_units_service.integration.connector;

import com.nicoarbio.cardealership.vehicle_units_service.integration.dto.VehicleModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "vehicle-service", fallbackFactory = VehicleModelClientFallbackFactory.class)
public interface VehicleModelClient {

    @GetMapping("/api/v1/vehicles/{id}")
    VehicleModel getVehicleModelById(@PathVariable String id);

}
