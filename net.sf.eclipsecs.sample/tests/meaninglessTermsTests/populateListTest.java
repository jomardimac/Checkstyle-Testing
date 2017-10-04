package meaninglessTermsTests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import customChecks.MeaninglessTermsCheck;

public class populateListTest {

	private MeaninglessTermsCheck mtc;
	
	@Before
	public void init() {											//Initialize the mtc object.
		mtc = new MeaninglessTermsCheck();
	}
	
	@Test
	public void shouldBeInList() throws IOException {				//Test that variables were correctly added to list.
		List<String> terms = null;
		try {
			terms = mtc.populateList();							//Populate the list with the terms from the original class.
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Determine if the correct terms were added.
		assertTrue(terms.contains("foo"));
		assertTrue(terms.contains("var"));
		assertTrue(terms.contains("bar"));
		assertTrue(terms.contains("asd"));
	}
	
	@Test
	public void shouldNotBeInList() {							//Test to ensure that variables were not added that do not belong there.
		List<String> terms = null;
		try {
			terms = mtc.populateList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Check to make sure that nothing different was added.
		assertFalse(terms.contains("test"));
		assertFalse(terms.contains("not in list"));
		assertFalse(terms.contains("jkl"));
	}
}
