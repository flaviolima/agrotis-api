package com.agrotis.agrotisapi.requests;

import static com.agrotis.agrotisapi.messages.BeanValidatorMessages.REQUIRED_ID;
import static com.agrotis.agrotisapi.messages.BeanValidatorMessages.REQUIRED_NAME;

import javax.validation.constraints.NotEmpty;

public class LaboratoryRequest {
	
	@NotEmpty(message=REQUIRED_ID)
	private Long id;
	
	@NotEmpty(message=REQUIRED_NAME)
	private String name;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
