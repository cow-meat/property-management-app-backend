create table if not exists property_management.announcement
(
    `id`          bigint auto_increment primary key,
    `title`       varchar(255)                        null comment '标题',
    `context`     varchar(255)                        null comment '内容',
    `create_time` timestamp default CURRENT_TIMESTAMP comment '创建时间',
    `update_time` timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间'
);
