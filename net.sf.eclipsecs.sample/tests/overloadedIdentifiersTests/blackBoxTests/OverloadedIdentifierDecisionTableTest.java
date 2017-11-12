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
	
	//SUBSTRING CHECK REPORT IS ON THE WHOLEPART SECTION - JOMAR
	@Test
	public void substringCheck() {
		assertTrue(oic.subStringCheck("StringsList", "list"));
		assertFalse(oic.subStringCheck("justTest", "Name"));
	}
	
	//Both noun and verbs will be similar in the decision table, these next four just tests validity.
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
	
	//Actual inputs in BlackBox test decision table:
	@Test
	public void isDecisionTableOI() {
		assertTrue(oic.containsNounList("dog"));
		assertTrue(oic.containsVerbsList("create"));
		assertFalse(oic.containsNounList("run"));
		assertFalse(oic.containsVerbsList("useless"));
	}
}
