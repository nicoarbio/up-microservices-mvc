package com.nicoarbio.cardealership.vehicleunitsservice.dto.mapper;

import com.nicoarbio.cardealership.vehicleunitsservice.dto.VehicleUnitRequest;
import com.nicoarbio.cardealership.vehicleunitsservice.dto.VehicleUnitFullResponse;
import com.nicoarbio.cardealership.vehicleunitsservice.dto.VehicleUnitResponse;
import com.nicoarbio.cardealership.vehicleunitsservice.entity.VehicleUnit;
import com.nicoarbio.cardealership.vehicleunitsservice.integration.dto.VehicleModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VehicleUnitMapper {

    public VehicleUnit toEntity(VehicleUnitRequest req) {
        return toEntity(req, null);
    }

    public VehicleUnit toEntity(VehicleUnitRequest req, VehicleUnit existing) {
        if (existing == null) {
            existing = new VehicleUnit();
        }
        existing.setLicencePlate(req.licencePlate());
        existing.setColor(req.color());
        existing.setStatus(req.status());
        existing.setLocation(req.locationType());
        existing.setVehicleModelId(req.vehicleModelId());
        existing.setBranchId(req.branchId());
        return existing;
    }

    public VehicleUnitResponse toResponse(VehicleUnit vehicleStock) {
        return new VehicleUnitResponse(
                vehicleStock.getId(),
                vehicleStock.getLicencePlate(),
                vehicleStock.getColor(),
                vehicleStock.getStatus(),
                vehicleStock.getLocation(),
                vehicleStock.getBranchId(),
                vehicleStock.getVehicleModelId(),
                vehicleStock.getCreatedAt(),
                vehicleStock.getUpdatedAt()
        );
    }

    public List<VehicleUnitResponse> toResponseList(List<VehicleUnit> vehicles) {
        return vehicles.stream().map(this::toResponse).collect(Collectors.toList());
    }

    public VehicleUnitFullResponse toFullResponse(VehicleUnit vehicleStock, VehicleModel vehicleModel) {
        return new VehicleUnitFullResponse(
                vehicleStock.getId(),
                vehicleStock.getLicencePlate(),
                vehicleStock.getColor(),
                vehicleStock.getStatus(),
                vehicleStock.getLocation(),
                vehicleStock.getBranchId(),
                vehicleModel.brand(),
                vehicleModel.model(),
                vehicleModel.manufactureYear(),
                vehicleModel.type(),
                vehicleModel.price(),
                vehicleModel.warrantyYears(),
                vehicleStock.getCreatedAt(),
                vehicleStock.getUpdatedAt()
        );
    }

}
