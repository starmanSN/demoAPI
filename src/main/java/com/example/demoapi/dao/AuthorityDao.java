package com.example.demoapi.dao;

import com.example.demoapi.entity.security.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityDao extends JpaRepository<Authority, Long> {
}
