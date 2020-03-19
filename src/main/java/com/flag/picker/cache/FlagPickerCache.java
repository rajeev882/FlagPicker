/**
 * 
 */
package com.flag.picker.cache;

import java.util.List;

import com.flag.picker.domain.ContinentsDomain;

/**
 * <h1>FlagPickerApplication !</h1> The FlagPickerCache is implementation of
 * Cache for better performance.
 *
 * @author Rajeev kumar
 * @version 1.0
 * @since 2020-03-19
 */
public interface FlagPickerCache {
	/**
	 * Return the list of ContinentsDomain which will be used for rest of
	 * application services.
	 * 
	 * @return List<ContinentsDomain>
	 */
	public List<ContinentsDomain> getContinents();

}
