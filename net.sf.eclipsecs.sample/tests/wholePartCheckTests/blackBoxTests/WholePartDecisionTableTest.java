package wholePartCheckTests.blackBoxTests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import customChecks.WholePartCheck;

public class WholePartDecisionTableTest {
	private WholePartCheck wpc;
	
	//instantiate the class
	@Before
	public void init() {
		wpc = new WholePartCheck();
		
	}
	
	//These will be what is true in the decision table made in the report.
	@Test
	public void isWholePartTrue() {
		assertTrue(wpc.subStringCheck("testFunc", "test"));
		assertTrue(wpc.subStringCheck("ClassName", "Class"));
	}
	
	//These will be what is false in the decision table made in the report.
	@Test
	public void isWholePartFalse() {
		assertFalse(wpc.subStringCheck("check", "testing"));
		assertFalse(wpc.subStringCheck("test", "ClassName"));
	}
	
	//THIS IS THE ACTUAL BLACKBOX INPUTS IN DECISION TABLE:
	@Test
	public void wholePartDecisionTable() {
		assertTrue(wpc.subStringCheck("testFunc", "test"));
		assertFalse(wpc.subStringCheck("test", "ClassName"));
		assertFalse(wpc.subStringCheck(3, 44));
	}
	//These will be the invalid tests, aka if the substring parameters are not strings::
	@Test
	public void isWholePartInvalid() {
		assertFalse(wpc.subStringCheck(15, 155));
		assertFalse(wpc.subStringCheck(3, 44));
	}
}
