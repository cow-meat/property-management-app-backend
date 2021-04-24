package com.edwin.propertymanagementappbackend.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class AuditModel implements Serializable {

    private static final String TIME_ZONE = "Asia/Shanghai";

    private static final String FORMAT_DATE_TIME = "yyyy-MM-dd HH:mm:ss";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = FORMAT_DATE_TIME, timezone = TIME_ZONE)
    @CreatedDate
    private Instant createTime;

    @JsonFormat(pattern = FORMAT_DATE_TIME, timezone = TIME_ZONE)
    @LastModifiedDate
    private Instant updateTime;
}
