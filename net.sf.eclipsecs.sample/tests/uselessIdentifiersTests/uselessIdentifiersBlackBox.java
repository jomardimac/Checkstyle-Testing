package uselessIdentifiersTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import customChecks.UselessIdentifiersCheck;

public class uselessIdentifiersBlackBox {
	
	private UselessIdentifiersCheck uic;
	
	@Before
	public void init() {												//Initalize the uic object.
		uic = new UselessIdentifiersCheck();
		uic.populateList();
	}
	
	@Test
	public void substringFoundTest() {
		assertTrue(uic.substringFound("tempInt", "Int"));
		assertFalse(uic.substringFound("newNode", "String"));
		//assertNull(uic.substringFound("newNode", 22));						//Invalid input statement.
	}
	
	@Test
	public void isInListTest() {
		assertTrue(uic.isInList("newInt"));
		assertTrue(uic.isInList("tempString"));
		assertFalse(uic.isInList("taxCalculation"));
		//assertNull(uic.isInList(22));										//Invalid input statement.
	}
}
