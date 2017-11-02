package uselessIdentifiersTests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import customChecks.UselessIdentifiersCheck;

public class populateListUnitTest {
	private UselessIdentifiersCheck uic;
	
	@Before
	public void init() {								//Initalize uic object.
		uic = new UselessIdentifiersCheck();
	}
	
	@Test
	public void shouldBeInList() {					//Determine if terms that were supposed to be added are in fact in the list.
		List<String> badWords = uic.populateList();
		
		assertTrue(badWords.contains("int"));
		assertTrue(badWords.contains("List"));
		assertTrue(badWords.contains("String"));
		assertTrue(badWords.contains("double"));
		assertTrue(badWords.contains("final"));
	}
	
	@Test
	public void shouldNotBeInList() {				//Make sure nothing else was added to the list.
		List<String> badWords = uic.populateList();
		
		assertFalse(badWords.contains("NotType"));
		assertFalse(badWords.contains("asdf"));
		assertFalse(badWords.contains("Test"));
	}
}
