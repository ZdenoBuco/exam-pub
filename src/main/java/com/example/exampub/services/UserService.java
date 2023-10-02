package com.example.exampub.services;

import com.example.exampub.DTOs.UserDTO;
import com.example.exampub.DTOs.UserResponseDTO;
import com.example.exampub.models.User;

public interface UserService {
    Iterable<UserDTO> findAllUsers();
    UserResponseDTO findUserByID(Long id);
}
