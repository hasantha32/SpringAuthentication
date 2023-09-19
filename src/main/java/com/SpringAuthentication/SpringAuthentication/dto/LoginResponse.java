package com.SpringAuthentication.SpringAuthentication.dto;

import com.SpringAuthentication.SpringAuthentication.entity.AppUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginResponse {

    private AppUser appUser;
    private String jwtToken;
}
