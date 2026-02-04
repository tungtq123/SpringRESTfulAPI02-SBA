package com.sba301.service;

import com.sba301.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO getUser(String username);
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(String username, UserDTO userDTO);
    int deleteUser(String username);
    UserDTO login(String username, String password);
    List<UserDTO> getAllUsers();
}
