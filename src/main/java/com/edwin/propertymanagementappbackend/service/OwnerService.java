package com.edwin.propertymanagementappbackend.service;

import com.edwin.propertymanagementappbackend.controller.request.OwnerCreateRequest;
import com.edwin.propertymanagementappbackend.controller.request.OwnerLoginRequest;
import com.edwin.propertymanagementappbackend.controller.request.OwnerUpdateRequest;
import com.edwin.propertymanagementappbackend.domain.Owner;
import com.edwin.propertymanagementappbackend.exception.core.DuplicatedException;
import com.edwin.propertymanagementappbackend.exception.core.NotFoundException;
import com.edwin.propertymanagementappbackend.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.edwin.propertymanagementappbackend.exception.core.DuplicatedError.OWNER_EXISTED;
import static com.edwin.propertymanagementappbackend.exception.core.NotFoundError.NOT_FOUND_OWNER;
import static com.edwin.propertymanagementappbackend.exception.core.NotFoundError.USERNAME_OR_PASSWORD_ERROR;

@Service
@RequiredArgsConstructor
public class OwnerService {

    private final OwnerRepository ownerRepository;

    public List<Owner> getAll() {
        return ownerRepository.findAll();
    }

    public Owner findById(Long id) {

        return ownerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_OWNER));

    }

    public Owner create(OwnerCreateRequest request) {

        if (ownerRepository.existsByUsername(request.getUsername())) {
            throw new DuplicatedException(OWNER_EXISTED);
        }

        Owner owner = Owner.builder()
                .username(request.getUsername())
                .pwd(request.getPwd())
                .gender(request.getGender())
                .name(request.getName())
                .unit(request.getUnit())
                .floor(request.getFloor())
                .homeNum(request.getHomeNum())
                .phone(request.getPhone())
                .build();

        return ownerRepository.saveAndFlush(owner);
    }

    public Owner update(OwnerUpdateRequest request) {

        Owner owner = ownerRepository.findById(request.getId())
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_OWNER));

        owner.setUsername(request.getUsername());
        owner.setPwd(request.getPwd());
        owner.setGender(request.getGender());
        owner.setName(request.getName());
        owner.setUnit(request.getUnit());
        owner.setFloor(request.getFloor());
        owner.setHomeNum(request.getHomeNum());
        owner.setPhone(request.getPhone());

        return ownerRepository.saveAndFlush(owner);
    }

    public void deleteById(Long id) {
        if (!ownerRepository.existsById(id)) {
            throw new NotFoundException(NOT_FOUND_OWNER);
        }
        ownerRepository.deleteById(id);
    }

    public Owner login(OwnerLoginRequest request) {
        Owner owner = ownerRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new NotFoundException(USERNAME_OR_PASSWORD_ERROR));

        if (!owner.getPwd().equals(request.getPwd())) {
            throw new NotFoundException(USERNAME_OR_PASSWORD_ERROR);
        }

        return owner;
    }
}
