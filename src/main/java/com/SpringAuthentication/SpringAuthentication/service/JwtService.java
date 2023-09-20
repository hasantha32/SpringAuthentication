package com.SpringAuthentication.SpringAuthentication.service;

import com.SpringAuthentication.SpringAuthentication.dto.LoginRequest;
import com.SpringAuthentication.SpringAuthentication.dto.LoginResponse;
import com.SpringAuthentication.SpringAuthentication.entity.AppUser;
import com.SpringAuthentication.SpringAuthentication.repo.UserRepo;
import com.SpringAuthentication.SpringAuthentication.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class JwtService implements UserDetailsService  {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser =userRepo.findById(username).get();

        if (appUser != null){
            return new User(
                    appUser.getUserName(),
                    appUser.getUserPassword(),
                    getAuthority(appUser)
            );
        }else {
            throw new UsernameNotFoundException("User not found with username: " +username);
        }


    }
    private Set getAuthority(AppUser appUser){
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();

//        for(Role role : appUser.getRole()){
//            authorities.add(new SimpleGrantedAuthority("ROLE_"+ role.getRoleName()));
//        }

        appUser.getRole().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" +role.getRoleName()));
        });
        return authorities;
    }

    public LoginResponse createJwtToken(LoginRequest loginRequest) throws Exception{
    String username =loginRequest.getUsername();
    String userPassword =loginRequest.getUserPassword();

    authenticate(username,userPassword);

    UserDetails userDetails = loadUserByUsername(username);

    String newGeneratedToken =jwtUtil.generateToken(userDetails);

    AppUser appUser=userRepo.findById(username).get();

    LoginResponse loginResponse =new LoginResponse(
            appUser,
            newGeneratedToken
    );
    return loginResponse;
    }


    private void authenticate(String userName, String userPassword) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName,userPassword));

        }catch (BadCredentialsException e){
            throw new Exception("INVALID_CREDENTIALS",e);
        }
    }
}

















