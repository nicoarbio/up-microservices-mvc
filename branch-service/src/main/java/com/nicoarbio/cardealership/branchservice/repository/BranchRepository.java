package com.nicoarbio.cardealership.branchservice.repository;

import com.nicoarbio.cardealership.branchservice.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BranchRepository extends JpaRepository<Branch, UUID> {
}
