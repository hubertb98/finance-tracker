package com.monsave.monsaveapp.mapper;

import com.monsave.monsaveapp.domain.User;
import com.monsave.monsaveapp.domain.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public User toUser(final UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getUsername(),
                userDto.getPassword());
    }

    public UserDto toUserDto(final User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getUsername(),
                user.getPassword());
    }

    public List<User> toUserList(final List<UserDto> userDtoList) {
        return userDtoList.stream()
                .map(userDto -> new User(
                        userDto.getId(),
                        userDto.getName(),
                        userDto.getUsername(),
                        userDto.getPassword()))
                .collect(Collectors.toList());
    }

    public List<UserDto> toUserDtoList(final List<User> userList) {
        return userList.stream()
                .map(user -> new UserDto(user.getId(),
                        user.getName(),
                        user.getUsername(),
                        user.getPassword()))
                .collect(Collectors.toList());
    }
}
