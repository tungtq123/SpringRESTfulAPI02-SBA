package com.tqt.sba301_se1943_springrestapi02.controller;//package com.sba301.controller;
//
//import com.sba301.config.JwtTokenProvider;
//import com.sba301.dto.LoginRequestDTO;
//import com.sba301.dto.LoginResponse;
//import com.sba301.dto.RegisterUserDTO;
//import com.sba301.dto.UserDTO;
//import com.sba301.dto.UserDetailDTO;
//import com.sba301.service.AuthenticationService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthenticationController {
//    private final AuthenticationService authenticationService;
//    private final JwtTokenProvider jwtTokenProvider;
//    public AuthenticationController(AuthenticationService authenticationService,
//                                     JwtTokenProvider jwtTokenProvider) {
//        this.authenticationService = authenticationService;
//        this.jwtTokenProvider = jwtTokenProvider;
//    }
//    @PostMapping("/signup")
//    public ResponseEntity<UserDTO> register(@RequestBody RegisterUserDTO userDTO) {
//        System.out.println("Register user: " + userDTO.getEmail());
//        return ResponseEntity.ok(authenticationService.signup(userDTO));
//
//    }
//    @PostMapping("/login")
//    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequestDTO userDTO) {
//        UserDetailDTO userPrincipal =  authenticationService.authenticate(userDTO);
//        String token = jwtTokenProvider.generateToken(userPrincipal);
//        return ResponseEntity.ok(new LoginResponse(token, jwtTokenProvider.getJwtExpiration()));
//    }
//}
