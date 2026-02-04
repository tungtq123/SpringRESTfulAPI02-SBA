//package com.sba301.config;
//
//import com.sba301.dto.UserDTO;
//import com.sba301.dto.UserDetailDTO;
//import com.sba301.repository.UserRepository;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//public class ApplicationConfiguration {
//    private final UserRepository userRepository;
//
//    public ApplicationConfiguration(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return username -> {
//            var user = userRepository.findByEmail(username);
//            if (user.isPresent()) {
//                UserDTO userDTO = new UserDTO(user.get().getUserId(), user.get().getUsername(), user.get().getPassword(), user.get().getEmail(), user.get().getRole().getId(), user.get().getRole().getName());
//                return new UserDetailDTO(userDTO);
//            } else {
//                throw new UsernameNotFoundException("User not found: " + username);
//            }
//        };
//    }
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
//    @Bean
//    public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(userDetailsService);
//       // authProvider.setUserDetailsService(userDetailsService);
//        authProvider.setPasswordEncoder(passwordEncoder);
//        return authProvider;
//    }
//}
