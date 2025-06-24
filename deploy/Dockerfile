FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/*.jar product.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "product.jar"]