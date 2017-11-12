//Dillon Johnson

package inconsistentIdentifierUseTests.blackBoxTests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import customChecks.InconsistentIdentifierUseCheck;

//Input for hasCapital can be partitioned into 3 classes.
//1. Input is invalid (string is empty/null)
//2. Input is valid (string has no capitals)
//3. Input is valid (stirng has atleast one captital)
public class HasCapitalEquivalenceClassPartitioningTest {

	InconsistentIdentifierUseCheck iiuc;
	
	@Before
	public void init() {
		iiuc = new InconsistentIdentifierUseCheck();
	}
	
	//Class 1
	@Test
	public void shouldReturnFalseGivenInvalidInput() {
		assertFalse(iiuc.hasCapital(""));
		assertFalse(iiuc.hasCapital(null));
	}
	
	//Class 2
	@Test
	public void shouldReturnFalseGivenStringWithNoCapitals() {
		assertFalse(iiuc.hasCapital("hello"));
	}
	
	//Class 3
	@Test
	public void shouldReturnTrueGivenStringWithCapital() {
		assertTrue(iiuc.hasCapital("Nice"));
	}
}
