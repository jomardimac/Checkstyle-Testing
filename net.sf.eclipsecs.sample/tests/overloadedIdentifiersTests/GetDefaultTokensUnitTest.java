package overloadedIdentifiersTests;

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
		
		System.out.println(res[3]);
		assertEquals(9, res[0]);
		assertEquals(14, res[1]);	
		assertEquals(15, res[2]);
		assertEquals(19, res[3]);
	}
}
