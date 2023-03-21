package com.example.demoapi.service;

import com.example.demoapi.dto.UserDto;
import com.example.demoapi.entity.security.AccountUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    UserDto register(UserDto userDto);
    UserDto update(UserDto userDto);
    AccountUser findByUsername(String username);
    AccountUser update(AccountUser userDto);
    UserDto findById(Long id);
    List<UserDto> findAll();
    void deleteById(Long id);
}
