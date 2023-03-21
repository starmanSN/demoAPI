package com.example.demoapi.dao;


import com.example.demoapi.entity.security.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRoleDao extends JpaRepository<AccountRole, Long> {
    AccountRole findByName(String name);
}
