create table if not exists property_management.community_service
(
    `id`          bigint auto_increment primary key,
    `type_id`     bigint                              null comment '服务类型',
    `owner_id`    bigint                              null comment '服务业主ID',
    `context`     varchar(255)                        null comment '服务描述',
    `status`      varchar(255)                        null comment '服务状态',
    `create_time` timestamp default CURRENT_TIMESTAMP comment '创建时间',
    `update_time` timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间'
);
