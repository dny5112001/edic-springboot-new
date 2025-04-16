package com.codebase.edic.service.Impl;

import com.codebase.edic.dto.UserDto;
import com.codebase.edic.entity.User;
import com.codebase.edic.mapper.UserMapper;
import com.codebase.edic.repository.UserRepository;
import com.codebase.edic.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}