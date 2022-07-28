package com.agrotis.agrotisapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agrotis.agrotisapi.entity.Laboratory;

public interface LaboratoryRepository extends JpaRepository<Laboratory, Long> {
	
}
