package com.nicoarbio.cardealership.branchservice.dto.mapper;

import com.nicoarbio.cardealership.branchservice.dto.BranchRequest;
import com.nicoarbio.cardealership.branchservice.dto.BranchResponse;
import com.nicoarbio.cardealership.branchservice.entity.Branch;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BranchMapper {

    public Branch toEntity(BranchRequest req) {
        return toEntity(req, null);
    }

    public Branch toEntity(BranchRequest req, Branch existing) {
        if (existing == null) {
            existing = new Branch();
        }
        existing.setName(req.name());
        existing.setCountry(req.country());
        existing.setProvince(req.province());
        existing.setCity(req.city());
        existing.setAddress(req.address());
        existing.setOpeningDate(req.openingDate());
        existing.setLocalDeliveryTimeDays(req.localDeliveryTimeDays());
        existing.setCentralDeliveryTimeDays(req.centralDeliveryTimeDays());
        return existing;
    }

    public BranchResponse toResponse(Branch b) {
        return new BranchResponse(
                b.getId(),
                b.getName(),
                b.getCountry(),
                b.getProvince(),
                b.getCity(),
                b.getAddress(),
                b.getOpeningDate(),
                b.getLocalDeliveryTimeDays(),
                b.getCentralDeliveryTimeDays(),
                b.getCreatedAt(),
                b.getUpdatedAt()
        );
    }

    public List<BranchResponse> toResponseList(List<Branch> branches) {
        return branches.stream().map(this::toResponse).collect(Collectors.toList());
    }

}
