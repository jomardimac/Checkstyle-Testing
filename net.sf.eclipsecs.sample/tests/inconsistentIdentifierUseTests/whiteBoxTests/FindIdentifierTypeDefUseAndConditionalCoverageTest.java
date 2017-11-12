//Dillon Johnson

package inconsistentIdentifierUseTests.whiteBoxTests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import customChecks.InconsistentIdentifierUseCheck;

//As seen in documentation, I will be testing the created test frames.
//On some of the methods there is overlap of Def-Use and Condition Coverage...
//Tests that are not unique will not be rewritten.
public class FindIdentifierTypeDefUseAndConditionalCoverageTest {

	private InconsistentIdentifierUseCheck iiuc;
	
	@Before
	public void init() {
		iiuc = new InconsistentIdentifierUseCheck();
	}
	
	@Test
	public void T1() {
		assertEquals(4, iiuc.findIndentifierType("HELLO"));
	}
	
	@Test
	public void T2() {
		assertEquals(1, iiuc.findIndentifierType("camCas"));
	}
	
	@Test
	public void T3() {
		assertEquals(2, iiuc.findIndentifierType("sn_ake"));
	}
	
	@Test
	public void T4() {
		assertEquals(3, iiuc.findIndentifierType("fHello"));
	}
	
	@Test
	public void T5() {
		assertEquals(0, iiuc.findIndentifierType(""));
	}
}
