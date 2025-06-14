package com.example.salvador.springboot.microservices_postgresql.service.implementations;

import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.example.salvador.springboot.microservices_postgresql.persistence.entities.Category;
import com.example.salvador.springboot.microservices_postgresql.persistence.entities.Company;
import com.example.salvador.springboot.microservices_postgresql.persistence.repositories.interfaces.ICompanyRepository;
import com.example.salvador.springboot.microservices_postgresql.service.interfaces.ICompanyService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class CompanyServiceImpl implements ICompanyService {

    private final ICompanyRepository companyRepository;

    @Override
    public Company create(Company company) {
        company.getWebSites().forEach(webSite -> {
            if (Objects.isNull(webSite.getCategory())) {
                webSite.setCategory(Category.NONE);
            }
        });
        return this.companyRepository.save(company);
    }

    @Override
    public Company readByName(String name) {
        return this.companyRepository.findByName(name)
                .orElseThrow(() -> new NoSuchElementException("Compañía no encontrada."));
    }

    @Override
    public Company update(Company company, String name) {
        var companyToUpdate = this.companyRepository.findByName(name)
                .orElseThrow(() -> new NoSuchElementException("Compañía no encontrada."));
        companyToUpdate.setLogo(company.getLogo());
        companyToUpdate.setFoundationDate(company.getFoundationDate());
        companyToUpdate.setFounder(company.getFounder());
        return this.companyRepository.save(companyToUpdate);
    }

    @Override
    public void delete(String name) {
        var companyToDelete = this.companyRepository.findByName(name)
                .orElseThrow(() -> new NoSuchElementException("Compañía no encontrada."));
                this.companyRepository.delete(companyToDelete);
    }

}
