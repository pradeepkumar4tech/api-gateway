FROM openjdk:8
ADD target/api-gateway-0.0.1-SNAPSHOT.jar  api-gateway-0.0.1.jar
EXPOSE 8001
ENTRYPOINT ["java" , "-jar" ,"api-gateway-0.0.1.jar"]