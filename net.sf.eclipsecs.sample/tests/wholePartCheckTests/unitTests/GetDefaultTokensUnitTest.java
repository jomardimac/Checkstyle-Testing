package wholePartCheckTests.unitTests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import customChecks.WholePartCheck;

public class GetDefaultTokensUnitTest {
	private WholePartCheck wpc;
	
	@Before
	public void init() {
		wpc = new WholePartCheck();
	}
	
	@Test
	public void checkDefaultTokens() {
		int[] res = wpc.getDefaultTokens();
		
		System.out.println(res[0]);
		System.out.println(res[1]);
		System.out.println(res[2]);
		assertEquals(14, res[0]);
		assertEquals(15, res[1]);	
		assertEquals(9, res[2]);
	}
}

