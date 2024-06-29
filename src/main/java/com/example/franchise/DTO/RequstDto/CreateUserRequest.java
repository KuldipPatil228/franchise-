package com.example.franchise.DTO.RequstDto;

import com.example.franchise.DTO.UserDto;
import com.example.franchise.Enums.UserType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record CreateUserRequest(
        Long id,

        String name,

        String email,

        String mobileNumber,

        String userName,

        String password,

        @Enumerated(EnumType.STRING)
        UserType userType

) {
    public UserDto PrepareUserCreateRequest() {
        return new UserDto(null, name, email, mobileNumber,userName,password, userType);
    }
}
