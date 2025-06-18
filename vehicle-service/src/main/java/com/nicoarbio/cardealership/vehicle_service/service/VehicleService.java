package com.nicoarbio.cardealership.vehicle_service.service;

import com.nicoarbio.cardealership.exception.types.EntityAlreadyExistsException;
import com.nicoarbio.cardealership.vehicle_service.dto.VehicleRequest;
import com.nicoarbio.cardealership.vehicle_service.dto.VehicleResponse;
import com.nicoarbio.cardealership.vehicle_service.dto.mapper.VehicleMapper;
import com.nicoarbio.cardealership.vehicle_service.entity.Vehicle;
import com.nicoarbio.cardealership.vehicle_service.repository.VehicleRepository;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class VehicleService {

    private final VehicleRepository repository;
    private final VehicleMapper mapper;

    public VehicleService(VehicleRepository repository, VehicleMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<VehicleResponse> getAll() {
        return mapper.toResponseList(repository.findAll());
    }

    public VehicleResponse getById(UUID id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new NoSuchElementException("Vehicle " + id + " not found"));
    }

    @Transactional
    public VehicleResponse create(VehicleRequest request) {
        Vehicle entity = mapper.toEntity(request);
        try {
            repository.saveAndFlush(entity);
        } catch (Exception e) {
            throw new EntityAlreadyExistsException("Vehicle `" + entity.getVehicleModel() + "` already exists", e);
        }
        return mapper.toResponse(entity);
    }

    @Transactional
    public VehicleResponse update(UUID id, VehicleRequest request) {
        final Vehicle existing = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Vehicle " + id + " not found"));
        mapper.toEntity(request, existing);
        try {
            repository.saveAndFlush(existing);
            return mapper.toResponse(existing);
        } catch (DataIntegrityViolationException e) {
            throw new EntityAlreadyExistsException("Vehicle `" + existing.getVehicleModel() + "` already exists", e);
        }
    }

    @Transactional
    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("Vehicle " + id + " not found");
        }
        repository.deleteById(id);
    }

}
