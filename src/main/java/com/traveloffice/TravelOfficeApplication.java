package com.traveloffice;

import com.traveloffice.entity.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@RestController
@EnableSwagger2
public class TravelOfficeApplication {
    public static void main(String[] args) {
        SpringApplication.run(com.traveloffice.TravelOfficeApplication.class, args);
    }

    @GetMapping("/")
    Person getPersonFromGET(@RequestParam String name, @RequestParam String lName) {
        Person person = new Person(name, lName);
        person.setName(person.getName().toLowerCase());
        person.setlName(person.getlName().toLowerCase());
        return person;
    }

    @PostMapping("/")
    Person getPersonFromPOST(@RequestBody Person person) {
        person.setName(person.getName().toUpperCase());
        person.setlName(person.getlName().toUpperCase());
        return person;
    }

	/*
	 http://localhost:8080//v2/api-docs
	 http://localhost:8080/swagger-ui.html
	  */

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}

class Person {
    private String name;
    private String lName;

    public Person(String name, String lName) {
        this.name = name;
        this.lName = lName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }
}