package com.edwin.propertymanagementappbackend.repository;

import com.edwin.propertymanagementappbackend.domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
