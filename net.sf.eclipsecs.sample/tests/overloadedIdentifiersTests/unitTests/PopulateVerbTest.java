package overloadedIdentifiersTests.unitTests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import customChecks.OverloadedIdentifiers;

public class PopulateVerbTest {
	//we are gonna be testing this class but one function
	private OverloadedIdentifiers oli;
	
	@Before
	public void init() {
		oli = new OverloadedIdentifiers();
	}
	
	@Test
	public void shouldBeInList() throws IOException{
		List<String> verbList = null;
		
		try {
			verbList = oli.populateVerbList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Check to see if terms were added:
		assertTrue(verbList.contains("do"));
		assertTrue(verbList.contains("create"));
		assertTrue(verbList.contains("implement"));
		assertTrue(verbList.contains("develop"));
	}
	
	@Test
	public void shouldNotBeInList() throws IOException{
		List<String> verbList = null;
		
		try {
			verbList = oli.populateVerbList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Check to see if terms aren't in the list:
		assertFalse(verbList.contains("noun"));
		assertFalse(verbList.contains("seattle"));
		assertFalse(verbList.contains("washington"));
		assertFalse(verbList.contains(""));
	}
}
