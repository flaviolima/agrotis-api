package com.agrotis.agrotisapi.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User implements Serializable {

	private static final long serialVersionUID = -1152958112328153708L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column
	private String name;

	@Column
	private LocalDate startAt;

	@Column
	private LocalDate finishAt;

	@Column
	private String notes;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "laboratory_id")
	private Laboratory laboratory;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "property_id")
	private Property property;

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

	public Laboratory getLaboratory() {
		return laboratory;
	}

	public void setLaboratory(Laboratory laboratory) {
		this.laboratory = laboratory;
	}
	
	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

}