package uselessIdentifiersTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import customChecks.UselessIdentifiersCheck;

public class uselessIdentifiersWhiteBox {					//White box testing for useless identifiers check.
	
	private UselessIdentifiersCheck uic;
	
	@Before
	public void init() {												//Initalize the uic object.
		uic = new UselessIdentifiersCheck();
		uic.populateList();
	}
	
	@Test
	public void substringFoundTest() {
		assertTrue(uic.substringFound("newString", "String"));
		assertFalse(uic.substringFound("taxCalculation", "testing"));
	}
	
	@Test
	public void isInListTest() {
		assertTrue(uic.isInList("newInt"));
		assertFalse(uic.isInList("taxCalculation"));
	}
}
