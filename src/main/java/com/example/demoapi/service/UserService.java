package com.example.demoapi.service;

import com.example.demoapi.dto.AccountUserDto;
import com.example.demoapi.entity.security.AccountUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    AccountUserDto register(AccountUserDto accountUserDto);

    AccountUserDto update(AccountUserDto accountUserDto);

    AccountUser findByUsername(String username);

    AccountUser update(AccountUser userDto);

    AccountUserDto findById(Long id);

    List<AccountUserDto> findAll();

    void deleteById(Long id);
}
