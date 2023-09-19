package com.SpringAuthentication.SpringAuthentication.controller;

import com.SpringAuthentication.SpringAuthentication.dto.LoginRequest;
import com.SpringAuthentication.SpringAuthentication.dto.LoginResponse;
import com.SpringAuthentication.SpringAuthentication.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private JwtService jwtService;

    //authentication == login
    @PostMapping({"/authentication"})
    public LoginResponse createJwtTokenAndLogin(@RequestBody LoginRequest loginRequest) throws Exception{
    return jwtService.createJwtToken(loginRequest);

    }
}
