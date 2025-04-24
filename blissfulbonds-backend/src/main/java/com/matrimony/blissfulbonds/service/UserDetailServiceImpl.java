package com.matrimony.blissfulbonds.service;

import com.matrimony.blissfulbonds.entity.User;
import com.matrimony.blissfulbonds.repository.UserRepository;
import com.matrimony.blissfulbonds.security.UserDetailsImpl;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =userRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found with username "+username));
        return UserDetailsImpl.build(user);
    }
}
