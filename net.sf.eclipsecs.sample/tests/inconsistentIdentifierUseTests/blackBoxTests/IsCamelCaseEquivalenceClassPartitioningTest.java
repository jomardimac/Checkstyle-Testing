//Dillon Johnson

package inconsistentIdentifierUseTests.blackBoxTests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import customChecks.InconsistentIdentifierUseCheck;

//Input for isCamelCase can be partitioned into 3 classes.
//1. Input is invalid (string is empty/null)
//2. Input is valid (string is not in camelCase form)
//3. Input is valid (string is in camelCase form)
public class IsCamelCaseEquivalenceClassPartitioningTest {

	private InconsistentIdentifierUseCheck iiuc;
	
	@Before
	public void init() {
		iiuc = new InconsistentIdentifierUseCheck();
	}
	
	//Class 1
	@Test
	public void shouldReturnFalseGivenInvalidInput() {
		assertFalse(iiuc.isCamelCase(""));
		assertFalse(iiuc.isCamelCase(null));
	}
	
	//Class 2
	@Test
	public void shouldReturnFalseGivenStringNotInCamelCaseForm() {
		assertFalse(iiuc.isCamelCase("Apple"));
	}
	
	//Class 3
	@Test
	public void shouldReturnTrueGivenStringInCamelCaseForm() {
		assertTrue(iiuc.isCamelCase("camelCase"));
	}
}
