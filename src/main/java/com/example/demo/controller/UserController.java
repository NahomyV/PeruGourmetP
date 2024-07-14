package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.Service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{iduser}")
    public User getUserById(@PathVariable Long iduser) {
        return userService.getUserById(iduser);
    }

    @PutMapping("/{iduser}")
    public User updateUser(@PathVariable Long iduser, @RequestBody User userDetails) {
        return userService.updateUser(iduser, userDetails);
    }

    @DeleteMapping("/{iduser}")
    public void deleteUser(@PathVariable Long iduser) {
        userService.deleteUser(iduser);
    }

    @PostMapping("/login")
    public void loginUser(@RequestBody User user, HttpServletResponse response) throws IOException {
        User authenticatedUser = userService.authenticateUser(user.getEmail(), user.getPassword());
        System.out.println("si llega hasta acá");
        if (authenticatedUser != null) {
            response.sendRedirect("/index");
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid credentials");
        }
    }

}
