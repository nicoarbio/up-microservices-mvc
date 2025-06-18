package com.nicoarbio.cardealership.vehicle_service.dto.mapper;

import com.nicoarbio.cardealership.vehicle_service.dto.VehicleRequest;
import com.nicoarbio.cardealership.vehicle_service.dto.VehicleResponse;
import com.nicoarbio.cardealership.vehicle_service.entity.Vehicle;
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

    public VehicleResponse toResponse(Vehicle b) {
        return new VehicleResponse(
                b.getId(),
                b.getBrand(),
                b.getModel(),
                b.getManufactureYear(),
                b.getType(),
                b.getPrice(),
                b.getWarrantyYears(),
                b.getCreatedAt(),
                b.getUpdatedAt()
        );
    }

    public List<VehicleResponse> toResponseList(List<Vehicle> branches) {
        return branches.stream().map(this::toResponse).collect(Collectors.toList());
    }

}
