package com.ftgrl.libraryProject.service;

import com.ftgrl.libraryProject.dto.UserDto;
import com.ftgrl.libraryProject.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(UserDto userDto);
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    void deleteUser(Long id);
}
