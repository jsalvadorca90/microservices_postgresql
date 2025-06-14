package com.example.salvador.springboot.microservices_postgresql.persistence.repositories.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.salvador.springboot.microservices_postgresql.persistence.entities.Company;


public interface ICompanyRepository extends JpaRepository<Company, Long> {

    Optional<Company> findByName(String name);

}
