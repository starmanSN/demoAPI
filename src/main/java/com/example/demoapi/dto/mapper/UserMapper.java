package com.example.demoapi.dto.mapper;

import com.example.demoapi.dto.UserDto;
import com.example.demoapi.entity.security.AccountUser;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    AccountUser toAccountUser(UserDto userDto);

    UserDto toUserDto(AccountUser accountUser);
}
