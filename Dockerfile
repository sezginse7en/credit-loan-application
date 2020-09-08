FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY credit-loan-app/target/*.jar credit-loan-application.jar
ENTRYPOINT ["java","-jar","/credit-loan-application.jar"]




