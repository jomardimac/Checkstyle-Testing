package meaninglessTermsTests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import customChecks.MeaninglessTermsCheck;

public class GetDefaultTokensUnitTest {

	private MeaninglessTermsCheck mtc;
	
	@Before
	public void init() {						//Initialize mtc object.
		mtc = new MeaninglessTermsCheck();
	}
	
	@Test
	public void checkDefaultTokens() {				//Ensure that getDefaultTokens is grabbing the correct def types.
		int[] result = mtc.getDefaultTokens();
		assertEquals(14, result[0]);
		assertEquals(15, result[1]);	
		assertEquals(9, result[2]);
		assertEquals(10, result[3]);
	}
}
