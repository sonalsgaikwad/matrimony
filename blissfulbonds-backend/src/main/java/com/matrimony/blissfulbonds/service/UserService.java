package com.matrimony.blissfulbonds.service;

import com.matrimony.blissfulbonds.entity.User;

import java.util.List;

public interface UserService {
   List<User> getAllUser();
   public User getUserById(Long id);

   public User saveUser(User user);

   public User updateUser(User user);

   public boolean deleteById(Long id);
}
