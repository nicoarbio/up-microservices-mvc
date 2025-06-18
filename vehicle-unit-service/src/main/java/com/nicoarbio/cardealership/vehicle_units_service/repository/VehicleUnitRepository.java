package com.nicoarbio.cardealership.vehicle_units_service.repository;

import com.nicoarbio.cardealership.vehicle_units_service.entity.VehicleUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VehicleUnitRepository extends JpaRepository<VehicleUnit, UUID> {
}
