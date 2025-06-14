package com.example.salvador.springboot.microservices_postgresql.configuration.apps;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Microservices_PostgreSQL", description = "Practicando con Springboot, Spring Data JPA, Microservicios y PostgreSQL.", termsOfService = "www.salvador.com/terminos_y_servicios", version = "1.0.0", contact = @Contact(name = "Salvador", url = "https://salvador.com", email = "salvador@gmail.com"), license = @License(name = "Standard Software Use License for Salvador", url = "www.salvador.com/licence")))
public class SwaggerConfig {

}
