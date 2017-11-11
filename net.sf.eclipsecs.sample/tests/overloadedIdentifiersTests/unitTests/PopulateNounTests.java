package overloadedIdentifiersTests.unitTests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import customChecks.OverloadedIdentifiers;

public class PopulateNounTests {
	//we are gonna be testing this class but one function
	private OverloadedIdentifiers oli;
	
	@Before
	public void init() {
		oli = new OverloadedIdentifiers();
	}
	
	@Test
	public void shouldBeInList() throws IOException{
		List<String> nounList = null;
		
		try {
			nounList = oli.populateNounList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Check to see if terms were added:
		assertTrue(nounList.contains("rice"));
		assertTrue(nounList.contains("cat"));
		assertTrue(nounList.contains("dog"));
		assertTrue(nounList.contains("snow"));
	}
	
	@Test
	public void shouldNotBeInList() throws IOException{
		List<String> nounList = null;
		
		try {
			nounList = oli.populateNounList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Check to see if terms aren't in the list:
		assertFalse(nounList.contains("do"));
		assertFalse(nounList.contains("create"));
		assertFalse(nounList.contains("sing"));
		assertFalse(nounList.contains(""));
	}
}
