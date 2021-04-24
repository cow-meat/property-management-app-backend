package com.edwin.propertymanagementappbackend.service;

import com.edwin.propertymanagementappbackend.controller.request.AnnouncementCreateRequest;
import com.edwin.propertymanagementappbackend.controller.request.AnnouncementUpdateRequest;
import com.edwin.propertymanagementappbackend.domain.Announcement;
import com.edwin.propertymanagementappbackend.exception.core.NotFoundException;
import com.edwin.propertymanagementappbackend.repository.AnnouncementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.edwin.propertymanagementappbackend.exception.core.NotFoundError.NOT_FOUND_ANNOUNCEMENT;

@Service
@RequiredArgsConstructor
public class AnnouncementService {

    private final AnnouncementRepository announcementRepository;

    public List<Announcement> getAll() {
        return announcementRepository.findAll();
    }

    public Announcement findById(Long id) {
        return announcementRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_ANNOUNCEMENT));
    }

    public Announcement create(AnnouncementCreateRequest request) {

        Announcement announcement = Announcement.builder()
                .title(request.getTitle())
                .context(request.getContext())
                .build();

        return announcementRepository.saveAndFlush(announcement);
    }

    public Announcement update(AnnouncementUpdateRequest request) {

        Announcement announcement = announcementRepository.findById(request.getId())
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_ANNOUNCEMENT));

        announcement.setTitle(request.getTitle());
        announcement.setContext(request.getContext());

        return announcementRepository.saveAndFlush(announcement);
    }

    public void deleteById(Long id) {
        if (!announcementRepository.existsById(id)) {
            throw new NotFoundException(NOT_FOUND_ANNOUNCEMENT);
        }
        announcementRepository.deleteById(id);
    }
}
