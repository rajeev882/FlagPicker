package com.flag.picker.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flag.picker.domain.ContinentsDomain;
import com.flag.picker.domain.CountryDomain;
import com.flag.picker.exception.FlagPickerException;
import com.flag.picker.service.ContinentService;
import com.flag.picker.service.CountryService;
/**
 * @author Rajeev kumar
 *
 */
@Service
public class CountryServiceImpl implements CountryService {
	@Autowired
	private ContinentService continentService;

	@Override
	public List<CountryDomain> countries(String continentName) {
		List<CountryDomain> resultCountry = new ArrayList<>();
	
		try {
			ContinentsDomain continents = continentService.getContinent(continentName);
			if(continents!=null)
			resultCountry = continents.getCountry();
		} catch (Exception e) {
			throw new FlagPickerException("Error occured while fetching countries for given continentName ", e);
		}
		
		return resultCountry;
	}

	@Override
	public String getFlag(String countryName) {
		String flagName = null;
		
		List<ContinentsDomain> continentList;
		try {
			continentList = continentService.getContinents();
		} catch (Exception e) {
			throw new FlagPickerException("Error occured while fetching flag for given countryName ", e);
		}
		
		for(ContinentsDomain continent : continentList) {
			for(CountryDomain country : continent.getCountry()) {
				if(country.getName().equalsIgnoreCase(countryName)) {
					flagName = country.getFlag();
					break;
				}
			}
		}
		return flagName; 
	}

}
