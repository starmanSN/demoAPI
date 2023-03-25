package com.example.demoapi.dto.mapper;

import com.example.demoapi.dto.AccountUserDto;
import com.example.demoapi.entity.security.AccountUser;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {

    AccountUser toAccountUser(AccountUserDto accountUserDto);

    AccountUserDto toUserDto(AccountUser accountUser);
}
