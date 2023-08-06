FROM openjdk:17-jdk-alpine

RUN mkdir -p /app

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
