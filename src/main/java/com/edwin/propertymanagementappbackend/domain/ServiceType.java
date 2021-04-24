package com.edwin.propertymanagementappbackend.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "service_type")
public class ServiceType extends AuditModel {

    private String type;

    private String typeName;
}
