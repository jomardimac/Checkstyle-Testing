package UselessIdentifiersTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import customChecks.UselessIdentifiersCheck;

public class GetDefaultTokensUnitTest {
	private UselessIdentifiersCheck uic;
	
	@Before
	public void init() {							//Initialize uic object.
		uic = new UselessIdentifiersCheck();
	}
	
	@Test
	public void checkDefaultTokens() {			//Ensure that the getDefaultTokens is gathering the specified tokens.
		int[] result = uic.getDefaultTokens();
		assertEquals(14, result[0]);		
		assertEquals(15, result[1]);	
		assertEquals(9, result[2]);
		assertEquals(10, result[3]);
	}
}
