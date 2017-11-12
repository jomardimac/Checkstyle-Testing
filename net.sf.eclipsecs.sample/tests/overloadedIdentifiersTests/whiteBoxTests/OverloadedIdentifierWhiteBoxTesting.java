package overloadedIdentifiersTests.whiteBoxTests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.easymock.PowerMock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.puppycrawl.tools.checkstyle.api.DetailAST;


import customChecks.OverloadedIdentifiers;

public class OverloadedIdentifierWhiteBoxTesting {
	private DetailAST ast;
	private OverloadedIdentifiers oic;
	
	//Set up the test:
	@Before
	public void init() {
		oic = new OverloadedIdentifiers();
		List<String> noun = oic.populateNounList();
		List<String> verb = oic.populateVerbList();
	}
	
	@Before
	public void setupMock() {
		PowerMock.mockStatic(DetailAST.class);
		ast = PowerMock.createMock(DetailAST.class);
	}
	
	//All cases for Nouns:
	@Test
	public void validInvalidAllCaseNoun() {
		assertTrue(oic.containsNounList("dog"));
		assertFalse(oic.containsNounList("run"));
	}
	
	//All cases for Verbs:
	@Test
	public void validInvalidAllCaseVerb() {
		assertTrue(oic.containsVerbsList("create"));
		assertFalse(oic.containsVerbsList("words"));
	}
	@Test
	public void isOverloaded() {
		//First line:
		EasyMock.expect(ast.getLineNo()).andReturn(-1);
		//MAN MADE! Should be expecting 58
		EasyMock.expect(ast.getType()).andReturn(58);
	}
}
