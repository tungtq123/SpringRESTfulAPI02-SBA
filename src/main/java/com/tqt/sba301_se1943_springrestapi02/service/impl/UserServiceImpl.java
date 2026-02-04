package com.tqt.sba301_se1943_springrestapi02.service.impl;

import com.tqt.sba301_se1943_springrestapi02.dto.UserDTO;
import com.tqt.sba301_se1943_springrestapi02.entity.User;
import com.tqt.sba301_se1943_springrestapi02.repository.UserRepository;
import com.tqt.sba301_se1943_springrestapi02.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO getUser(String username) {
        return null;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO updateUser(String username, UserDTO userDTO) {
        return null;
    }

    @Override
    public int deleteUser(String username) {
        return 0;
    }

    @Override
    public UserDTO login(String username, String password) {
        return null;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            return List.of();
        }
        return users.stream().map(user -> new UserDTO(
                user.getUserId(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getRole().getId(),
                user.getRole().getName()
        )).toList();
    }
}
