# examples-greenmail

Example of usage of Greenmail within a Junit5 Test

## Used Frameworks and Libraries

For main application

- **Spring boot** with mail and web starter
- **Apache Velocity** as template engine for dynamically applying values to html mail templates

For testing

- **Greenmail** for starting mail server and receiving mails for assertions
- **Jsoup** for extracting mail content in order to assert its elements

## How to run

This example is a console application. Open project with your favourite editor/IDE and run from the main class
**ExamplesGreenmailApplication**

or run with Maven via

``./mvnw spring-boot:run``

As mail server docker image of [mailhog](https://registry.hub.docker.com/r/mailhog/mailhog/)
was used. It can be downloaded and used via following commands.

```
docker pull mailhog/mailhog
docker run -d -p 1025:1025 -p 8025:8025 --name mailhog mailhog/mailhog
```

Mail server configuration can be change from application.properties

