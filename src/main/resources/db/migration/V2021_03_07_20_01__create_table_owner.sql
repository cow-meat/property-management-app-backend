create table if not exists property_management.owner
(
    `id`          bigint auto_increment primary key,
    `username`    varchar(255)                        null comment '登录名',
    `pwd`         varchar(255)                        null comment '密码',
    `floor`        varchar(255)                        null comment '楼层',
    `gender`      varchar(255)                        null comment '性别',
    `home_num`    varchar(255)                        null comment '门牌号',
    `name`        varchar(255)                        null comment '姓名',
    `phone`       varchar(255)                        null comment '联系方式',
    `unit`        varchar(255)                        null comment '单元',
    `create_time` timestamp default CURRENT_TIMESTAMP comment '创建时间',
    `update_time` timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间'
);

