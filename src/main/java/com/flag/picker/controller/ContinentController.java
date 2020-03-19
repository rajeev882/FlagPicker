package com.flag.picker.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flag.picker.domain.ContinentsDomain;
import com.flag.picker.service.ContinentService;
/**
 * <h1>FlagPickerApplication !</h1> 
 * The ContinentController is Rest API for continents search.
 *
 * @author Rajeev kumar
 * @version 1.0
 * @since 2020-03-19
 */
@RestController
@RequestMapping(value = "/continents")
public class ContinentController {

	@Autowired
	private ContinentService continentService;

	@GetMapping
	public ResponseEntity<List<ContinentsDomain>> getContinents(@RequestParam(value = "continentName", required = false) String continentName) {

		List<ContinentsDomain> result = new ArrayList<>();
		if (continentName == null) {
			result = continentService.getContinents();
		} else {
			ContinentsDomain continent = continentService.getContinent(continentName);
			result.add(continent);
		}
		return new ResponseEntity<List<ContinentsDomain>>(result, HttpStatus.OK);

	}

}
