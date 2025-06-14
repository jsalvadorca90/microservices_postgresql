package com.example.salvador.springboot.microservices_postgresql.service.interfaces;

import com.example.salvador.springboot.microservices_postgresql.persistence.entities.Company;

public interface ICompanyService {

    Company create(Company company);
    
    Company readByName(String name);

    Company update(Company company, String name);

    void delete(String name);

}
