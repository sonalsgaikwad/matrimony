package com.matrimony.blissfulbonds.controller;

import com.matrimony.blissfulbonds.entity.User;
import com.matrimony.blissfulbonds.payload.response.MessageResponse;
import com.matrimony.blissfulbonds.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="/api")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping(path="/user")
    public List<User> getUserList(){
        return this.userService.getAllUser();
    }
    @GetMapping(path="/user/{id}")
    public User getUserById(@PathVariable Long id){
        return this.userService.getUserById(id);
    }

    @PostMapping(path="/user")
    public User saveUser(@RequestBody User user){
        return this.userService.saveUser(user);
    }

    @PostMapping(path="/login")
    public boolean login(@RequestBody User user){
        return user.getUsername().equals("test89");
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser() {
        return ResponseEntity.ok()
                .body(new MessageResponse("You've been signed out!"));
    }
    @PutMapping(path="/user")
    public User updateUser(@RequestBody User user){
        return this.userService.updateUser(user);
    }

    @DeleteMapping(path="/user/{id}")
    public Boolean deleteUser(@PathVariable Long id){
        this.userService.deleteById(id);
        return true;
    }
}
