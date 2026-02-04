//package com.sba301.service.impl;
//
//import com.sba301.dto.LoginRequestDTO;
//import com.sba301.dto.RegisterUserDTO;
//import com.sba301.dto.UserDTO;
//import com.sba301.entity.User;
//import com.sba301.dto.UserDetailDTO;
//import com.sba301.repository.UserRepository;
//import com.sba301.service.AuthenticationService;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//@Service
//public class AuthenticationServiceImpl implements AuthenticationService {
//    private final AuthenticationManager authenticationManager;
//    private final PasswordEncoder passwordEncoder;
//    private final UserRepository userRepository;
//    public AuthenticationServiceImpl(AuthenticationManager authenticationManager,
//                                      PasswordEncoder passwordEncoder,
//                                      UserRepository userRepository) {
//        this.authenticationManager = authenticationManager;
//        this.passwordEncoder = passwordEncoder;
//        this.userRepository = userRepository;
//    }
//    @Override
//    public UserDTO signup(RegisterUserDTO registerUserDTO) {
//        User user = new User();
//        user.setUsername(registerUserDTO.getFullName());
//        user.setEmail(registerUserDTO.getEmail());
//        user.setPassword(passwordEncoder.encode(registerUserDTO.getPassword()));
//        user.setRole(new com.sba301.entity.Role(1, "USER"));
//        User user1 = userRepository.save(user);
//        return new UserDTO(user1.getUserId(), user1.getUsername(), user1.getPassword(), user1.getEmail(), user1.getRole().getId(), user1.getRole().getName());
//
//    }
//
//    @Override
//    public UserDetailDTO authenticate(LoginRequestDTO loginUserDTO) {
//        System.out.println("User authenticated + email: " + loginUserDTO.getEmail() + " password: " + loginUserDTO.getPassword() + "");
//        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUserDTO.getEmail(), loginUserDTO.getPassword()));
//        System.out.println("User authenticated + email: " + loginUserDTO.getEmail() + " password: " + loginUserDTO.getPassword() + "");
//        User user = userRepository.findByEmail(loginUserDTO.getEmail()).orElseThrow();
//        if (user == null) {
//            System.out.println("User not found");
//        } else {
//            System.out.println("User found :" + user.getUsername());
//        }
//        UserDTO userDTO = new UserDTO(user.getUserId(), user.getUsername(), user.getPassword(), user.getEmail(), user.getRole().getId(), user.getRole().getName());
//        return new UserDetailDTO(userDTO);
//    }
//
//    @Override
//    public List<UserDTO> getAllUsers() {
//        List<User> users = userRepository.findAll();
//        if (users.isEmpty()) {
//            return List.of();
//        }
//        return users.stream().map(user -> new UserDTO(
//                user.getUserId(),
//                user.getUsername(),
//                user.getPassword(),
//                user.getEmail(),
//                user.getRole().getId(),
//                user.getRole().getName()
//                )).toList();
//    }
//}
