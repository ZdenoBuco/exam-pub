package com.example.exampub.repositories;

import com.example.exampub.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
}
