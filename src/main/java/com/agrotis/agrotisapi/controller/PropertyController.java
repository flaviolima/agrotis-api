package com.agrotis.agrotisapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.agrotis.agrotisapi.entity.Property;
import com.agrotis.agrotisapi.requests.PropertyRequest;
import com.agrotis.agrotisapi.service.PropertyService;

public class PropertyController {

	@Autowired
	private PropertyService propertyService;


	@PostMapping("/properties")
	public ResponseEntity<Property> create(@RequestBody PropertyRequest property) throws Exception {
	    return ResponseEntity.status(HttpStatus.OK).body(propertyService.create(property));
	}

	@GetMapping("/properties")
	public ResponseEntity<List<Property>> findAll() {
	    return ResponseEntity.status(HttpStatus.OK).body(propertyService.findAll());
	}
}
