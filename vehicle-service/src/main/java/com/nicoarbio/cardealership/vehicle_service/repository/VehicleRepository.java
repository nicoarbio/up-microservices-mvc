package com.nicoarbio.cardealership.vehicle_service.repository;

import com.nicoarbio.cardealership.vehicle_service.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {
}
