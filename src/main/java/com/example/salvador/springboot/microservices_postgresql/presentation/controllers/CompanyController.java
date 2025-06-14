package com.example.salvador.springboot.microservices_postgresql.presentation.controllers;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.salvador.springboot.microservices_postgresql.persistence.entities.Company;
import com.example.salvador.springboot.microservices_postgresql.service.interfaces.ICompanyService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@RequestMapping("/company")
@Slf4j
@Tag(name = "Company", description = "Controller de Company")
public class CompanyController {

    private final ICompanyService companyService;

    @Operation(summary = "Endpoint get", description = "Entrega registro de sitios web para compañía específica.")
    @GetMapping("/{name}")
    public ResponseEntity<Company> get(@PathVariable String name) {
        log.info("GET:company{}", name);
        return ResponseEntity.ok(this.companyService.readByName(name));
    }

    @Operation(summary = "Endpoint post", description = "Ingresa registro de sitios web para compañía específica.")
    @PostMapping("/")
    public ResponseEntity<Company> post(@RequestBody Company company) {
        log.info("POST:company{}", company.getName());
        return ResponseEntity.created(
                URI.create(this.companyService.create(company).getName()))
                .build();
    }

    @Operation(summary = "Endpoint put", description = "Modifica registro de sitios web para compañía específica.")
    @PutMapping("/{name}")
    public ResponseEntity<Company> put(@RequestBody Company company, @PathVariable String name) {
        log.info("PUT:company{}", name);
        return ResponseEntity.ok(this.companyService.update(company, name));
    }

    @Operation(summary = "Endpoint delete", description = "Elimina registro de sitios web para compañía específica.")
    @DeleteMapping("/{name}")
    public ResponseEntity<?> delete(@PathVariable String name) {
        log.info("DELETE:company{}", name);
        this.companyService.delete(name);
        return ResponseEntity.noContent().build();
    }

}
