package com.edwin.propertymanagementappbackend.service;

import com.edwin.propertymanagementappbackend.controller.request.CommunityServiceCreateRequest;
import com.edwin.propertymanagementappbackend.controller.request.CommunityServiceUpdateRequest;
import com.edwin.propertymanagementappbackend.domain.CommunityService;
import com.edwin.propertymanagementappbackend.enums.ServiceStatus;
import com.edwin.propertymanagementappbackend.exception.core.NotFoundException;
import com.edwin.propertymanagementappbackend.repository.CommunityServiceRepository;
import com.edwin.propertymanagementappbackend.repository.OwnerRepository;
import com.edwin.propertymanagementappbackend.repository.ServiceTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.edwin.propertymanagementappbackend.exception.core.NotFoundError.*;

@Service
@RequiredArgsConstructor
public class CommunityServiceImpl {

    private final CommunityServiceRepository communityServiceRepository;
    private final OwnerRepository ownerRepository;
    private final ServiceTypeRepository serviceTypeRepository;


    public List<CommunityService> getAll() {
        return communityServiceRepository.findAll();
    }

    public CommunityService findById(Long id) {
        return communityServiceRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_COMMUNITY_SERVICE));
    }

    public CommunityService create(CommunityServiceCreateRequest request) {

        if (!ownerRepository.existsById(request.getOwnerId())) {
            throw new NotFoundException(NOT_FOUND_OWNER);
        }

        if (!serviceTypeRepository.existsById(request.getTypeId())) {
            throw new NotFoundException(NOT_FOUND_SERVICE_TYPE);
        }

        CommunityService communityService = CommunityService.builder()
                .context(request.getContext())
                .ownerId(request.getOwnerId())
                .status(ServiceStatus.CREATE)
                .build();

        return communityServiceRepository.saveAndFlush(communityService);
    }

    public void deleteById(Long id) {
        if (!communityServiceRepository.existsById(id)) {
            throw new NotFoundException(NOT_FOUND_COMMUNITY_SERVICE);
        }
        communityServiceRepository.deleteById(id);
    }

    public CommunityService update(CommunityServiceUpdateRequest request) {

        CommunityService communityService = communityServiceRepository.findById(request.getId())
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_COMMUNITY_SERVICE));

        if (!ownerRepository.existsById(request.getOwnerId())) {
            throw new NotFoundException(NOT_FOUND_OWNER);
        }

        if (!serviceTypeRepository.existsById(request.getTypeId())) {
            throw new NotFoundException(NOT_FOUND_SERVICE_TYPE);
        }

        communityService.setOwnerId(request.getOwnerId());
        communityService.setTypeId(request.getTypeId());
        communityService.setContext(request.getContext());
        return communityServiceRepository.saveAndFlush(communityService);
    }

    public CommunityService close(Long id) {
        CommunityService communityService = communityServiceRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_COMMUNITY_SERVICE));
        communityService.setStatus(ServiceStatus.DONE);
        return communityServiceRepository.saveAndFlush(communityService);
    }
}
