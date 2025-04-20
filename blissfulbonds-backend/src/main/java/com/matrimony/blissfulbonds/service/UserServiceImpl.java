package com.matrimony.blissfulbonds.service;

import com.matrimony.blissfulbonds.entity.User;
import com.matrimony.blissfulbonds.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService  {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUser() {
        return  this.userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return  this.userRepository.findById(id).get();
    }

    @Override
    public User saveUser(User user) {
        return  this.userRepository.saveAndFlush(user);
    }

    @Override
    public User updateUser(User user) {
        return  this.userRepository.saveAndFlush(user);
    }

    @Override
    public boolean deleteById(Long id) {
        this.userRepository.deleteById(id);
        return true;
    }
}
