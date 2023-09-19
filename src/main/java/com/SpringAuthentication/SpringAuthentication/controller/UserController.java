package com.SpringAuthentication.SpringAuthentication.controller;

import com.SpringAuthentication.SpringAuthentication.entity.AppUser;
import com.SpringAuthentication.SpringAuthentication.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("Register-new-user")
    public AppUser registerNewUser(@RequestBody AppUser appUser){
      return  userService.registerNewUser(appUser);

    }
    @PostConstruct
    public void initRoleAndUser(){
        userService.initRoleAndUser();
    }

    @GetMapping("/for-admin")
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin(){
        return "This is only accessible to admin";
    }

    @GetMapping("/for-user")
    @PreAuthorize("hasAnyRole('User','Admin')")

    public String forUser(){
        return "This is only accessible to user";
    }
}
