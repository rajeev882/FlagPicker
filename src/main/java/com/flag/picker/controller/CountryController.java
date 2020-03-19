package com.flag.picker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flag.picker.domain.CountryDomain;
import com.flag.picker.service.CountryService;

/**
 * <h1>FlagPickerApplication !</h1> 
 * The CountryController is Rest API for countries search.
 *
 * @author Rajeev kumar
 * @version 1.0
 * @since 2020-03-19
 */

@RestController
@RequestMapping(value = "/countries")
public class CountryController {
	
	@Autowired
	CountryService countryService;
	
	@GetMapping("/countries")
	public List<CountryDomain> countries(@RequestParam("name") String continentName) {
		return countryService.countries(continentName);
	}
	
	@GetMapping("/country/flag")
	public String flag(@RequestParam("name") String countryName) {
		return countryService.getFlag(countryName);
	}
}
