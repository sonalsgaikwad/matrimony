package com.matrimony.blissfulbonds.controller;

import com.matrimony.blissfulbonds.entity.User;
import com.matrimony.blissfulbonds.payload.request.LoginRequest;
import com.matrimony.blissfulbonds.payload.request.SignupRequest;
import com.matrimony.blissfulbonds.payload.response.MessageResponse;
import com.matrimony.blissfulbonds.payload.response.UserInfoResponse;
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

@CrossOrigin(origins=" http://localhost:4200/",maxAge=3600)
@RestController
@RequestMapping("api/auth")
public class AuthController {

    private AuthService authService;
    private AuthenticationManager authenticationManager;

    public AuthController(AuthService authService, AuthenticationManager authenticationManager) {
        this.authService = authService;
        this.authenticationManager = authenticationManager;
    }


    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        if(Objects.nonNull(loginRequest.getUsername()) && loginRequest.getUsername().contains("@")) {
            loginRequest.setUsername(authService.getUserNameByEmail(loginRequest.getUsername()));
        }
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();


        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok()
                .body(new UserInfoResponse(
                        userDetails.getId(),
                        userDetails.getUsername(),
                        JwtHelper.generateToken(userDetails.getUsername()),
                        roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<MessageResponse> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        User user = authService.registerUser(signUpRequest);
        return ResponseEntity.ok(new MessageResponse(user.getUsername()));
    }

    @PostMapping("/signup/email/{email}")
    public ResponseEntity<Boolean> validateEmail(@PathVariable String email) {
        Boolean isDuplicate = authService.checkDuplicate(email);
        return ResponseEntity.ok().body(isDuplicate);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser() {
        return ResponseEntity.ok()
                .body(new MessageResponse("You've been signed out!"));
    }

}
