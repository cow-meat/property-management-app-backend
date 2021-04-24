package com.edwin.propertymanagementappbackend.repository;

import com.edwin.propertymanagementappbackend.domain.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServiceTypeRepository extends JpaRepository<ServiceType, Long> {

    Optional<ServiceType> findByType(String type);

    boolean existsByType(String type);
}
