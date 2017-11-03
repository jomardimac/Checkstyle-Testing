package inconsistentIdentifierUseTests.blackBoxTests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import customChecks.InconsistentIdentifierUseCheck;

//Input for hasPrecedingF can be partitioned into 5 classes.
//1. Input is invalid (string is empty/null)
//2. Input is valid (string does not have preceding f)
//3. Input is valid (string contains preceding f and has a length of 1)
//3. Input is valid (string has a preceding f followed by a non capital letter)
//4. Input is valid (string has a preceding f followed by a capital letter)
public class HasPrecedingFEquivalenceClassPartitioningTest {

	private InconsistentIdentifierUseCheck iiuc;
	
	@Before
	public void init() {
		iiuc = new InconsistentIdentifierUseCheck();
	}
	
	//Class 1
	@Test
	public void shouldReturnFalseGivenInvalidInput() {
		assertFalse(iiuc.hasPrecedingF(""));
		assertFalse(iiuc.hasPrecedingF(null));
	}
	
	//Class 2
	@Test
	public void shouldReturnFalseGivenStringWithNoPrecedingF() {
		assertFalse(iiuc.hasPrecedingF("hello"));
	}
	
	//Class 3
	@Test
	public void shouldReturnFalseGivenStringWithPrecedingFOfLengthOne() {
		assertFalse(iiuc.hasPrecedingF("f"));
	}
	
	//Class 4
	@Test
	public void shouldReturnFalseGivenStringWithPrecedingFFollowedByNonCapitalLetter() {
		assertFalse(iiuc.hasPrecedingF("fvariable"));
	}
	
	//Class 5
	@Test
	public void shouldReturnTrueGivenStringWithPrecedingFFollowedByCapitalLetter() {
		assertTrue(iiuc.hasPrecedingF("fVariableName"));
	}
}
