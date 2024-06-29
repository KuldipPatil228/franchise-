package com.example.franchise.service;

import com.example.franchise.DTO.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserDto create(UserDto userDto);

    UserDto read(Long UserId);

    UserDto update(UserDto userDto);

    String delete(Long userId);

    List<UserDto> list();
}
