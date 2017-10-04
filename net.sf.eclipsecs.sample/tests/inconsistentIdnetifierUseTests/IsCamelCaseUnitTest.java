package inconsistentIdnetifierUseTests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import customChecks.InconsistentIdentifierUseCheck;

@RunWith(MockitoJUnitRunner.class)
public class IsCamelCaseUnitTest {

	@Spy
	private InconsistentIdentifierUseCheck iiuc;
	
	@Test
	public void shouldReturnFalseGivenEmptyOrNullString() {
		doReturn(false).when(iiuc).isAllLower("");
		doReturn(false).when(iiuc).hasCapital("");
		assertFalse(iiuc.isCamelCase(""));
	}
	
	@Test
	public void shouldReturnFalseGivenStringWithUnderscores() {
		doReturn(true).when(iiuc).isAllLower("hello_my_friend");
		doReturn(false).when(iiuc).hasCapital("hello_my_friend");
		assertFalse(iiuc.isCamelCase("hello_my_friend"));
		
		doReturn(false).when(iiuc).isAllLower("hello_My_Friend");
		doReturn(true).when(iiuc).hasCapital("hello_My_Friend");
		assertFalse(iiuc.isCamelCase("hello_My_Friend"));
	}
	
	@Test
	public void shouldReturnFalseGivenStringStartingWithCapital() {
		doReturn(false).when(iiuc).isAllLower("HelloThere");
		doReturn(true).when(iiuc).hasCapital("HelloThere");
		assertFalse(iiuc.isCamelCase("HelloThere"));
	}

	@Test
	public void shouldReturnTrueGivenCamelCaseString() {
		doReturn(false).when(iiuc).isAllLower("camelCaseString");
		doReturn(true).when(iiuc).hasCapital("camelCaseString");
		assertTrue(iiuc.isCamelCase("camelCaseString"));
		
		doReturn(false).when(iiuc).isAllLower("stringWithNumbers1");
		doReturn(true).when(iiuc).hasCapital("stringWithNumbers1");
		assertTrue(iiuc.isCamelCase("stringWithNumbers1"));
		
		doReturn(false).when(iiuc).isAllLower("cAmEl");
		doReturn(true).when(iiuc).hasCapital("cAmEl");
		assertTrue(iiuc.isCamelCase("cAmEl"));
	}
	
	@Test
	public void shouldReturnTrueGivenLowercaseString() {
		doReturn(true).when(iiuc).isAllLower("lowercasestring");
		doReturn(false).when(iiuc).hasCapital("lowercasestring");
		assertTrue(iiuc.isCamelCase("lowercasestring"));
		
		doReturn(true).when(iiuc).isAllLower("hellotheremynameisdillon");
		doReturn(false).when(iiuc).hasCapital("hellotheremynameisdillon");
		assertTrue(iiuc.isCamelCase("hellotheremynameisdillon"));
		
		doReturn(true).when(iiuc).isAllLower("a");
		doReturn(false).when(iiuc).hasCapital("a");
		assertTrue(iiuc.isCamelCase("a"));
	}
}
