package com.nicoarbio.cardealership.vehicleunitsservice.repository;

import com.nicoarbio.cardealership.vehicleunitsservice.entity.VehicleUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VehicleUnitRepository extends JpaRepository<VehicleUnit, UUID> {
}
