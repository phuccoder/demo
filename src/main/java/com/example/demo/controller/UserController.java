package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


import com.example.demo.repository.UserRepository;
import com.example.demo.service.ResponseMessage;
import com.example.demo.service.User;
import com.example.demo.service.UserService;


@Controller
public class UserController {
    
    private final UserRepository userRepository;
    private final UserService userService;

    
    
    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/users")
    public String showUserManagementPage(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "usermanagement";
    }
    
    @PostMapping("/allUsers")
    @ResponseBody
    public ResponseEntity<?> createUser(@RequestBody User newUser) {
    try {
        userService.createUser(newUser.getUsername(), newUser.getPassword());
        return new ResponseEntity<>("User created", HttpStatus.CREATED);
    } catch (Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

    @GetMapping("/allUsers")
    @ResponseBody
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/allUsers/username/{username}")
    @ResponseBody
    public User getUserByUsername(@PathVariable String username) {
    return userRepository.findByUsername(username);
    }

    @GetMapping("/allUsers/{id}")
    @ResponseBody
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).get();
    }

    @DeleteMapping("/allUsers/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
    try {
        userService.deleteUser(id);
        return new ResponseEntity<>("User with ID:" + id + " deleted", HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>("Failed to delete user with ID:" + id, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
    
    
    @PutMapping("/allUsers/{id}")
    @ResponseBody
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
    try {
        User user = userService.updateUser(id, updatedUser);
        return new ResponseEntity<>(user, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


    
}
