/**
 * 
 */
package com.flag.picker.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flag.picker.cache.FlagPickerCache;
import com.flag.picker.domain.ContinentsDomain;
import com.flag.picker.exception.FlagPickerException;
import com.flag.picker.service.ContinentService;

/**
 * @author Rajeev kumar
 *
 */
@Service
public class ContinentServiceImpl implements ContinentService {

	Logger LOG = LoggerFactory.getLogger(ContinentService.class);

	@Autowired
	private FlagPickerCache flagPickerCache;

	@Override
	public List<ContinentsDomain> getContinents() {
		List<ContinentsDomain> listContinents = new ArrayList<>();
		try {
			listContinents = flagPickerCache.getContinents();
			LOG.debug("listContinents : {} " ,listContinents);
		} catch (Exception e) {
			LOG.error("Error occured while fetching Continents list");
			throw new FlagPickerException("Error occured while fetching Continents list ", e);
		}
		return listContinents;
	}

	@Override
	public ContinentsDomain getContinent(String continentName) {
		ContinentsDomain resultContinents = new ContinentsDomain();
		try {
			List<ContinentsDomain> continents = flagPickerCache.getContinents();
			LOG.debug("continents : {} " ,continents);
			Optional<ContinentsDomain> foundContinent = continents.stream()
					.filter(continent -> continent.getContinent().equals(continentName)).findFirst();
			System.out.println("foundContinent :-  " + foundContinent);
			resultContinents = foundContinent.orElse(null);
		} catch (Exception e) {
			throw new FlagPickerException("Error occured while fetching continent for given continentName ", e);
		}

		return resultContinents;
	}

}
