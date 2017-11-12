//Dillon Johnson

package extremeContractionTests.whiteBoxTests;

import static org.junit.Assert.*;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import customChecks.ExtremeContractionCheck;

//As seen in documentation, I will be testing the created test frames.
//On some of the methods there is overlap of Def-Use and Condition Coverage...
//Tests that are not unique will not be rewritten.
public class SetLowestAcceptableCountDefUseAndConditionCoverageTest {
	
	private ExtremeContractionCheck ecc;
	
	@Before
	public void init() {
		ecc = new ExtremeContractionCheck();
	}
	
	@Test
	public void T1() {
		ecc.setLowestAcceptableCount(-5);
		assertEquals(1, ecc.getLowestAcceptableCount());
	}
	
	@Test
	public void T2() {
		ecc.setLowestAcceptableCount(20);
		assertEquals(15, ecc.getLowestAcceptableCount());
	}
	
	@Test
	public void T3() {
		ecc.setLowestAcceptableCount(7);
		assertEquals(7, ecc.getLowestAcceptableCount());
	}
}