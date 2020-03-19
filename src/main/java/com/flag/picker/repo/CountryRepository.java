package com.flag.picker.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flag.picker.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

	List<Country> findByContinent(String continent);

	List<Country> findByName(String country);

}
