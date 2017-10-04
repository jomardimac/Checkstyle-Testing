package inconsistentIdnetifierUseTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import customChecks.InconsistentIdentifierUseCheck;

public class GetDefaultTokensUnitTest {

private InconsistentIdentifierUseCheck iiuc;
	
	@Before
	public void init() {
		iiuc = new InconsistentIdentifierUseCheck();
	}
	
	@Test
	public void shouldReturnSpecificValuesGivenClassInterfaceMethodAndVariableDefs() {
		int[] result = iiuc.getDefaultTokens();
		assertEquals(10, result[0]);
	}
}
