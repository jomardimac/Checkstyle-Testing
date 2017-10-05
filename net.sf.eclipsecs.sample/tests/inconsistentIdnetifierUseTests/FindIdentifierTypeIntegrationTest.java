package inconsistentIdnetifierUseTests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import customChecks.InconsistentIdentifierUseCheck;

@RunWith(MockitoJUnitRunner.class)
public class FindIdentifierTypeIntegrationTest {
	
	@Spy
	private InconsistentIdentifierUseCheck iiuc;
	
	private InconsistentIdentifierUseCheck iiucReal;

	@Test
	public void shouldReturnZeroGivenStringWithNoCaseWithStubbedCamelSnakeAndCaps() {
		doReturn(false).when(iiuc).isCamelCase("Not a good String");
		doReturn(false).when(iiuc).isSnakeCase("Not a good String");
		doReturn(false).when(iiuc).isAllCaps("Not a good String");
		assertEquals(0, iiuc.findIndentifierType("Not a good String"));
	}
	
	@Test
	public void shouldReturnZeroGivenStringWithNoCaseWithStubbedSnakeAndCaps() {
		doReturn(false).when(iiuc).isSnakeCase("Not a good String");
		doReturn(false).when(iiuc).isAllCaps("Not a good String");
		assertEquals(0, iiuc.findIndentifierType("Not a good String"));
	}
	
	@Test
	public void shouldReturnZeroGivenStringWithNoCaseWithStubbedCaps() {
		doReturn(false).when(iiuc).isAllCaps("Not a good String");
		assertEquals(0, iiuc.findIndentifierType("Not a good String"));
	}
	
	@Test
	public void shouldReturnZeroGivenStringWithNoCaseWithNoStubs() {
		iiucReal = new InconsistentIdentifierUseCheck();
		assertEquals(0, iiuc.findIndentifierType("Not a good String"));
	}
	
	
	@Test
	public void shouldReturnOneGivenStringWithCamelcaseWithStubbedCamelSnakeAndCaps() {
		doReturn(true).when(iiuc).isCamelCase("aCamelCaseString");
		doReturn(false).when(iiuc).isSnakeCase("aCamelCaseString");
		doReturn(false).when(iiuc).isAllCaps("aCamelCaseString");
		assertEquals(1, iiuc.findIndentifierType("aCamelCaseString"));
	}
	
	@Test
	public void shouldReturnOneGivenStringWithCamelcaseWithStubbedSnakeAndCaps() {
		doReturn(false).when(iiuc).isSnakeCase("aCamelCaseString");
		doReturn(false).when(iiuc).isAllCaps("aCamelCaseString");
		assertEquals(1, iiuc.findIndentifierType("aCamelCaseString"));
	}
	
	@Test
	public void shouldReturnOneGivenStringWithCamelcaseWithStubbedCaps() {
		doReturn(false).when(iiuc).isAllCaps("aCamelCaseString");
		assertEquals(1, iiuc.findIndentifierType("aCamelCaseString"));
	}
	
	@Test
	public void shouldReturnOneGivenStringWithCamelcaseWithNoStubs() {
		iiucReal = new InconsistentIdentifierUseCheck();
		assertEquals(1, iiuc.findIndentifierType("aCamelCaseString"));
	}

	
	@Test
	public void shouldReturnTwoGivenStringWithSnakecaseWithStubbedCamelSnakeAndCaps() {
		doReturn(false).when(iiuc).isCamelCase("a_snake_case_string");
		doReturn(true).when(iiuc).isSnakeCase("a_snake_case_string");
		doReturn(false).when(iiuc).isAllCaps("a_snake_case_string");
		assertEquals(2, iiuc.findIndentifierType("a_snake_case_string"));
	}
	
	@Test
	public void shouldReturnTwoGivenStringWithSnakecaseWithStubbedSnakeAndCaps() {
		doReturn(true).when(iiuc).isSnakeCase("a_snake_case_string");
		doReturn(false).when(iiuc).isAllCaps("a_snake_case_string");
		assertEquals(2, iiuc.findIndentifierType("a_snake_case_string"));
	}
	
	@Test
	public void shouldReturnTwoGivenStringWithSnakecaseWithStubbedCaps() {
		doReturn(false).when(iiuc).isAllCaps("a_snake_case_string");
		assertEquals(2, iiuc.findIndentifierType("a_snake_case_string"));
	}
	
	@Test
	public void shouldReturnTwoGivenStringWithSnakecaseWithNoStubs() {
		iiucReal = new InconsistentIdentifierUseCheck();
		assertEquals(2, iiuc.findIndentifierType("a_snake_case_string"));
	}
	
	
	@Test
	public void shouldReturnThreeGivenStringWithPrecedingFWithStubbedCamelSnakeAndCaps() {
		doReturn(false).when(iiuc).isCamelCase("fVariable");
		doReturn(true).when(iiuc).isSnakeCase("fVariable");
		doReturn(false).when(iiuc).isAllCaps("fVariable");
		assertEquals(3, iiuc.findIndentifierType("fVariable"));
	}
	
	@Test
	public void shouldReturnThreeGivenStringWithPrecedingFWithStubbedSnakeAndCaps() {
		doReturn(true).when(iiuc).isSnakeCase("fVariable");
		doReturn(false).when(iiuc).isAllCaps("fVariable");
		assertEquals(3, iiuc.findIndentifierType("fVariable"));
	}
	
	@Test
	public void shouldReturnThreeGivenStringWithPrecedingFWithStubbedCaps() {
		doReturn(false).when(iiuc).isAllCaps("fVariable");
		assertEquals(3, iiuc.findIndentifierType("fVariable"));
	}
	
	@Test
	public void shouldReturnThreeGivenStringWithPrecedingFWithNoStubs() {
		iiucReal = new InconsistentIdentifierUseCheck();
		assertEquals(3, iiuc.findIndentifierType("fVariable"));
	}
	
	
	@Test
	public void shouldReturnFourGivenStringWithAllCapsWithStubbedCamelSnakeAndCaps() {
		doReturn(false).when(iiuc).isCamelCase("ALLCAPS");
		doReturn(false).when(iiuc).isSnakeCase("ALLCAPS");
		doReturn(true).when(iiuc).isAllCaps("ALLCAPS");
		assertEquals(4, iiuc.findIndentifierType("ALLCAPS"));
	}
	
	@Test
	public void shouldReturnFourGivenStringWithAllCapsWithStubbedSnakeAndCaps() {
		doReturn(false).when(iiuc).isSnakeCase("ALLCAPS");
		doReturn(true).when(iiuc).isAllCaps("ALLCAPS");
		assertEquals(4, iiuc.findIndentifierType("ALLCAPS"));
	}
	
	@Test
	public void shouldReturnFourGivenStringWithAllCapsWithStubbedCaps() {
		doReturn(true).when(iiuc).isAllCaps("ALLCAPS");
		assertEquals(4, iiuc.findIndentifierType("ALLCAPS"));
	}
	
	@Test
	public void shouldReturnFourGivenStringWithAllCapsWithNoStubs() {
		iiucReal = new InconsistentIdentifierUseCheck();
		assertEquals(4, iiuc.findIndentifierType("ALLCAPS"));
	}
}
