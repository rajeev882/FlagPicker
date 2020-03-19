/**
 * 
 */
package com.flag.picker.cache.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.flag.picker.cache.FlagPickerCache;
import com.flag.picker.domain.ContinentsDomain;
import com.flag.picker.domain.CountryDomain;
import com.flag.picker.entity.Continent;
import com.flag.picker.entity.Country;
import com.flag.picker.repo.ContinentRepository;

/**
* <h1>FlagPickerApplication !</h1>
* The FlagPickerCacheIDemoimpl is Spring Data JPA Based implementation of FlagPickerCache.
*
* @author  Rajeev kumar
* @version 1.0
* @since   2020-03-19 
*/
@Component
@Profile("flagPickerCacheiJpa")
public class FlagPickerCacheIJpaimpl implements FlagPickerCache {
	
	Logger LOG = LoggerFactory.getLogger(FlagPickerCacheIJpaimpl.class);

	@Autowired
	private ContinentRepository continentRepository;

	public List<ContinentsDomain> listOfContinents = new ArrayList<ContinentsDomain>();

	@Override
	public List<ContinentsDomain> getContinents() {
		return listOfContinents;
	}

	private List<ContinentsDomain> convertDTO(List<Continent> continentAll) {
		List<ContinentsDomain> result = new ArrayList<ContinentsDomain>();
		for (Continent continent : continentAll) {
			ContinentsDomain continentsDomain = new ContinentsDomain();
			continentsDomain.setContinent(continent.getContinent());
			continentsDomain.setCountry(convertCountryDTO(continent.getCountries()));
		}
		return result;
	}

	private List<CountryDomain> convertCountryDTO(List<Country> countries) {
		List<CountryDomain> result = new ArrayList<CountryDomain>();
		for (Country country : countries) {
			CountryDomain CountryDomain = new CountryDomain(country.getName(), country.getFlag());
			result.add(CountryDomain);
		}
		return result;
	}

	@PostConstruct
	public void buildCache() {
		LOG.info("========================== Building Cache Started =====================");
		listOfContinents = convertDTO(continentRepository.findAll());
		LOG.info("Total number of continents : {} " , listOfContinents.size());
		LOG.info("========================== Building End Here =====================");
	}

}
