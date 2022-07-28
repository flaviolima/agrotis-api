package com.agrotis.agrotisapi.responses;

import java.time.LocalDate;

public class UserResponse {
	
	private Long id;

	private String name;

	private LocalDate startAt;

	private LocalDate finishAt;

	private String notes;
	
	private PropertyResponse property;
	
	private LaboratoryResponse laboratory;

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
	
	public PropertyResponse getProperty() {
		return property;
	}

	public void setProperty(PropertyResponse property) {
		this.property = property;
	}

	public LaboratoryResponse getLaboratory() {
		return laboratory;
	}

	public void setLaboratory(LaboratoryResponse laboratory) {
		this.laboratory = laboratory;
	}
	
	
}
