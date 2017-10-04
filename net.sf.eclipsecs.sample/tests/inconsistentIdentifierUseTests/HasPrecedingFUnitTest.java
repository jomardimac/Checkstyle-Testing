package inconsistentIdentifierUseTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import customChecks.InconsistentIdentifierUseCheck;

public class HasPrecedingFUnitTest {
	
	private InconsistentIdentifierUseCheck iiuc;
	
	@Before
	public void init() {
		iiuc = new InconsistentIdentifierUseCheck();
	}
	
	@Test
	public void shouldReturnFalseGivenNullEmptyOrShortString() {
		assertFalse(iiuc.hasPrecedingF(""));
		assertFalse(iiuc.hasPrecedingF("f"));
		assertFalse(iiuc.hasPrecedingF(null));
	}

	@Test
	public void shouldReturnFalseGivenStringWithoutPrecedingF() {
		assertFalse(iiuc.hasPrecedingF("variable"));
		assertFalse(iiuc.hasPrecedingF("my_var"));
		assertFalse(iiuc.hasPrecedingF("varThree"));
	}

	@Test
	public void shouldReturnFalseGivenStringWithPrecedingUppercaseF() {
		assertFalse(iiuc.hasPrecedingF("FGimmick"));
		assertFalse(iiuc.hasPrecedingF("F"));
	}
	
	@Test
	public void shouldReturnFalseGivenStringWithNonUppercseSecondChar() {
		assertFalse(iiuc.hasPrecedingF("flol"));
		assertFalse(iiuc.hasPrecedingF("f_lol"));
	}
	
	@Test
	public void shouldReturnTrueGivenStringWithPrecedingF() {
		assertTrue(iiuc.hasPrecedingF("fVar"));
		assertTrue(iiuc.hasPrecedingF("fDillon"));
		assertTrue(iiuc.hasPrecedingF("fDillonIsCool"));
	}
}
