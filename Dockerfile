FROM openjdk:8
ADD target/trabalho-final-microservices.jar trabalho-final-microservices.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "trabalho-final-microservices.jar"]