package inconsistentIdentifierUseTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import customChecks.InconsistentIdentifierUseCheck;

public class IsAllLowerUnitTest {
	
	private InconsistentIdentifierUseCheck iiuc;

	@Before
	public void init() {
		iiuc = new InconsistentIdentifierUseCheck();
	}

	@Test
	public void shouldReturnTrueGivenAllLowercaseString() {
		assertTrue(iiuc.isAllLower("hello"));
		assertTrue(iiuc.isAllLower("goodbye"));
		assertTrue(iiuc.isAllLower("not_today"));
		assertTrue(iiuc.isAllLower("o"));
	}
	
	@Test
	public void shouldReturnFalseGivenAllUppercaseString() {
		assertFalse(iiuc.isAllLower("HELLO"));
		assertFalse(iiuc.isAllLower("MY"));
		assertFalse(iiuc.isAllLower("NAME_IS"));
		assertFalse(iiuc.isAllLower("DILLON_JOHNSON"));
	}
	
	@Test
	public void shouldReturnFalseGivenMixedCaseString() {
		assertFalse(iiuc.isAllLower("helloThere"));
		assertFalse(iiuc.isAllLower("MyVar"));
		assertFalse(iiuc.isAllLower("myVAR"));
		assertFalse(iiuc.isAllLower("FOOBAr"));
	}
	
	@Test
	public void shouldReturnFalseGivenNullOrEmptyString() {
		assertFalse(iiuc.isAllLower(null));
		assertFalse(iiuc.isAllLower(""));
	}
}
