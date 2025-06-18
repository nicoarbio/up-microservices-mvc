package com.nicoarbio.cardealership.vehicleservice.dto.mapper;

import com.nicoarbio.cardealership.vehicleservice.dto.VehicleRequest;
import com.nicoarbio.cardealership.vehicleservice.dto.VehicleResponse;
import com.nicoarbio.cardealership.vehicleservice.entity.Vehicle;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VehicleMapper {

    public Vehicle toEntity(VehicleRequest req) {
        return toEntity(req, null);
    }

    public Vehicle toEntity(VehicleRequest req, Vehicle existing) {
        if (existing == null) {
            existing = new Vehicle();
        }
        existing.setBrand(req.brand());
        existing.setModel(req.model());
        existing.setManufactureYear(req.manufactureYear());
        existing.setType(req.type());
        existing.setPrice(req.price());
        existing.setWarrantyYears(req.warrantyYears());
        return existing;
    }

    public VehicleResponse toResponse(Vehicle vehicle) {
        return new VehicleResponse(
                vehicle.getId(),
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getManufactureYear(),
                vehicle.getType(),
                vehicle.getPrice(),
                vehicle.getWarrantyYears(),
                vehicle.getCreatedAt(),
                vehicle.getUpdatedAt()
        );
    }

    public List<VehicleResponse> toResponseList(List<Vehicle> vehicles) {
        return vehicles.stream().map(this::toResponse).collect(Collectors.toList());
    }

}
