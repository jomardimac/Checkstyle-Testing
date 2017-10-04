package extremeContractionTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import customChecks.ExtremeContractionCheck;

public class GetDefaultTokensUnitTest {
	
	private ExtremeContractionCheck ecc;
	
	@Before
	public void init() {
		ecc = new ExtremeContractionCheck();
	}
	
	@Test
	public void shouldReturnSpecificValuesGivenClassInterfaceMethodAndVariableDefs() {
		int[] result = ecc.getDefaultTokens();
		assertEquals(14, result[0]);
		assertEquals(15, result[1]);
		assertEquals(9, result[2]);
		assertEquals(10, result[3]);
	}

}
