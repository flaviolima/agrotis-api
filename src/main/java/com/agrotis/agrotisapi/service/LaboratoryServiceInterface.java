package com.agrotis.agrotisapi.service;

import java.util.List;

import com.agrotis.agrotisapi.entity.Laboratory;
import com.agrotis.agrotisapi.requests.LaboratoryRequest;

public interface LaboratoryServiceInterface {

	public List<Laboratory> findAll();

	public Laboratory create(LaboratoryRequest laboratoryRequest) throws Exception;

}
