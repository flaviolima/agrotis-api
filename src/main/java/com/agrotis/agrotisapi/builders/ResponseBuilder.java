package com.agrotis.agrotisapi.builders;

import java.util.ArrayList;
import java.util.List;

import com.agrotis.agrotisapi.entity.Laboratory;
import com.agrotis.agrotisapi.entity.Property;
import com.agrotis.agrotisapi.entity.User;
import com.agrotis.agrotisapi.responses.LaboratoryResponse;
import com.agrotis.agrotisapi.responses.PropertyResponse;
import com.agrotis.agrotisapi.responses.UserResponse;

public class ResponseBuilder {

	public static List<UserResponse> build(List<User> users) {
		
		List<UserResponse> list = new ArrayList<>();
		if(users.isEmpty() || users == null) return list;
		
		users.forEach(u -> {
			list.add(build(u));
		});
		
		return list;
		
	}
	
	public static UserResponse build(User user) {
		
		UserResponse response = new UserResponse();
		response.setId(user.getId());
		response.setName(user.getName());
		response.setNotes(user.getNotes());
		response.setStartAt(user.getStartAt());
		response.setFinishAt(user.getFinishAt());
		response.setProperty(build(user.getProperty()));
		response.setLaboratory(build(user.getLaboratory()));
		return response;
	
	}
	
	public static PropertyResponse build(Property entity) {
		
		PropertyResponse response = new PropertyResponse();
		response.setId(entity.getId());
		response.setName(entity.getName());
		response.setDocument(entity.getDocument());
		return response;
		
	}
	
	public static LaboratoryResponse build(Laboratory entity) {
		
		LaboratoryResponse response = new LaboratoryResponse();
		response.setId(entity.getId());
		response.setName(entity.getName());
		return response;
		
	}

}
