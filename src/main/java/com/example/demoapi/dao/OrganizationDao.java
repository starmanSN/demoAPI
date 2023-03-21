package com.example.demoapi.dao;

import com.example.demoapi.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrganizationDao extends JpaRepository<Organization, Long> {
    Organization findByNameLike(String name);
    Optional<Organization> findByName(String name);
}
