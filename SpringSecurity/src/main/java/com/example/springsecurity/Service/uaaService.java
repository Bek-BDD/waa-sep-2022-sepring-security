package com.example.springsecurity.Service;

import com.example.springsecurity.Model.AppUser;
import com.example.springsecurity.Security.model.LoginRequest;
import com.example.springsecurity.Security.model.LoginResponse;
import com.example.springsecurity.Security.model.RefreshTokenRequest;

public interface uaaService {
    public LoginResponse login(LoginRequest loginRequest);
    public AppUser signup(AppUser appUser);
    public LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest );



}
