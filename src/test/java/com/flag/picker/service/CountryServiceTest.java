/**
 * 
 */
package com.flag.picker.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import com.flag.picker.domain.ContinentsDomain;
import com.flag.picker.domain.CountryDomain;
import com.flag.picker.service.impl.CountryServiceImpl;

/**
 * @author Rajeev kumar
 *
 */
@SpringBootTest
class CountryServiceTest {
	@Mock
	ContinentService mockContinentService;

	@InjectMocks
	CountryServiceImpl mockCountryServiceImpl;

	List<CountryDomain> listCountry = new ArrayList<>();
	List<ContinentsDomain> listContinents = new ArrayList<>();

	@Before
	public void setUp() {
		ReflectionTestUtils.setField(mockCountryServiceImpl, "continentService", mockContinentService);

	}

	@Test
	void test_countries_happy() {
		ContinentsDomain continentsDomain = getContinentsDomain();
		Mockito.when(mockContinentService.getContinent("testContinent")).thenReturn(continentsDomain);
		List<CountryDomain> listContinentsRes = mockCountryServiceImpl.countries("testContinent");
		Assert.assertNotNull(listContinentsRes);
		verify(mockContinentService, times(1)).getContinent("testContinent");
		verifyNoMoreInteractions(mockContinentService);
	}

	@Test
	void test_countries_exception() {
		ContinentsDomain continentsDomain = getContinentsDomainWithCountryNull();
		Mockito.when(mockContinentService.getContinent("testContinent")).thenReturn(continentsDomain);
		Assertions.assertThrows(NullPointerException.class, () -> {
			mockCountryServiceImpl.countries("testContinent").get(0).getName();
		});
		Assert.assertNull(mockCountryServiceImpl.countries("testContinent"));
		verify(mockContinentService, times(2)).getContinent("testContinent");
		verifyNoMoreInteractions(mockContinentService);
	}
	

	@Test
	void test_getFlag_happy() {
		ContinentsDomain continentsDomain = getContinentsDomain();
		Mockito.when(mockContinentService.getContinent("testContinent")).thenReturn(continentsDomain);
		List<CountryDomain> listContinentsRes = mockCountryServiceImpl.countries("testContinent");
		Assert.assertNotNull(listContinentsRes);
		assertEquals("testName", listContinentsRes.get(0).getName());
		assertEquals("testFlag", listContinentsRes.get(0).getFlag());
		verify(mockContinentService, times(1)).getContinent("testContinent");
		verifyNoMoreInteractions(mockContinentService);
	}
	
	@Test
	void test_getFlag_exception() {
		ContinentsDomain continentsDomain = getContinentsDomainWithCountryNull();
		Mockito.when(mockContinentService.getContinent("testContinent")).thenReturn(continentsDomain);
		Assertions.assertThrows(NullPointerException.class, () -> {
			mockCountryServiceImpl.countries("testContinent").get(0).getFlag();
		});
		Assert.assertNull(mockCountryServiceImpl.countries("testContinent"));
		verify(mockContinentService, times(2)).getContinent("testContinent");
		verifyNoMoreInteractions(mockContinentService);
	}

	private ContinentsDomain getContinentsDomainWithCountryNull() {
		ContinentsDomain continentsDomain = new ContinentsDomain();
		continentsDomain.setContinent("testContinent");
		return continentsDomain;
	}

	private ContinentsDomain getContinentsDomain() {
		ContinentsDomain continentsDomain = new ContinentsDomain();
		continentsDomain.setContinent("testContinent");
		CountryDomain countryDomain = new CountryDomain("testName", "testFlag");
		List<CountryDomain> countryDomainList = new ArrayList<>();
		countryDomainList.add(countryDomain);
		continentsDomain.setCountry(countryDomainList);
		return continentsDomain;
	}
}
