package com.matrimony.blissfulbonds.service;

import com.matrimony.blissfulbonds.entity.User;
import com.matrimony.blissfulbonds.payload.request.SignupRequest;

public interface AuthService {

    User registerUser(SignupRequest signupRequest);

    Boolean checkDuplicate(String email);

    String getUserNameByEmail(String email);

}
