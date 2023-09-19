package com.SpringAuthentication.SpringAuthentication.repo;

import com.SpringAuthentication.SpringAuthentication.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository<AppUser,String> {

}
