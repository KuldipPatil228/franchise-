package com.example.franchise.DTO.RequstDto;

import com.example.franchise.DTO.UserDto;
import com.example.franchise.Enums.UserType;

public record UpdateUserRequest(
        Long id,
        String name,

        String email,

        String mobileNumber,

        UserType userType) {
    public UserDto prepareUserUpdateRequest() {
        return new UserDto(id, name, email, mobileNumber, userType);
    }
}
