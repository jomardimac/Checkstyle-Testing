package inconsistentIdentifierUseTests.unitTests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import customChecks.InconsistentIdentifierUseCheck;

@RunWith(MockitoJUnitRunner.class)
public class FindIdentifierTypeUnitTest {
	
	@Spy
	private InconsistentIdentifierUseCheck iiuc;

	@Test
	public void shouldReturnZeroGivenNonMatchingString() {
		doReturn(false).when(iiuc).hasPrecedingF("Car");
		doReturn(false).when(iiuc).isCamelCase("Car");
		doReturn(false).when(iiuc).isSnakeCase("Car");
		doReturn(false).when(iiuc).isAllCaps("Car");
		assertEquals(0, iiuc.findIndentifierType("Car"));
		
		doReturn(false).when(iiuc).hasPrecedingF("LOL I Am Funny");
		doReturn(false).when(iiuc).isCamelCase("LOL I Am Funny");
		doReturn(false).when(iiuc).isSnakeCase("LOL I Am Funny");
		doReturn(false).when(iiuc).isAllCaps("LOL I Am Funny");
		assertEquals(0, iiuc.findIndentifierType("LOL I Am Funny"));
	}

	@Test
	public void shouldReturnOneGivenCamelcaseString() {
		doReturn(false).when(iiuc).hasPrecedingF("helloWorld");
		doReturn(true).when(iiuc).isCamelCase("helloWorld");
		doReturn(false).when(iiuc).isSnakeCase("helloWorld");
		doReturn(false).when(iiuc).isAllCaps("helloWorld");
		assertEquals(1, iiuc.findIndentifierType("helloWorld"));
	}
	
	@Test
	public void shouldReturnTwoGivenSnakecaseString() {
		doReturn(false).when(iiuc).hasPrecedingF("hello_world");
		doReturn(false).when(iiuc).isCamelCase("hello_world");
		doReturn(true).when(iiuc).isSnakeCase("hello_world");
		doReturn(false).when(iiuc).isAllCaps("hello_world");
		assertEquals(2, iiuc.findIndentifierType("hello_world"));
	}
	
	@Test
	public void shouldReturnThreeGivenStringWithPrecedingF() {
		doReturn(true).when(iiuc).hasPrecedingF("fHello");
		doReturn(true).when(iiuc).isCamelCase("fHello");
		doReturn(false).when(iiuc).isSnakeCase("fHello");
		doReturn(false).when(iiuc).isAllCaps("fHello");
		assertEquals(3, iiuc.findIndentifierType("fHello"));
	}
	
	@Test
	public void shouldReturnFourGivenAllCapsString() {
		doReturn(false).when(iiuc).hasPrecedingF("HELLOFRIEND");
		doReturn(false).when(iiuc).isCamelCase("HELLOFRIEND");
		doReturn(false).when(iiuc).isSnakeCase("HELLOFRIEND");
		doReturn(true).when(iiuc).isAllCaps("HELLOFRIEND");
		assertEquals(4, iiuc.findIndentifierType("HELLOFRIEND"));
	}
}
