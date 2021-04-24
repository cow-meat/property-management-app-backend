package com.edwin.propertymanagementappbackend.repository;

import com.edwin.propertymanagementappbackend.domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

    boolean existsByUsername(String username);

    Optional<Owner> findByUsername(String username);
}
