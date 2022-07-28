package com.agrotis.agrotisapi.service;

import java.util.List;

import com.agrotis.agrotisapi.entity.Property;
import com.agrotis.agrotisapi.requests.PropertyRequest;

public interface PropertyServiceInterface {

	public Property create(PropertyRequest propertyRequest) throws Exception;

	public List<Property> findAll();

}
