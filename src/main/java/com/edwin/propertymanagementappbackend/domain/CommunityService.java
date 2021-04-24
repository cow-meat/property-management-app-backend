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
@Table(name = "community_service")
public class CommunityService extends AuditModel {

    private Long ownerId;

    private Long typeId;

    private String context;

    private String status;
}
