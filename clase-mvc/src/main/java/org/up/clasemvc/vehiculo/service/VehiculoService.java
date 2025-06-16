package org.up.clasemvc.vehiculo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.up.clasemvc.vehiculo.dto.VehiculoRequest;
import org.up.clasemvc.vehiculo.dto.VehiculoResponse;
import org.up.clasemvc.vehiculo.dto.mapper.VehiculoMapper;
import org.up.clasemvc.vehiculo.model.Vehiculo;
import org.up.clasemvc.vehiculo.repository.VehiculoRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VehiculoService {

    private final VehiculoRepository vehiculoRepository;
    private final VehiculoMapper vehiculoMapper;

    @Transactional
    public VehiculoResponse crear(VehiculoRequest vehiculoDto) {
        Vehiculo vehiculo = vehiculoMapper.toEntity(vehiculoDto);
        vehiculo = vehiculoRepository.save(vehiculo); // Get the generated ID
        return vehiculoMapper.toDto(vehiculo);
    }

    public Optional<VehiculoResponse> obtenerPorId(UUID id) {
        return vehiculoRepository.findById(id).map(vehiculoMapper::toDto);
    }

    public List<VehiculoResponse> obtenerTodos() {
        return vehiculoMapper.toDtoList(vehiculoRepository.findAll());
    }

}
