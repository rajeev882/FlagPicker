# Spring Boot Application FlagPicker
[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2FSpring-Boot-Framework%2FSpring-Boot-Application-Template.svg?type=shield)](https://app.fossa.io/projects/git%2Bgithub.com%2FSpring-Boot-Framework%2FSpring-Boot-Application-Template?ref=badge_shield)

## Built With
* 	[Maven](https://maven.apache.org/) - Dependency Management
* 	Spring Web MVC
* 	Spring REST API
* 	Spring Profile Concept
*  Spring Data JPA
* 	Custom Cache Builder - i. Demo implementation using in-memory look up  ii Spring Data JPA implementation
* 	Global Exception Handler (Controller Advice Spring AOP)
* 	Junit using Mokito
* 	Interface Based implementation 
* 	[Swagger](https://swagger.io/) - Open-Source software framework backed by a large ecosystem of tools that helps developers design, build, document, and consume RESTful Web services.
* [Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications
* 	[git](https://git-scm.com/) - Free and Open-Source distributed version control system 

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.arc.sbtest.SBtemplateApplication` class from your IDE.

- Download the zip or clone the Git repository.
- Unzip the zip file (if you downloaded one)
- Open Command Prompt and Change directory (cd) to folder containing pom.xml
- Open Eclipse 
   - File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
   - Select the project
- Choose the Spring Boot Application file (search for @SpringBootApplication)
- Right Click on the file and Run as Java Application



```shell
mvn spring-boot:run
```
### Actuator

To monitor and manage your application

|  URL |  Method |
|----------|--------------|
|`http://localhost:8080`  						| GET |
|`http://localhost:8080/FlagPicker/actuator/`             | GET |

## Documentation

* [Swagger](http://localhost:8080/FlagPicker/documentation/) - Documentation & Testing



