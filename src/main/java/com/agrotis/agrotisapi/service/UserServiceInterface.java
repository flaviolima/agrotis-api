package com.agrotis.agrotisapi.service;

import java.util.List;

import com.agrotis.agrotisapi.entity.User;
import com.agrotis.agrotisapi.exceptions.ResourceNotFound;
import com.agrotis.agrotisapi.requests.UserRequest;

public interface UserServiceInterface {
	public User create(UserRequest request) throws ResourceNotFound;
	
	public User update(Long id, UserRequest request) throws ResourceNotFound;
	
	public List<User> findAll();
	
	public User findById(Long id) throws ResourceNotFound;

	public void delete(Long id) throws ResourceNotFound;
}
