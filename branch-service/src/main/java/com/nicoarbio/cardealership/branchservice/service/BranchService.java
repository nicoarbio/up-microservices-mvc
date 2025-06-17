package com.nicoarbio.cardealership.branchservice.service;

import com.nicoarbio.cardealership.branchservice.dto.BranchRequest;
import com.nicoarbio.cardealership.branchservice.dto.BranchResponse;
import com.nicoarbio.cardealership.branchservice.dto.mapper.BranchMapper;
import com.nicoarbio.cardealership.branchservice.entity.Branch;
import com.nicoarbio.cardealership.branchservice.exception.types.EntityAlreadyExistsException;
import com.nicoarbio.cardealership.branchservice.repository.BranchRepository;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class BranchService {

    private final BranchRepository repository;
    private final BranchMapper mapper;

    public BranchService(BranchRepository repository, BranchMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<BranchResponse> getAll() {
        return mapper.toResponseList(repository.findAll());
    }

    public BranchResponse getById(UUID id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new NoSuchElementException("Branch " + id + " not found"));
    }

    @Transactional
    public BranchResponse create(BranchRequest request) {
        Branch entity = mapper.toEntity(request);
        try {
            repository.saveAndFlush(entity);
        } catch (DataIntegrityViolationException e) {
            throw new EntityAlreadyExistsException("Branch `" + request.name() + "` already exists", e);
        }
        return mapper.toResponse(entity);
    }

    @Transactional
    public BranchResponse update(UUID id, BranchRequest request) {
        final Branch existing = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Branch " + id + " not found"));
        mapper.toEntity(request, existing);
        try {
            repository.saveAndFlush(existing);
            return mapper.toResponse(existing);
        } catch (DataIntegrityViolationException e) {
            throw new EntityAlreadyExistsException("Branch `" + request.name() + "` already exists", e);
        }
    }

    @Transactional
    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("Branch " + id + " not found");
        }
        repository.deleteById(id);
    }

}
