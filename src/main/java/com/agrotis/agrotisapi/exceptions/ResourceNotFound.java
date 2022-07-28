package com.agrotis.agrotisapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFound extends Exception{

	private static final long serialVersionUID = 122222L;

	public ResourceNotFound(String desc){
		super(desc);
	}
	
}