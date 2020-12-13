eureka-server 服务注册中心
-   依赖：
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
```
-   Eureka是内置的，所以要新建个单独的module使用，而zk和consul需要在外部安装好软件
