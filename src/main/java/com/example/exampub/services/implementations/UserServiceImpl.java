package com.example.exampub.services.implementations;

import com.example.exampub.DTOs.UserDTO;
import com.example.exampub.models.User;
import com.example.exampub.repositories.UserRepo;
import com.example.exampub.services.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public Iterable<UserDTO> findAllUsers() {
        List<UserDTO> userDTOList = new ArrayList<>();
        userRepo.findAll().forEach(user -> userDTOList.add(new UserDTO(user)));
        return userDTOList;
    }

    @Override
    public User findUserByID(Long id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new RuntimeException("User not found");
        }
    }
}
