package com.example.exampub.controllres;

import com.example.exampub.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("")
    public ResponseEntity<?> findAllUsers() {
        try {
            return ResponseEntity.ok().body(userService.findAllUsers());
        } catch (Exception exception) {
            return ResponseEntity.status(404).body(exception.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findUserById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(userService.findUserByID(id));
        } catch (Exception exception) {
            return ResponseEntity.status(404).body(exception.getMessage());
        }
    }
}
