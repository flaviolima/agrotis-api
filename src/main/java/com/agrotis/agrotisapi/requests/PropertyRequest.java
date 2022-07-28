package com.agrotis.agrotisapi.requests;

import static com.agrotis.agrotisapi.messages.BeanValidatorMessages.REQUIRED_NAME;
import static com.agrotis.agrotisapi.messages.BeanValidatorMessages.REQUIRED_ID;
import static com.agrotis.agrotisapi.messages.BeanValidatorMessages.REQUIRED_DOCUMENT;
import static com.agrotis.agrotisapi.messages.BeanValidatorMessages.INVALID_CNPJ;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CNPJ;

public class PropertyRequest {
	
	@NotEmpty(message=REQUIRED_ID)
	private Long id;
	
	@NotEmpty(message=REQUIRED_NAME)
	private String name;
	
	@NotEmpty(message=REQUIRED_DOCUMENT)
	@CNPJ(message=INVALID_CNPJ)
	private Long document;

	public Long getDocument() {
		return document;
	}

	public void setDocument(Long document) {
		this.document = document;
	}

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
