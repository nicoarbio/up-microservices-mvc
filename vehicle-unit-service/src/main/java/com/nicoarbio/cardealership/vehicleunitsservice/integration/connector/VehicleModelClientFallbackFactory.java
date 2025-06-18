package com.nicoarbio.cardealership.vehicleunitsservice.integration.connector;

import com.nicoarbio.cardealership.vehicleunitsservice.integration.dto.VehicleModel;
import feign.FeignException;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class VehicleModelClientFallbackFactory implements FallbackFactory<VehicleModelClient> {
    @Override
    public VehicleModelClient create(Throwable cause) {
        return new VehicleModelClient() {
            @Override
            public VehicleModel getVehicleModelById(String id) {
                if (cause instanceof FeignException.NotFound) {
                    throw new NoSuchElementException("Vehicle Model not found for ID: " + id);
                }
                throw new RuntimeException("Error connecting to Vehicles Service", cause);
            }
        };
    }
}
