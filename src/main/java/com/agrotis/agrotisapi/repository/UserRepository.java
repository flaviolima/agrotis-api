package com.agrotis.agrotisapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agrotis.agrotisapi.entity.User;


public interface UserRepository extends JpaRepository <User, Long> {
	
}