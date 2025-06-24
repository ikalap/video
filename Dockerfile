# 使用轻量级的 Alpine 镜像作为基础镜像，安装 OpenJDK 17
FROM openjdk:17-jdk-slim

# 设置工作目录
WORKDIR /app

# 拷贝本地的 Spring Boot 构建输出文件（通常是 .jar 文件）
COPY target/*.jar app.jar

# 设置启动命令
ENTRYPOINT ["java", "-jar", "app.jar"]