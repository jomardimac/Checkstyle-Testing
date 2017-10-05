package inconsistentIdnetifierUseTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import customChecks.InconsistentIdentifierUseCheck;

public class IsAllCapsUnitTest {
	
	private InconsistentIdentifierUseCheck iiuc;

	@Before
	public void init() {
		iiuc = new InconsistentIdentifierUseCheck();
	}

	@Test
	public void shouldReturnFalseGivenNullOrEmptyString() {
		assertFalse(iiuc.isAllCaps(""));
		assertFalse(iiuc.isAllCaps(null));
	}
	
	@Test
	public void shouldReturnFalseGivenStringWithLowercaseChars() {
		assertFalse(iiuc.isAllCaps("Hello_There"));
		assertFalse(iiuc.isAllCaps("HeY"));
		assertFalse(iiuc.isAllCaps("AAAaA_"));
		assertFalse(iiuc.isAllCaps("dillonjohnson"));
	}
	
	@Test
	public void shouldReturnTrueGivenStringWithAllCapitals() {
		assertTrue(iiuc.isAllCaps("ABCDEF"));
		assertTrue(iiuc.isAllCaps("DILLON JOHNSON"));
		assertTrue(iiuc.isAllCaps("HELLO_FRIEND"));
	}
}
