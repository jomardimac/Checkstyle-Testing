// Dillon Johnson

package extremeContractionTests.blackBoxTests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import customChecks.ExtremeContractionCheck;

//Input for the setLowestAcceptableCount method can be partitioned into 3 classes
//	Class 1: Input is invalid	(input < 1)
//	Class 2: Input is valid		(1 <= input <= 15)
//	Class 3: Input is invalid	(input > 15)
public class SetLowestAcceptableCountEquivalenceClassPartitioningTest {

	private ExtremeContractionCheck ecc;
	
	@Before
	public void init() {
		ecc = new ExtremeContractionCheck();
	}
	
	//Class 1
	@Test
	public void shouldReturnCountOfOneGivenInvalidInput() {
		ecc.setLowestAcceptableCount(-10);
		assertEquals(1, ecc.getLowestAcceptableCount());
	}
	
	//Class 2
	@Test
	public void shouldReturnCountBetweenOneAndFifteenGivenValidInput() {
		ecc.setLowestAcceptableCount(7);
		assertEquals(7, ecc.getLowestAcceptableCount());
	}
	
	//Class 3
	@Test
	public void shouldReturnCountOfFifteenGivenInvalidInput() {
		ecc.setLowestAcceptableCount(50);
		assertEquals(15, ecc.getLowestAcceptableCount());
	}
}
