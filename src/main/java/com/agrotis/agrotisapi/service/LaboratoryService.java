package com.agrotis.agrotisapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agrotis.agrotisapi.entity.Laboratory;
import com.agrotis.agrotisapi.repository.LaboratoryRepository;
import com.agrotis.agrotisapi.requests.LaboratoryRequest;

@Service
public class LaboratoryService implements LaboratoryServiceInterface {
	
	@Autowired
	private LaboratoryRepository laboratoryRepository;
	
	@Override
	public Laboratory create(LaboratoryRequest laboratoryRequest) throws Exception {
		Laboratory lab = new Laboratory();
		lab.setName(laboratoryRequest.getName());
		return laboratoryRepository.save(lab);
	}
	
	@Override
	public List<Laboratory> findAll() {
		List<Laboratory> labs = laboratoryRepository.findAll();
		return labs;
	}

}
