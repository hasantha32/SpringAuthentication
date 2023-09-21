package com.SpringAuthentication.SpringAuthentication.service;


import com.SpringAuthentication.SpringAuthentication.entity.AppUser;
import com.SpringAuthentication.SpringAuthentication.entity.Role;
import com.SpringAuthentication.SpringAuthentication.repo.RoleRepo;
import com.SpringAuthentication.SpringAuthentication.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service

public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AppUser registerNewUser(AppUser appUser){

        return userRepo.save(appUser);
    }

    public void initRoleAndUser(){
        Role adminRole =new Role();
        Role userRole =new Role();

        if(!roleRepo.existsById("Admin")){

            adminRole.setRoleName("Admin");
            adminRole.setRoleDescription("Admin Role");
            roleRepo.save(adminRole);
        }
        if(!roleRepo.existsById("User")){

            userRole.setRoleName("User");
            userRole.setRoleDescription("User Role");
            roleRepo.save(userRole);

        }



        if (!userRepo.existsById("admin123")){
            AppUser appUser =new AppUser();
            appUser.setUserName("admin123");
//            appUser.setUserPassword(passwordEncoder.encode("admin@123"));
            appUser.setUserPassword(getEncodedPassword("admin@123"));

            appUser.setUserFirstName("Hasantha");
            appUser.setUserLastName("Madhushan");

            Set<Role> adminRoles=new HashSet<>();
            adminRoles.add(adminRole);

            appUser.setRole(adminRoles);
            userRepo.save(appUser);
        }
        if (!userRepo.existsById("user123")){
            AppUser appUser =new AppUser();
            appUser.setUserName("user123");
            appUser.setUserPassword(getEncodedPassword("user@123"));
            appUser.setUserFirstName("Has");
            appUser.setUserLastName("Madhu");

            Set<Role> userRoles=new HashSet<>();
            userRoles.add(userRole);

            appUser.setRole(userRoles);
            userRepo.save(appUser);
        }

    }
    public String getEncodedPassword(String password){
        return  passwordEncoder.encode(password);
    }
}
