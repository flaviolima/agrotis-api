package com.agrotis.agrotisapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.agrotis.agrotisapi.entity.Laboratory;
import com.agrotis.agrotisapi.requests.LaboratoryRequest;
import com.agrotis.agrotisapi.service.LaboratoryService;

@RestController
public class LaboratoryController {
	
	@Autowired
	private LaboratoryService laboratoryService;

	@PostMapping("/laboratories")
	public ResponseEntity<Laboratory> create(@RequestBody LaboratoryRequest laboratory) throws Exception {
	    return ResponseEntity.status(HttpStatus.OK).body(laboratoryService.create(laboratory));
	}

	@GetMapping("/laboratories")
	public ResponseEntity<List<Laboratory>> findAll() {
	    return ResponseEntity.status(HttpStatus.OK).body(laboratoryService.findAll());
	}
}
