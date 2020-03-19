package com.flag.picker.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flag.picker.entity.Continent;

public interface ContinentRepository  extends JpaRepository<Continent, Long>{

	List<Continent> findByContinent(String continent); 
	
}