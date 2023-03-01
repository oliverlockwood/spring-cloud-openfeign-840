# spring-cloud-openfeign-retry-sameserver-bug
To demonstrate the bug described in https://github.com/spring-cloud/spring-cloud-openfeign/issues/650

# Steps to reproduce:
1. Run `./mvnw clean install` to build the project
2. Run `docker-compose down` to ensure the state is clean
3. Run `docker-compose up -d` in the root of the project to spin up Consul, and the two Wiremock instances which are
   pretending to be the downstream service
4. Run `register-wiremocks-with-consul.sh` to register the two Wiremock "downstream services"
5. Run `mvn spring-boot:run` to bring up the client application
6. Run `curl localhost:1234/test` to get the client application to try to hit the downstream service

Change `max-retries-on-same-service-instance` to `0` in `application.yml`, and run steps 4-5 again, to demonstrate how
the retry works fine when the bugged configuration is avoided.

# Notes
- Spring-Boot 3.0.3 & Spring-Cloud 2022.0.1 - read timeout configured differently - the bug ??? -
- Spring-Boot 2.7.9 & Spring-Cloud 2021.0.6 - the bug **does** manifest
- Spring-Boot 2.7.7 & Spring-Cloud 2021.0.5 - the bug **does** manifest
- Spring-Boot 2.6.2 & Spring-Cloud 2021.0.0 - the bug **does** manifest
