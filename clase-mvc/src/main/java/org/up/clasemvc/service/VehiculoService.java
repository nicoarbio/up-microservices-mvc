package org.up.clasemvc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.up.clasemvc.model.Vehiculo;
import org.up.clasemvc.repository.VehiculoRepository;

import java.util.*;

@Service
@RequiredArgsConstructor
public class VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    @Transactional
    public Vehiculo crear(Vehiculo vehiculo) {
        vehiculo.setId(null);
        return vehiculoRepository.save(vehiculo);
    }

    public Optional<Vehiculo> obtenerPorId(UUID id) {
        return vehiculoRepository.findById(id);
    }

    public List<Vehiculo> obtenerTodos() {
        return vehiculoRepository.findAll();
    }

}
