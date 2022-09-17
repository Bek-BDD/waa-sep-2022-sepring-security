package com.example.springsecurity.Security.model;

import com.example.springsecurity.Model.AppUser;
import com.example.springsecurity.Repository.AppUserRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@Service("UserDetailsService")
public class AppUserDetailService implements UserDetailsService {
    private AppUserRepo appUserRepo;
    public AppUserDetailService(AppUserRepo appUserRepo){
        this.appUserRepo=appUserRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       AppUser user= appUserRepo.findAppUserByUsername(username);
        UserDetails userDetail= new AppUserDetail(user);
        return userDetail;
    }
}
