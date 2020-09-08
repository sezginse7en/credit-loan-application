# credit-loan-application

Minimal credit loan sample app.

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 4](https://maven.apache.org)

## Dependencies

- spring-boot
- h2database
- junit
- mockito

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.kocfinansman.creditloan.app.CreditLoanSystemApplication` class from your IDE.

Alternatively you can use the following [Docker](https://docs.docker.com/develop) commands

docker build :

```shell
 docker build -t app/credit-loan-application .
```

and run

```shell
  docker run -p 8080 app/credit-loan-application
```

## Endpoints

http://localhost:8080/creditloan

*Please use 8080 port, because the react project use this endpoint.*

To make call from Postman please disabled CorsFilter bean, but to make call from ReactApp CorsFilter bean must be enabled.