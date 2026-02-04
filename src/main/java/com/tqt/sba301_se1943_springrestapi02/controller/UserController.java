package com.sba301.controller;

import com.sba301.dto.UserDTO;
import com.sba301.dto.UserDetailDTO;
import com.sba301.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User API", description = "User API")
public class UserController {
    // Implement User Controller here
    // ...
    @Autowired
    private UserService userService;
    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/me")
    public ResponseEntity<UserDetailDTO> getAuthenticatedUser(@AuthenticationPrincipal UserDetails userDetails) {
        UserDetailDTO userPrincipal = (UserDetailDTO) userDetails;
        return ResponseEntity.ok(userPrincipal);
    }
    @GetMapping("/{username}")
    public UserDTO getUser(@PathVariable String username) {
        return userService.getUser(username);
    }
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok().body(userService.createUser(userDTO));
    }
    @GetMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestParam String username, @RequestParam String password) {
        return  ResponseEntity.ok().body(userService.login(username, password));
    }
}
