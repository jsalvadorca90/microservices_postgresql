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

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@RequestMapping("/company")
@Slf4j
public class CompanyController {

    private final ICompanyService companyService;

    @GetMapping("/{name}")
    public ResponseEntity<Company> get(@PathVariable String name) {
        log.info("GET:company{}", name);
        return ResponseEntity.ok(this.companyService.readByName(name));
    }

    @PostMapping("/")
    public ResponseEntity<Company> post(@RequestBody Company company) {
        log.info("POST:company{}", company.getName());
        return ResponseEntity.created(
                URI.create(this.companyService.create(company).getName()))
                .build();
    }

    @PutMapping("/{name}")
    public ResponseEntity<Company> put(@RequestBody Company company, @PathVariable String name) {
        log.info("PUT:company{}", name);
        return ResponseEntity.ok(this.companyService.update(company, name));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<?> delete(@PathVariable String name) {
        log.info("DELETE:company{}", name);
        this.companyService.delete(name);
        return ResponseEntity.noContent().build();
    }

}
