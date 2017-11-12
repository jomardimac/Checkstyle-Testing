//Dillon Johnson

package inconsistentIdentifierUseTests.blackBoxTests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import customChecks.InconsistentIdentifierUseCheck;

//Input for IsAllLower can be divided into 3 classes
//1. Input is invalid (string is empty/null)
//2. Input is valid (string has atleast one capital letter)
//3. Input is valid (string has no capital letters)
public class IsAllLowerEquivalenceClassPartitioningTest {
	
	InconsistentIdentifierUseCheck iiuc;
	
	@Before
	public void init() {
		iiuc = new InconsistentIdentifierUseCheck();
	}
	
	//Class 1
	@Test
	public void shouldReturnFalseGivenInvalidInput() {
		assertFalse(iiuc.isAllLower(""));
		assertFalse(iiuc.isAllLower(null));
	}
	
	//Class 2
	@Test
	public void shouldReturnFalseGivenStringWithAtleastOneCapitalLetter() {
		assertFalse(iiuc.isAllLower("Hello"));
	}
	
	//Class 3
	@Test
	public void shouldReturnTrueGivenStringWithNoCapitalLetters() {
		assertTrue(iiuc.isAllLower("dillon"));
	}
}