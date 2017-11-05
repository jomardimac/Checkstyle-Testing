// Dillon Johnson

package inconsistentIdentifierUseTests.blackBoxTests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import customChecks.InconsistentIdentifierUseCheck;

//Input for isAllCaps can be partitioned into 3 classes.
//1. Input is invalid (string is empty/null)
//2. Input is valid (string contains >= 1 non Capitalized character)
//3. Input is valid (string is made of only Capitalized characters)

public class IsAllCapsEquivalenceClassPartitioningTest {

	private InconsistentIdentifierUseCheck iiuc;
	
	@Before
	public void init() {
		iiuc = new InconsistentIdentifierUseCheck();
	}
	
	//Class 1
	@Test
	public void shouldReturnFalseGivenInvalidInput() {
		assertFalse(iiuc.isAllCaps(""));
		assertFalse(iiuc.isAllCaps(null));
	}
	
	//Class 2
	@Test
	public void shouldReturnFalseGivenStringWithAtleastOneNonCapitalizedChar() {
		assertFalse(iiuc.isAllCaps("hello MY NAME IS DILLON"));
	}
	
	//Class 3
	@Test
	public void shouldReturnTrueGivenStringContainingOnlyCapitalLetters() {
		assertTrue(iiuc.isAllCaps("HELLO"));
	}
}
