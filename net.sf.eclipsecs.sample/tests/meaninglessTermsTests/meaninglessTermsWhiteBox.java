package meaninglessTermsTests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import customChecks.MeaninglessTermsCheck;

public class meaninglessTermsWhiteBox {
private MeaninglessTermsCheck mtc;
	
	@Before
	public void init() throws IOException {
		mtc = new MeaninglessTermsCheck();
		mtc.populateList();
	}
	
	@Test
	public void isPresentTest() {					//With these two simple test cases, we achieve the "all-cases" criterion. Explained more in detail in report.
		assertTrue(mtc.isPresent("foo"));
		assertFalse(mtc.isPresent("taxCalculation"));
	}
}
