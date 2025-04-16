package com.codebase.edic.mapper;

import com.codebase.edic.dto.UserDto;
import com.codebase.edic.entity.User;

public class UserMapper {

    public static UserDto mapToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getUid(),
                user.getName(),
                user.getEmail(),
                user.getPassword());
    }

    public static User mapToUser(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getUid(),
                userDto.getName(),
                userDto.getEmail(),
                userDto.getPassword());
    }
}
