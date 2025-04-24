package com.matrimony.blissfulbonds.controller;

import com.matrimony.blissfulbonds.entity.User;
import com.matrimony.blissfulbonds.payload.request.LoginRequest;
import com.matrimony.blissfulbonds.payload.request.SignupRequest;
import com.matrimony.blissfulbonds.payload.response.MessageResponse;
import com.matrimony.blissfulbonds.security.JwtHelper;
import com.matrimony.blissfulbonds.security.UserDetailsImpl;
import com.matrimony.blissfulbonds.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@CrossOrigin(origins="*" ,maxAge=3600)
@RestController
@RequestMapping("api/auth")
public class AuthController {

    private AuthService authService;
    private AuthenticationManager authenticationManager;

    public AuthController(AuthService authService, AuthenticationManager authenticationManager) {
        this.authService = authService;
        this.authenticationManager = authenticationManager;
    }



}
