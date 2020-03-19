/**
 * 
 */
package com.flag.picker.cache.impl;

import static com.flag.picker.config.FlagPickerContants.CLASSPATH_CONTINENTS_JSON;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flag.picker.cache.FlagPickerCache;
import com.flag.picker.domain.ContinentsDomain;
import com.flag.picker.exception.FlagPickerException;

/**
 * <h1>FlagPickerApplication !</h1> The FlagPickerCacheIDemoimpl is Demo-in
 * memory implementation of FlagPickerCache.
 *
 * @author Rajeev kumar
 * @version 1.0
 * @since 2020-03-19
 */
@Component
public class FlagPickerCacheIDemoimpl implements FlagPickerCache {

	Logger LOG = LoggerFactory.getLogger(FlagPickerCacheIDemoimpl.class);

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	ResourceLoader resourceLoader;

	public List<ContinentsDomain> listOfContinents = new ArrayList<ContinentsDomain>();

	@Override
	public List<ContinentsDomain> getContinents() {
		return listOfContinents;
	}

	@PostConstruct
	public void buildCache() {
		LOG.info("========================== Building Cache Started =====================");
		List<ContinentsDomain> continents = new ArrayList<>();
		try {
			Resource resource = resourceLoader.getResource(CLASSPATH_CONTINENTS_JSON);
			InputStream input = resource.getInputStream();
			continents = mapper.readValue(input, new TypeReference<List<ContinentsDomain>>() {});
			LOG.info("Total number of continents : {} " , continents.size());
		} catch (IOException e) {
			throw new FlagPickerException("Error occured while building cache ", e);

		}
		listOfContinents.addAll(continents);
		LOG.info("========================== Building End Here =====================");
	}

}
