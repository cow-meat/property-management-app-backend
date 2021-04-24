create table if not exists property_management.service_type
(
    `id`          bigint auto_increment primary key,
    `type`        varchar(255)                        null comment '服务类型',
    `description` varchar(255)                        null comment '服务描述',
    `create_time` timestamp default CURRENT_TIMESTAMP comment '创建时间',
    `update_time` timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间'
);
