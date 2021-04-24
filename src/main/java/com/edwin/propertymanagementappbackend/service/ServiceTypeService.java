package com.edwin.propertymanagementappbackend.service;

import com.edwin.propertymanagementappbackend.controller.request.ServiceTypeCreateRequest;
import com.edwin.propertymanagementappbackend.controller.request.ServiceTypeUpdateRequest;
import com.edwin.propertymanagementappbackend.domain.ServiceType;
import com.edwin.propertymanagementappbackend.exception.core.DuplicatedException;
import com.edwin.propertymanagementappbackend.exception.core.NotFoundException;
import com.edwin.propertymanagementappbackend.repository.ServiceTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.edwin.propertymanagementappbackend.exception.core.DuplicatedError.SERVICE_TYPE_EXISTED;
import static com.edwin.propertymanagementappbackend.exception.core.NotFoundError.NOT_FOUND_SERVICE_TYPE;

@Service
@RequiredArgsConstructor
public class ServiceTypeService {

    private final ServiceTypeRepository serviceTypeRepository;

    /**
     * 获取所有的 ServiceType
     */
    public List<ServiceType> getAll() {
        return serviceTypeRepository.findAll();
    }

    /**
     * 通过ID查询 serviceType
     */
    public ServiceType findById(Long id) {
        return serviceTypeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_SERVICE_TYPE));
    }

    /**
     * 添加服务类型
     */
    public ServiceType create(ServiceTypeCreateRequest request) {

        if (serviceTypeRepository.existsByType(request.getType())) {
            throw new DuplicatedException(SERVICE_TYPE_EXISTED);
        }

        ServiceType serviceType = ServiceType
                .builder()
                .type(request.getType())
                .description(request.getDescription())
                .build();

        return serviceTypeRepository.saveAndFlush(serviceType);
    }

    /**
     * 更新服务类型
     */
    public ServiceType update(ServiceTypeUpdateRequest request) {

        ServiceType serviceType = serviceTypeRepository.findById(request.getId())
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_SERVICE_TYPE));

        serviceType.setType(request.getType());
        serviceType.setDescription(request.getDescription());

        return serviceTypeRepository.saveAndFlush(serviceType);
    }

    /**
     * 通过ID删除 serviceType
     */
    public void deleteById(Long id) {

        if (!serviceTypeRepository.existsById(id)) {
            throw new NotFoundException(NOT_FOUND_SERVICE_TYPE);
        }

        serviceTypeRepository.deleteById(id);
    }
}
