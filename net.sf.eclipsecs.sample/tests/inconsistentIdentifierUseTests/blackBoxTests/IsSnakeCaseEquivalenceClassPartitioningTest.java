//Dillon Johnson

package inconsistentIdentifierUseTests.blackBoxTests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import customChecks.InconsistentIdentifierUseCheck;

//Input for isSnakeCase can be partitioned into 3 classes.
//1. Input is invalid (string is empty/null)
//2. Input is valid (string is not in snakecase form)
//3. Input is valid (string is in snakecase form)
public class IsSnakeCaseEquivalenceClassPartitioningTest {

	private InconsistentIdentifierUseCheck iiuc;
	
	@Before
	public void init() {
		iiuc = new InconsistentIdentifierUseCheck();
	}
	
	//Class 1
	@Test
	public void shouldReturnFalseGivenInvalidInput() {
		assertFalse(iiuc.isSnakeCase(""));
		assertFalse(iiuc.isSnakeCase(null));
	}
	
	//Class 2
	@Test
	public void shouldReturnFalseGivenStringNotInSnakecase() {
		assertFalse(iiuc.isSnakeCase("thisIsNotSnakeCase"));
	}
	
	//Class 3
	@Test
	public void shouldReturnTrueGivenStringInSnakecase() {
		assertTrue(iiuc.isSnakeCase("this_is_snake_case"));
	}
}
