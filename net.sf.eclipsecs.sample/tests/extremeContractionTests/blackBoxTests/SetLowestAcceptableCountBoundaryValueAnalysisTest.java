// Dillon Johnson

package extremeContractionTests.blackBoxTests;

import static org.junit.Assert.*;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import customChecks.ExtremeContractionCheck;

//Testing the boundarys of the setLowestAcceptableCount method within the ExtremeContraciton check
//The method accepts any integer, but valid integers only span from 1-15
public class SetLowestAcceptableCountBoundaryValueAnalysisTest {
	
	private ExtremeContractionCheck ecc;
	private static int min = 1;
	private static int max = 15;
	private Random ran;
	
	@Before
	public void init() {
		ecc = new ExtremeContractionCheck();
		ran = new Random();
	}
	
	@Test
	public void shouldReturnMinGivenMinValueMinusOne() {
		ecc.setLowestAcceptableCount(min-1);
		assertEquals(min, ecc.getLowestAcceptableCount());
	}
	
	@Test
	public void shouldReturnMinGivenMinValue() {
		ecc.setLowestAcceptableCount(min);
		assertEquals(min, ecc.getLowestAcceptableCount());
	}
	
	@Test
	public void shouldReturnMinValuePlusOneGivenMinValuePlusOne() {
		ecc.setLowestAcceptableCount(min+1);
		assertEquals(min+1, ecc.getLowestAcceptableCount());
	}
	
	@Test
	public void shouldReturnNominalValueGivenNominalValue() {
		int nominal = ran.nextInt(10) + 3;	//random number from 3 -> 13
		ecc.setLowestAcceptableCount(nominal);
		assertEquals(nominal, ecc.getLowestAcceptableCount());
	}
	
	@Test
	public void shouldReturnMaxValueMinusOneGivenMaxValueMinusOne() {
		ecc.setLowestAcceptableCount(max-1);
		assertEquals(max-1, ecc.getLowestAcceptableCount());
	}
	
	@Test
	public void shouldReturnMaxValueGivenMaxValue() {
		ecc.setLowestAcceptableCount(max);
		assertEquals(max, ecc.getLowestAcceptableCount());
	}
	
	@Test
	public void shouldReturnMaxValueGivenMaxValuePlusOne() {
		ecc.setLowestAcceptableCount(max+1);
		assertEquals(max, ecc.getLowestAcceptableCount());
	}
}