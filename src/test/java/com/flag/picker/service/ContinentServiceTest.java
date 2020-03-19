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

import com.flag.picker.cache.FlagPickerCache;
import com.flag.picker.domain.ContinentsDomain;
import com.flag.picker.service.impl.ContinentServiceImpl;

/**
 * @author Rajeev kumar
 *
 */
@SpringBootTest
class ContinentServiceTest {

	@Mock
	FlagPickerCache mockFlagPickerCache;

	@InjectMocks
	ContinentServiceImpl mockContinentService;

	List<ContinentsDomain> listContinents = new ArrayList<>();

	@Before
	public void setUp() {
		ReflectionTestUtils.setField(mockContinentService, "flagPickerCache", mockFlagPickerCache);
		
	}

	@Test
	void test_getContinents_happy() {
		Mockito.when(mockFlagPickerCache.getContinents()).thenReturn(listContinents);
		List<ContinentsDomain> continentList = mockContinentService.getContinents();
		Assert.assertNotNull(continentList);
		Assert.assertEquals(new ArrayList<>(), continentList);
		verify(mockFlagPickerCache).getContinents();
		verifyNoMoreInteractions(mockFlagPickerCache);
	}

	@Test
	void test_getContinents_Exception() {
		Mockito.when(mockFlagPickerCache.getContinents()).thenReturn(null);
		Assertions.assertThrows(NullPointerException.class, () -> {
			mockContinentService.getContinents().get(0);
		});

		Assert.assertNull(mockContinentService.getContinents());

		verify(mockFlagPickerCache, times(2)).getContinents();
		verifyNoMoreInteractions(mockFlagPickerCache);
	}

	@Test
	void test_getContinent_withvalue_happy() {
		ContinentsDomain continentsDomain = new ContinentsDomain();
		continentsDomain.setContinent("testcontinent");
		listContinents.add(continentsDomain);
		Mockito.when(mockFlagPickerCache.getContinents()).thenReturn(listContinents);
		List<ContinentsDomain> continentList = mockContinentService.getContinents();
		Assert.assertNotNull(continentList);
		Assert.assertEquals(listContinents, continentList);
		assertEquals("testcontinent", mockContinentService.getContinents().get(0).getContinent());
		verify(mockFlagPickerCache, times(2)).getContinents();
		verifyNoMoreInteractions(mockFlagPickerCache);
	}

	@Test
	void test_getContinent_withvalue__Exception() {
		Mockito.when(mockFlagPickerCache.getContinents()).thenReturn(null);
		Assertions.assertThrows(NullPointerException.class, () -> {
			mockContinentService.getContinents().get(0);
		});

		Assert.assertNull(mockContinentService.getContinents());

		verify(mockFlagPickerCache, times(2)).getContinents();

		verifyNoMoreInteractions(mockFlagPickerCache);
	}

}
