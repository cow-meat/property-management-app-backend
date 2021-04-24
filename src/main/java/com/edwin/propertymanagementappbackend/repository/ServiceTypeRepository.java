package com.edwin.propertymanagementappbackend.repository;

import com.edwin.propertymanagementappbackend.domain.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceTypeRepository extends JpaRepository<ServiceType, Long> {
}
