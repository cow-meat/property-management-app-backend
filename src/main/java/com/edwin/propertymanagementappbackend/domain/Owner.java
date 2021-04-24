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
@Table(name = "owner")
// 业主表
public class Owner extends AuditModel {

    // 登录名
    private String username;

    // 密码
    private String pwd;

    // 性别
    private String gender;

    // 姓名
    private String name;

    // 单元
    private String unit;

    // 楼层
    private String floor;

    // 门牌号
    private String homeNum;

    // 联系方式
    private String phone;

}
