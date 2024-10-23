package com.example.l2velhaguarda.controllers;

import com.example.l2velhaguarda.dtos.UserRegistrationDTO;
import com.example.l2velhaguarda.dtos.UserDTO;
import com.example.l2velhaguarda.services.UserService;
import com.example.l2velhaguarda.mappers.UserMapper;
import com.example.l2velhaguarda.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserRegistrationDTO registrationDTO) {
        var user = userMapper.toEntity(registrationDTO);
        var savedUser = userService.registerUser(user);
        var userDTO = userMapper.toDTO(savedUser);
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody UserRegistrationDTO loginDTO) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginDTO.getUsername(),
                loginDTO.getPassword()
            )
        );
        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(jwt);
    }
}
