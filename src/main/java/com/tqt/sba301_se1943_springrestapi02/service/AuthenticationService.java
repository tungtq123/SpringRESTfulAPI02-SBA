package com.sba301.service;

import com.sba301.dto.LoginRequestDTO;
import com.sba301.dto.RegisterUserDTO;
import com.sba301.dto.UserDTO;
import com.sba301.dto.UserDetailDTO;

import java.util.List;

public interface AuthenticationService {
    UserDTO signup(RegisterUserDTO registerUserDTO);
    UserDetailDTO authenticate(LoginRequestDTO loginUserDTO);
    List<UserDTO> getAllUsers();
}
