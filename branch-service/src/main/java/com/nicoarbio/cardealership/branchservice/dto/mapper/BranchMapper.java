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
        Branch b = new Branch();
        b.setName(req.name());
        b.setCountry(req.country());
        b.setProvince(req.province());
        b.setCity(req.city());
        b.setAddress(req.address());
        b.setOpeningDate(req.openingDate());
        b.setLocalDeliveryTimeDays(req.localDeliveryTimeDays());
        b.setCentralDeliveryTimeDays(req.centralDeliveryTimeDays());
        return b;
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
