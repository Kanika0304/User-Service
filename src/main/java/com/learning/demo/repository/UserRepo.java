package com.learning.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.demo.entity.User;

public interface UserRepo extends JpaRepository<User,Long> {

}
