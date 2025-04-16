package com.codebase.edic.service;

import com.codebase.edic.dto.UserDto;
import com.codebase.edic.entity.User;

public interface UserService {
    UserDto createUser(UserDto userDto);

    User findByEmail(String email); // New method
}