/**
 * 
 */
package com.flag.picker.service;

import java.util.List;

import com.flag.picker.domain.CountryDomain;

/**
 * @author Rajeev kumar
 *
 */
public interface CountryService {

	/**
	 * This API is used to get the list of CountryDomain by continentName
	 * 
	 * @param continentName
	 * @return List<CountryDomain>
	 */
	public List<CountryDomain> countries(String continentName);

	/**
	 * This API is used to get flag for a given country.
	 * 
	 * @param countryName
	 * @return
	 */
	public String getFlag(String countryName);

}
