package com.SpringAuthentication.SpringAuthentication.controller;


import com.SpringAuthentication.SpringAuthentication.entity.Role;
import com.SpringAuthentication.SpringAuthentication.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Api/v1/role")
@CrossOrigin
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping({"/create-new-role"})
    public Role createNewRole(@RequestBody Role role){
        return roleService.createNewRole(role);
    }


}
