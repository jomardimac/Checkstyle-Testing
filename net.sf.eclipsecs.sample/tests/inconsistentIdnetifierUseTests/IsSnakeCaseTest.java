package inconsistentIdnetifierUseTests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;

import org.junit.Before;
import org.junit.Test;

import customChecks.InconsistentIdentifierUseCheck;

public class IsSnakeCaseTest {

	private InconsistentIdentifierUseCheck iiuc;
	
	@Before
	public void init() {
		iiuc = new InconsistentIdentifierUseCheck();
	}
	
	@Test
	public void shouldReturnFalseGivenNullOrEmptyString() {
		assertFalse(iiuc.isSnakeCase(""));
		assertFalse(iiuc.isSnakeCase(null));
	}
	
	@Test
	public void shouldReturnFalseGivenStringWithoutUnderscores() {
		assertFalse(iiuc.isSnakeCase("hello"));
		assertFalse(iiuc.isSnakeCase("Apples"));
		assertFalse(iiuc.isSnakeCase("HI"));
	}
	
	@Test
	public void shouldReturnFalseGivenStringWithStartingOrEndingUnderScoreOnly() {
		assertFalse(iiuc.isSnakeCase("_hello"));
		assertFalse(iiuc.isSnakeCase("hello_"));
		assertFalse(iiuc.isSnakeCase("_hello_"));
	}
	
	@Test
	public void shouldReturnTrueGivenStringUsingSnakeCase() {
		assertTrue(iiuc.isSnakeCase("this_is_snake_case"));
		assertTrue(iiuc.isSnakeCase("THIS_IS_ALSO_SNAKE_CASE"));
		assertTrue(iiuc.isSnakeCase("THIS_is_SC"));
		assertTrue(iiuc.isSnakeCase("T_C"));
		assertTrue(iiuc.isSnakeCase("_T_C_"));
	}
}
