package com.demo.sb.restdemo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.sb.restdemo.beans.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
