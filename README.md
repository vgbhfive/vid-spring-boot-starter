# vid-spring-boot-starter
👍自定义Spring Boot 组件，提供唯一ID，也可以解析ID

## 简介
分布式ID 分发器。
内部通过**位运算**实现快速的计算和生成，为系统提供更快的支持速度。

## Using
1. Download
```
git clone git@github.com:vgbhfive/vid-spring-boot-starter.git
```

2. Make
```
mvn clean package
```

3. Depandency
```
<!--vid-->
<dependency>
    <groupId>cn.vgbhfive.vid</groupId>
    <artifactId>vid-spring-boot-starter</artifactId>
    <version>0.3.1</version>
</dependency>
```

4. Application.properties
```
# vid
# 机器号 -> 取值范围 0 ~ 2^10-1
spring.vid.machine=1
# 生成方式 -> 取值范围 0 ~ 2^2-1
spring.vid.gen-method=1
# 类型 -> 取值范围 0 ~ 1
spring.vid.type=1
# 版本 -> 取值范围 0 ~ 1 (0:正数，1:负数)
spring.vid.version=0
```

## Author
[My Blog](https://vgbhfive.cn)

## Version

### Version 0.1.0
application.properties:
```
spring.vid.machine=10
spring.vid.seq=20
spring.vid.time=30
spring.vid.gen-method=2
spring.vid.type=1
spring.vid.version=1
```
![0.1.0-1.jps](/images/0.1.0-1.jpg)

### Version 0.2.0
重新构想了整体的内容，框架的整体内容已经梳理出来，具体的解释看简介吧。<br>
application.properties:
```
spring.vid.machine=1
spring.vid.gen-method=1
spring.vid.type=1
spring.vid.version=1
```
![0.2.0-1.jps](/images/0.2.0-1.jpg)

### Version 0.3.0
实现了生成ID 和解析ID 功能，目前还存在一些小bug 。<br>
application.properties:
```
spring.vid.machine=1
spring.vid.gen-method=1
spring.vid.type=1
spring.vid.version=1
```
![0.3.0-1.jps](/images/0.3.0-1.jpg)

### Version 0.3.1
解决了存在的小问题，第一个完全正式可以用的版本。<br>
application.properties:
```
spring.vid.machine=1
spring.vid.gen-method=1
spring.vid.type=1
spring.vid.version=0
```

### Version 1.0.0
功能全部实现，第一个完全正式可以用的版本。<br>
application.properties:
```
spring.vid.machine=1
spring.vid.gen-method=1
spring.vid.type=1
spring.vid.version=0
```

