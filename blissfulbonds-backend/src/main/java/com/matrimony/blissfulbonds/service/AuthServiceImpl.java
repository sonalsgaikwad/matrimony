package com.matrimony.blissfulbonds.service;

import com.matrimony.blissfulbonds.entity.User;
import com.matrimony.blissfulbonds.payload.request.SignupRequest;
import com.matrimony.blissfulbonds.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public User registerUser(SignupRequest signupRequest) {
        return null;
    }

    @Override
    public Boolean checkDuplicate(String email) {
        if (userRepository.existsByEmail(email)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public String getUserNameByEmail(String email) {
        Optional<User> optionalUser = this.userRepository.findByEmail(email);
        return optionalUser.isPresent() ? optionalUser.get().getUsername(): null;
    }
}
