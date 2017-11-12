//Dillon Johnson

package inconsistentIdentifierUseTests.whiteBoxTests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import customChecks.InconsistentIdentifierUseCheck;

//As seen in documentation, I will be testing the created test frames.
//On some of the methods there is overlap of Def-Use and Condition Coverage...
//Tests that are not unique will not be rewritten.
public class HasPrecedingFDefUseAndConditionCoverageTest {

	private InconsistentIdentifierUseCheck iiuc;
	
	@Before
	public void init() {
		iiuc = new InconsistentIdentifierUseCheck();
	}
	
	@Test
	public void T1() {
		assertFalse(iiuc.hasPrecedingF("f"));
	}
	
	@Test
	public void T2() {
		assertTrue(iiuc.hasPrecedingF("fPre"));
	}
	
	@Test
	public void T3() {
		assertFalse(iiuc.hasPrecedingF("pre"));
	}
}
