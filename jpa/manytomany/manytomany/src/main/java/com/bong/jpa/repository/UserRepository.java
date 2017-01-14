package com.bong.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bong.jpa.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
