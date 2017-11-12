package overloadedIdentifiersTests.blackBoxTests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import customChecks.OverloadedIdentifiers;

public class OverloadedIdentifierDecisionTableTest {
	private OverloadedIdentifiers oic;
	
	@Before
	public void init() {
		oic = new OverloadedIdentifiers();
		List<String> noun = oic.populateNounList();
		List<String> verb = oic.populateVerbList();
	}
	
	@Test
	public void substringCheck() {
		assertTrue(oic.subStringCheck("StringsList", "list"));
		assertFalse(oic.subStringCheck("justTest", "Name"));
	}
	
	@Test
	public void validNoun() {
		assertTrue(oic.containsNounList("dog"));
		assertTrue(oic.containsNounList("movie"));
	}
	
	@Test
	public void invalidNoun() {
		assertFalse(oic.containsNounList("run"));
		assertFalse(oic.containsNounList("create"));
	}
	
	@Test
	public void validVerb() {
		assertTrue(oic.containsVerbsList("create"));
		assertTrue(oic.containsVerbsList("merge"));
	}
	
	@Test
	public void invalidVerb() {
		assertFalse(oic.containsVerbsList("useless"));
		assertFalse(oic.containsVerbsList("words"));
	}
}
