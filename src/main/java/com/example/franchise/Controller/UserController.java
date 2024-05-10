package com.example.franchise.Controller;

import com.example.franchise.DTO.RequstDto.CreateUserRequest;
import com.example.franchise.DTO.RequstDto.UpdateUserRequest;
import com.example.franchise.DTO.UserDto;
import com.example.franchise.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    private static final Logger log = Logger.getLogger(UserController.class.getName());


    @PostMapping("/api/user/create")
    public UserDto createUser(@RequestBody CreateUserRequest createRequest) {
        return userService.create(createRequest.PrepareUserCreateRequest());
    }

    @GetMapping("/api/user/read/{userId}")
    public UserDto read(@PathVariable Long userId) {
        return userService.read(userId);
    }

    @PutMapping("/api/user/update")
    public UserDto update(@RequestBody UpdateUserRequest request) {
        return userService.update(request.prepareUserUpdateRequest());
    }

    @DeleteMapping("/api/user/delete/{userId}")
    public String delete(@PathVariable Long userId){
        userService.delete(userId);
        return "User deleted : " + userId;
    }

}
