package com.nicoarbio.cardealership.salesservice.repository;

import com.nicoarbio.cardealership.salesservice.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SalesRepository extends JpaRepository<Sale, UUID> {
}
