package org.up.clasemvc.vehiculo.dto.mapper;

import org.springframework.stereotype.Component;
import org.up.clasemvc.vehiculo.dto.VehiculoRequest;
import org.up.clasemvc.vehiculo.dto.VehiculoResponse;
import org.up.clasemvc.vehiculo.model.Vehiculo;

import java.util.List;

@Component
public class VehiculoMapper {

    public Vehiculo toEntity(VehiculoRequest vehiculoRequest) {
        if (vehiculoRequest == null) {
            return null;
        }
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setNroChasis(vehiculoRequest.nroChasis());
        vehiculo.setAnioFabricacion(vehiculoRequest.anioFabricacion());
        return vehiculo;
    }

    public VehiculoResponse toDto(Vehiculo vehiculo) {
        if (vehiculo == null) {
            return null;
        }
        return new VehiculoResponse(
                vehiculo.getId() != null ? vehiculo.getId().toString() : null,
                vehiculo.getNroChasis(),
                vehiculo.getAnioFabricacion()
        );
    }

    public List<VehiculoResponse> toDtoList(List<Vehiculo> vehiculo) {
        if (vehiculo == null || vehiculo.isEmpty()) {
            return List.of();
        }
        return vehiculo.stream()
                .map(this::toDto)
                .toList();
    }

}
