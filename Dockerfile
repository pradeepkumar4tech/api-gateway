FROM openjdk:8-jdk-alpine
WORKDIR /target
ENV 8767
EXPOSE 8767
COPY ./target/*.jar api-gateway.jar
ENTRYPOINT ["java", "-jar", "/api-gateway.jar"] 
