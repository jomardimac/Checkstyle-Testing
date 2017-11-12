// Dillon Johnson

package inconsistentIdentifierUseTests.blackBoxTests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import customChecks.InconsistentIdentifierUseCheck;

//Input for findIdentifierType can be partitioned into 6 classes.
//1. Input is invalid (string is empty/null)
//2. Input is valid (string does not match any identifier type)
//3. Input is valid (string matches camelCase 		identifier type)
//4. Input is valid (string matches snake_case 		identifier type)
//5. Input is valid (string matches fHasPrecedingF 	identifier type)
//6. Input is valid (string matches ALL CAPS		identifier type)

public class FindIdentifierTypeEquivalenceClassPartitioningTest {

	private InconsistentIdentifierUseCheck iiuc;
	
	@Before
	public void init() {
		iiuc = new InconsistentIdentifierUseCheck();
	}
	
	//Class 1
	@Test
	public void shouldReturnZeroGivenInvalidString() {
		assertEquals(0, iiuc.findIndentifierType(""));
		assertEquals(0, iiuc.findIndentifierType(null));
	}
	
	//Class 2
	@Test
	public void shouldReturnZeroGivenUnknownIdentifier() {
		assertEquals(0, iiuc.findIndentifierType("HeLlO_hOW aRe-YoU"));
	}
	
	//Class 3
	@Test
	public void shouldReturnOneGivenStringInCamelcase() {
		assertEquals(1, iiuc.findIndentifierType("camelCaseString"));
	}
	
	//Class 4
	@Test
	public void shouldReturnTwoGivenStringInSnakecase() {
		assertEquals(2, iiuc.findIndentifierType("snake_case_string"));
	}
	
	//Class 5
	@Test
	public void shouldReturnThreeGivenStringWithPrecedingF() {
		assertEquals(3, iiuc.findIndentifierType("fPrecedingFString"));
	}
	
	//Class 6
	@Test
	public void shouldReturnFourGivenStringInAllCaps() {
		assertEquals(4, iiuc.findIndentifierType("ALL CAPS STRING"));
	}
}
