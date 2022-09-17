package com.example.springsecurity.Controller;

import com.example.springsecurity.Model.AppUser;
import com.example.springsecurity.Security.model.LoginRequest;
import com.example.springsecurity.Security.model.LoginResponse;
import com.example.springsecurity.Security.model.RefreshTokenRequest;
import com.example.springsecurity.Service.uaaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/uaa")
public class uaaController {
   private uaaService uaaService;

   public uaaController(uaaService uaaService){
       this.uaaService=uaaService;
   }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok().body(uaaService.login(loginRequest));
    }
    @PostMapping("/signup")
    public ResponseEntity<AppUser> signup(@RequestBody AppUser appUser){
        return ResponseEntity.ok().body(uaaService.signup(appUser));
    }

    @PostMapping("/refresh")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return uaaService.refreshToken(refreshTokenRequest);
    }



}
