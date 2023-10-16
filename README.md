##  Weather Forecast API

## Intro
The Weather Forecast API enables users to get the specific details on weather based on 5 days forecast, such as
1) Find the warmest day in upcoming 5 days
2) Get the history of weather request made by user (for the user)


## Prerequisites:
- JDK17 (OpenJDK)
- Maven 3.9.5
- PostgreSQL


## Architecture / Design patterns

The design of this application is Domain Driven (DDD), which is providing custom weather information to the user. The design is based on onion architecture, with domain based convention. The domain is weather results processor and weather request history entity, with business logic. The other dependencies flows inwards towards the domain layer. The API layer depends on domain. 

- The domain layer is core, having entities, repositories, business logic
- The api layer is application layer without business rules (can handle transactional aspects, security aspects etc)
- The infra-rest-api exposes service to external world
- The infra-jpa connects to DB (postgres in this case)
- The infra-api-external connects with Openweather API

## Code structure 

The application is built as multi-module maven project, where each layer is an independent maven project, connected by the parent project.

```bash
|weather-forecast
|——app
|  |——infra-api-rest
|  |  |——controllers
|  |——api
|  |  |——models
|  |  |——application-services
|  |——domain
|  |  |——entity
|  |  |——repository
|  |  |——model
|  |  |——service
|  |——infra-jpa
|  |  |——jparepositories
|  |——infra-api-external
|  |  |——openweather
```


### Installation / Build

```bash
$ ./mvnw clean install
```

### Running the app

```bash
# test-environment
$ ./mvnw spring-boot:run -pl app
```

TIP: if you're running the app locally, Please make sure PostgreSQL database is running (local installation or on docker)


# Docs generation

After starting the application, the following documentation can be observed.

### Open-api specification
After running this app, the open-api docs can be seen in this URL: http://localhost:8081/api-docs . Refer in git repo here - https://github.com/im-dravo/weather-forecast/blob/main/infra-api-rest/src/main/resources/open-api.json

### Swagger UI
After running this, the swagger UI can be seen in this URL: http://localhost:8081/swagger-ui/index.html


### Technical Debt
Considering the time, the following I am marking as technical debts
1. Security of the API. The application typically needs to be secured with basic authentication, or token based authentication
2. Extensive testing. 
3. Creating the swagger/open-api doc first and then generating the API POJOs based on that using maven plugin. 
4. Customising the error responses, with the custom error message and error transaction id
5. Handling the JPA and database action transaction-based
6. Add extensive API documentations to controllers so that the swagger UI and schemas shows eloborate information about the API
7. The external api (openweather) URL is hardcoded in infra-api-external package. Ideally would need to have this details in environment properties file and then fetched to be used in app. This way the values for different environments such as test, production etc can be easily maintains. 
8. Also the API keys needs to be come from external package.  
 

