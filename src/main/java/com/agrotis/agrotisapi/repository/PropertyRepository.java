package com.agrotis.agrotisapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agrotis.agrotisapi.entity.Property;

public interface PropertyRepository extends JpaRepository<Property, Long> {

}
