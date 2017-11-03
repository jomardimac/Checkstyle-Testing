package extremeContractionTests.unitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import customChecks.ExtremeContractionCheck;

public class SetLowestAcceptableCountUnitTest {

	private ExtremeContractionCheck ecc;
	
	@Before
	public void init() {
		ecc = new ExtremeContractionCheck();
	}
	
	@Test
	public void shouldReturnCountGivenCountAboveZero() {
		ecc.setLowestAcceptableCount(1);
		assertEquals(1, ecc.getLowestAcceptableCount());
		ecc.setLowestAcceptableCount(25);
		assertEquals(15, ecc.getLowestAcceptableCount());
		ecc.setLowestAcceptableCount(3);
		assertEquals(3, ecc.getLowestAcceptableCount());
		ecc.setLowestAcceptableCount(15678);
		assertEquals(15, ecc.getLowestAcceptableCount());
	}
	
	@Test
	public void shouldReturnOneGivenCountLessThanOrEqualToZero() {
		ecc.setLowestAcceptableCount(0);
		assertEquals(1, ecc.getLowestAcceptableCount());
		ecc.setLowestAcceptableCount(-5);
		assertEquals(1, ecc.getLowestAcceptableCount());
		ecc.setLowestAcceptableCount(-500);
		assertEquals(1, ecc.getLowestAcceptableCount());
		ecc.setLowestAcceptableCount(-123456);
		assertEquals(1, ecc.getLowestAcceptableCount());
	}

}
