package com.spring.starter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.starter.models.User;

public interface UserRepository extends JpaRepository<User, String> {

}
