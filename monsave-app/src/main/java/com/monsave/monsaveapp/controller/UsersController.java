package com.monsave.monsaveapp.controller;

import com.monsave.monsaveapp.controller.exception.UserNotFoundException;
import com.monsave.monsaveapp.domain.dto.UserDto;
import com.monsave.monsaveapp.mapper.UserMapper;
import com.monsave.monsaveapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class UsersController {
    @Autowired
    private UserMapper mapper;
    @Autowired
    private UserService service;

    @GetMapping(value = "/users")
    public List<UserDto> getUsers() {
        return mapper.toUserDtoList(service.getAllUsers());
    }

    @GetMapping(value = "/users/{userId}")
    public UserDto getUser(@PathVariable("userId") long userId) throws UserNotFoundException {
        return mapper.toUserDto(service.getUser(userId).orElseThrow(UserNotFoundException::new));
    }

    @PostMapping(value = "/users")
    public void createUser(@RequestBody UserDto userDto) {
        service.saveUser(mapper.toUser(userDto));
    }

    @PutMapping(value = "/users")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return mapper.toUserDto(service.saveUser(mapper.toUser(userDto)));
    }

    @DeleteMapping(value = "/users/{userId}")
    public void deleteUser(@PathVariable("userId") long userId) {
        service.deleteUser(userId);
    }
}
