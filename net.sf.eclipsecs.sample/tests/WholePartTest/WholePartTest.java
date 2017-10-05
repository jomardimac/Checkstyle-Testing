package customChecks;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.Test;
import org.mockito.spy;



import static org.mockito.Mockito.*;

import customChecks.WholePartCheck;

public class WholePartTest {
	
	private WholePartCheck wpc;
	
	@Before
	public void init() {
		wpc = new WholePartCheck;
	}
	
	@Test
	public void shouldReturnFalseIfMethodContainsString() {
		int[] res = wpc.getDefaultTokens();
		//idk what to do here
		assertEquals(10,result[0]);
	}
}
