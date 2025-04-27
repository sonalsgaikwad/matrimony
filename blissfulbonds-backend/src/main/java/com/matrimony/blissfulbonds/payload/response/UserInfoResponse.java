package com.matrimony.blissfulbonds.payload.response;

import java.util.List;

public class UserInfoResponse {
    private Long userId;
    private String username;
    private String authToken;
    private List<String> roles;

    public UserInfoResponse(Long userId, String username, String authToken, List<String> roles) {
        this.userId = userId;
        this.username = username;
        this.authToken = authToken;
        this.roles = roles;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
