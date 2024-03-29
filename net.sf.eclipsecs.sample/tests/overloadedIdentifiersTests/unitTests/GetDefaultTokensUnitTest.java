package overloadedIdentifiersTests.unitTests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import customChecks.OverloadedIdentifiers;

public class GetDefaultTokensUnitTest {
	private OverloadedIdentifiers oli;
	
	@Before
	public void init() {
		oli = new OverloadedIdentifiers();
	}
	
	@Test
	public void checkDefaultTokens() {
		int[] res = oli.getDefaultTokens();
		
		assertEquals(9, res[0]);
		assertEquals(14, res[1]);	
		assertEquals(15, res[2]);
	}
}
