package inconsistentIdnetifierUseTests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Spy;

import customChecks.InconsistentIdentifierUseCheck;

public class IsCamelCaseIntegrationTest {
	
	@Spy
	private InconsistentIdentifierUseCheck iiuc;

	@Test
	public void shouldReturnFalseGivenNonCamelcaseStringAndStubbedHasCapital() {
		doReturn(true).when(iiuc).hasCapital("NotACamelCaseString");
		assertFalse(iiuc.isCamelCase("NotACamelCaseString"));
	}

}
