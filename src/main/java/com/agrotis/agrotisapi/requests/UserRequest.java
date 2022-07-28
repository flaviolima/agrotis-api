package com.agrotis.agrotisapi.requests;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import static com.agrotis.agrotisapi.messages.BeanValidatorMessages.REQUIRED_NAME;
import static com.agrotis.agrotisapi.messages.BeanValidatorMessages.REQUIRED_DATE;
import static com.agrotis.agrotisapi.messages.BeanValidatorMessages.REQUIRED_LAB;
import static com.agrotis.agrotisapi.messages.BeanValidatorMessages.REQUIRED_PROP;


public class UserRequest {

	@NotEmpty(message=REQUIRED_NAME)
	private String name;

	@NotEmpty(message=REQUIRED_DATE)
	private LocalDate startAt;

	@NotEmpty(message=REQUIRED_DATE)
	private LocalDate finishAt;
	
	private String notes;

	@NotEmpty(message=REQUIRED_LAB)
	private LaboratoryRequest laboratory;

	@NotEmpty(message=REQUIRED_PROP)
	private PropertyRequest property;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getStartAt() {
		return startAt;
	}

	public void setStartAt(LocalDate startAt) {
		this.startAt = startAt;
	}

	public LocalDate getFinishAt() {
		return finishAt;
	}

	public void setFinishAt(LocalDate finishAt) {
		this.finishAt = finishAt;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public LaboratoryRequest getLaboratory() {
		return laboratory;
	}

	public void setLaboratory(LaboratoryRequest laboratory) {
		this.laboratory = laboratory;
	}

	public PropertyRequest getProperty() {
		return property;
	}

	public void setProperty(PropertyRequest property) {
		this.property = property;
	}

}
