package com.example.franchise.Converter;

import com.example.franchise.DTO.UserDto;
import com.example.franchise.Entitiy.User;

import java.util.function.Function;

public class UserConverter extends AbstractConverter<UserDto,User> {
    public UserConverter() {
        super(
                userDTO -> {
                    User user = new User();
//                    user.setId(SecurityUtil.decryptId(userDTO.id()));
                    user.setName(userDTO.name());
                    user.setEmail(userDTO.email());
                    user.setUserType(userDTO.userType());
                    user.setUserName(user.getUserName());
                    user.setPassword(userDTO.password());
                    user.setMobileNumber(userDTO.mobileNumber());
                    return user;
                }, user -> {
                    return new UserDto(
                            user.getId(),
                            user.getName(),
                            user.getEmail(),
                            user.getMobileNumber(),
                            null,
                            null,
                            user.getUserType()
                    );

                }
        );
    }
    public User update(User user, UserDto userDto){
       user.setName(userDto.name());
       user.setEmail(user.getEmail());
       user.setMobileNumber(userDto.mobileNumber());
       user.setUserType(userDto.userType());
       return user;
    }
}
