package com.SpringAuthentication.SpringAuthentication.service;

import com.SpringAuthentication.SpringAuthentication.entity.Role;
import com.SpringAuthentication.SpringAuthentication.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;

    public Role createNewRole(Role role){
        return roleRepo.save(role);
    }
}
