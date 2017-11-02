package OverloadIdentifierTest;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.Test;



import static org.mockito.Mockito.*;

import customChecks.OverloadedIdentifiers;

public class OverloadIdentifierTest {

	private OverloadedIdentifiers oic;
	
	@Before
	public void init() {
		oic = new OverloadedIdentifiers();
	}
	
	@Test
	public void shouldReturnFalseIfMethodHasTwoVerbs() {
		
	}
	
	@Test
	public void shouldReturnFalseIfClassHasTwoNouns() {
		
	}
}
