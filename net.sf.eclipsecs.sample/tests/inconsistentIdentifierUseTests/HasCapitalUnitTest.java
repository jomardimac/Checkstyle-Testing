package inconsistentIdentifierUseTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import customChecks.InconsistentIdentifierUseCheck;

public class HasCapitalUnitTest {

	private InconsistentIdentifierUseCheck iiuc;
	
	@Before
	public void init() {
		iiuc = new InconsistentIdentifierUseCheck();
	}
	
	@Test
	public void shouldReturnTrueGivenStringWithCapital() {
		assertTrue(iiuc.hasCapital("Dillon"));
		assertTrue(iiuc.hasCapital("dillonJohnson"));
		assertTrue(iiuc.hasCapital("my_Var"));
		assertTrue(iiuc.hasCapital("A"));
	}
	
	@Test
	public void shouldReturnFalseGivenStringWithNoCapital() {
		assertFalse(iiuc.hasCapital("hello"));
		assertFalse(iiuc.hasCapital("a_b_c_"));
		assertFalse(iiuc.hasCapital("not-a-cap"));
	}
	
}
