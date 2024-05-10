package com.example.franchise.service.serviceImpl;

import com.example.franchise.Controller.UserController;
import com.example.franchise.DTO.UserDto;
import com.example.franchise.Entitiy.User;
import com.example.franchise.Repository.UserRepository;
import com.example.franchise.Util.ConverterUtil;
import com.example.franchise.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class userServiceImpl implements UserService {

    private UserRepository userRepository;

    public userServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private static final Logger log = Logger.getLogger(UserController.class.getName());


    @Override
    public UserDto create(UserDto userDto) {
        User user = ConverterUtil.userConverter().toEntity(userDto);
        return ConverterUtil.userConverter().toDto(userRepository.save(user));
    }

    @Override
    public UserDto read(Long UserId) {
        User user = fetchUser(UserId);
        return ConverterUtil.userConverter().toDto(user);
    }

    @Override
    public UserDto update(UserDto userDto) {
        //validate user
        User user = fetchUser(userDto.id());
        User updatedUser = ConverterUtil.userConverter().update(user, userDto);
        return ConverterUtil.userConverter().toDto(userRepository.save(updatedUser));
    }

    @Override
    public String delete(Long userId) {
        User user = fetchUser(userId);
        userRepository.delete(user);
        return "";
    }

    private User fetchUser(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new RuntimeException("User not found for id: " + userId);
        }
    }


}
