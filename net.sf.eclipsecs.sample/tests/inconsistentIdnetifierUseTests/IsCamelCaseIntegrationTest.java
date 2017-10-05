package inconsistentIdnetifierUseTests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import customChecks.InconsistentIdentifierUseCheck;

@RunWith(MockitoJUnitRunner.class)
public class IsCamelCaseIntegrationTest {
	
	@Spy
	private InconsistentIdentifierUseCheck iiuc;
	
	private InconsistentIdentifierUseCheck iiucReal;

	@Test
	public void shouldReturnFalseGivenNonCamelcaseStringAndStubbedHasCapital() {
		doReturn(true).when(iiuc).hasCapital("NotACamelCaseString");
		assertFalse(iiuc.isCamelCase("NotACamelCaseString"));
		
		doReturn(true).when(iiuc).hasCapital("A");
		assertFalse(iiuc.isCamelCase("A"));
		
		doReturn(false).when(iiuc).hasCapital("hello_friend");
		assertFalse(iiuc.isCamelCase("hello_friend"));
	}
	
	@Test
	public void shouldReturnFalseGivenNonCamelcaseStringNoStubs() {
		iiucReal = new InconsistentIdentifierUseCheck();
		assertFalse(iiucReal.isCamelCase("NotACamelCaseString"));
		assertFalse(iiucReal.isCamelCase("A"));
		assertFalse(iiucReal.isCamelCase("hello_friend"));
	}
	
	@Test
	public void shouldReturnTrueGivenCamelcaseStringAndStubbedHasCapital() {
		doReturn(true).when(iiuc).hasCapital("aCamelCaseString");
		assertTrue(iiuc.isCamelCase("aCamelCaseString"));
		
		doReturn(false).when(iiuc).hasCapital("good");
		assertTrue(iiuc.isCamelCase("good"));
	}
	
	@Test
	public void shouldReturnTrueGivenCamelcaseStringAndNoStubs() {
		iiucReal = new InconsistentIdentifierUseCheck();
		assertTrue(iiucReal.isCamelCase("thisIsACamelCaseString"));
		
		doReturn(true).when(iiuc).hasCapital("aCamelCaseString");
		assertTrue(iiuc.isCamelCase("aCamelCaseString"));
		
		doReturn(false).when(iiuc).hasCapital("good");
		assertTrue(iiuc.isCamelCase("good"));
	}

}
