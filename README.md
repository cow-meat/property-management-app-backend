# 物业管理APP 后端

## 环境

* jdk 8
* mysql 5.7
* springboot 2.4.5
* spring-data-jpa
* flyway
* lombok (使用Idea或Eclipse时需要安装 lombok 否则语法检测会报错、但不影响正常使用)


## mysql使用说明：

* mysql 安装 5.7版本
    * 如果为docker环境，可直接执行以下命令

```docker
docker run --name mysql -e MYSQL_ROOT_PASSWORD=123456 -d -i -p 3306:3306 --restart=always  mysql:5.7
```

* 安装MySQL时，程序中默认用户名：root，密码：123456，可根据自己的配置修改 application.yml
* 安装和配置好MySQL后，创建数据库：property_management

```mysql
CREATE DATABASE `property_management` DEFAULT CHARACTER set utf8mb4 collate utf8mb4_general_ci;
```

## swagger-ui

```
http://localhost:8080/property-management/swagger-ui/index.html#/
```

## 启动说明

* 注意：安装好环境后，需要将 src/main/resources/application.yml
  配置中的url的地址更换为数据库的安装地址
