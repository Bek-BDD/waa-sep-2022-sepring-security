package com.example.springsecurity.Service.Impl;

import com.example.springsecurity.Model.AppUser;
import com.example.springsecurity.Model.Course;
import com.example.springsecurity.Repository.AppUserRepo;
import com.example.springsecurity.Security.JwtHelper;
import com.example.springsecurity.Security.model.LoginRequest;
import com.example.springsecurity.Security.model.LoginResponse;
import com.example.springsecurity.Security.model.RefreshTokenRequest;
import com.example.springsecurity.Service.uaaService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Service
public class uaaServiceImpl implements uaaService {
    private AuthenticationManager authenticationManager;
    private HttpServletRequest httpServletRequest;
    private AppUserRepo appUserRepo;
    private JwtHelper jwtHelper;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
       try{
           authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));
       }catch (BadCredentialsException e){

           System.out.println(e.getMessage());
       }

       final String accessToken= jwtHelper.generateToken(loginRequest.getUsername());
       final String refreshToken = jwtHelper.generateRefreshToken(jwtHelper.getSubject(accessToken));

       return new LoginResponse(accessToken,refreshToken);
    }

    @Override
    public AppUser signup(AppUser appUser) {
        BCryptPasswordEncoder encrypted  = new BCryptPasswordEncoder();
        String encrypted_password=encrypted.encode(appUser.getPassword());
        appUser.setPassword(encrypted_password);
        return appUserRepo.save(appUser);
    }

    @Override
    public LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
            boolean isvalid = jwtHelper.validateToken(refreshTokenRequest.getRefreshToken());
            if(isvalid){
                String accessToken = jwtHelper.generateToken(refreshTokenRequest.getRefreshToken());
                return new LoginResponse(accessToken,refreshTokenRequest.getRefreshToken());
            }
           return new LoginResponse();
    }
}
