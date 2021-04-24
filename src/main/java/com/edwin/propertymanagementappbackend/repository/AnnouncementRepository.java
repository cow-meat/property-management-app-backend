package com.edwin.propertymanagementappbackend.repository;

import com.edwin.propertymanagementappbackend.domain.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
}
