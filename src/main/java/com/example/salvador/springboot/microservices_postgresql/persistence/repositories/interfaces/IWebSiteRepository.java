package com.example.salvador.springboot.microservices_postgresql.persistence.repositories.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.salvador.springboot.microservices_postgresql.persistence.entities.WebSite;

public interface IWebSiteRepository extends JpaRepository<WebSite, Long> {

}
