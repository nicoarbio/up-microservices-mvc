package org.up.clasemvc.vehiculo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.up.clasemvc.vehiculo.model.Vehiculo;

import java.util.UUID;

public interface VehiculoRepository extends JpaRepository<Vehiculo, UUID> {

}
