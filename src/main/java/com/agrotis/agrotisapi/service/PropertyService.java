package com.agrotis.agrotisapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.agrotis.agrotisapi.entity.Property;
import com.agrotis.agrotisapi.repository.PropertyRepository;
import com.agrotis.agrotisapi.requests.PropertyRequest;

public class PropertyService implements PropertyServiceInterface {

	@Autowired
	private PropertyRepository propertyRepository;
	
	@Override
	public Property create(PropertyRequest propertyRequest) throws Exception {
		Property prop = new Property();
		prop.setName(propertyRequest.getName());
		prop.setDocument(propertyRequest.getDocument());
		return propertyRepository.save(prop);
	}
	
	@Override
	public List<Property> findAll() {
		List<Property> props = propertyRepository.findAll();
		return props;
	}

}
