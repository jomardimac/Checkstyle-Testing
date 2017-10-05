package UselessIdentifiersTests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import customChecks.UselessIdentifiersCheck;

public class subStringFoundTest {
	
	private UselessIdentifiersCheck uic;
	
	@Before
	public void init() {												//Initalize the uic object.
		uic = new UselessIdentifiersCheck();
	}
	
	@Test
	public void isSubstring() {										//Test that when string2 is a substring of string 1, that true is returned from subStringFound().
		assertTrue(uic.substringFound("newtest", "test"));
		assertTrue(uic.substringFound("testInt", "Int"));
		assertTrue(uic.substringFound("termsList", "List"));
		assertTrue(uic.substringFound("tempDouble", "Double"));
		assertTrue(uic.substringFound("tempNew", "pNew"));
	}
	
	@Test
	public void isNotSubstring() {									//Test that when string2 is not a substring of string 1, that false is returned from substringFound().
		assertFalse(uic.substringFound("newTerm", "Terms"));
		assertFalse(uic.substringFound("NotTrue", "False"));
		assertFalse(uic.substringFound("newINT", "int"));
	}
}


