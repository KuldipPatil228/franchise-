package com.example.franchise.DTO.RequstDto;

import com.example.franchise.DTO.UserDto;
import com.example.franchise.Enums.UserType;

public record CreateUserRequest(
        Long id,
        String name,

        String email,

        String mobileNumber,

        UserType userType
) {
    public UserDto PrepareUserCreateRequest() {
        return new UserDto(null, name, email, mobileNumber, userType);
    }
}
