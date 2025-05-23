package org.up.clasemvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.up.clasemvc.model.Vehiculo;

import java.util.UUID;

public interface VehiculoRepository extends JpaRepository<Vehiculo, UUID> {

}
