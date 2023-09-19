package com.SpringAuthentication.SpringAuthentication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppUser {

    @Id
    private String userName;
    private String userFirstName;
    private String userLastName;
    private String userPassword;

@ManyToMany(fetch= FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE",
            joinColumns = {
            @JoinColumn(name="USER_ID")
            },
            inverseJoinColumns = {
            @JoinColumn(name ="ROLE_ID")
            }
    )
    private Set<Role> role;

}
