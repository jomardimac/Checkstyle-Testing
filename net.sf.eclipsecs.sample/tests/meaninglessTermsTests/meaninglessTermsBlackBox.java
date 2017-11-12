package meaninglessTermsTests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import customChecks.MeaninglessTermsCheck;

public class meaninglessTermsBlackBox {
	
	private MeaninglessTermsCheck mtc;
	
	@Before
	public void init() throws IOException {
		mtc = new MeaninglessTermsCheck();
		mtc.populateList();
	}
	
	@Test
	public void isPresentTestTrue() {
		//Test first cause-effect possibility (terms.contains() == true -> return true)
		assertTrue(mtc.isPresent("foo"));
		assertTrue(mtc.isPresent("param"));
		assertTrue(mtc.isPresent("bar"));
		assertTrue(mtc.isPresent("asd"));
	}
	
	@Test
	public void isPresentTestFalse() {
		//Test second cause-effect possibility (terms.contains() == false -> return false)
		assertFalse(mtc.isPresent("validName"));
		assertFalse(mtc.isPresent("test"));
		assertFalse(mtc.isPresent("taxCalculation"));
	}
}
