package com.example.franchise.DTO.RequstDto;

import com.example.franchise.DTO.UserDto;
import com.example.franchise.Enums.UserType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record UpdateUserRequest(
        Long id,

        String name,

        String email,

        String mobileNumber,

        @Enumerated(EnumType.STRING)
        UserType userType)
{
    public UserDto prepareUserUpdateRequest() {
        return new UserDto(id,name,email,mobileNumber,null,null,userType);
    }
}
