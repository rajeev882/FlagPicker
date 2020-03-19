/**
 * 
 */
package com.flag.picker.service;

import java.util.List;

import com.flag.picker.domain.ContinentsDomain;

/**
 * @author Rajeev kumar
 *
 */
public interface ContinentService {

	/**
	 * This API is used to get list of ContinentsDomain
	 * 
	 * @return List<ContinentsDomain>
	 */
	public List<ContinentsDomain> getContinents();

	/**
	 * This API is used to get ContinentsDomain for given continentName
	 * 
	 * @param continentName
	 * @return ContinentsDomain
	 */
	public ContinentsDomain getContinent(String continentName);

}
