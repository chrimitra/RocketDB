package com.f2.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.f2.models.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
