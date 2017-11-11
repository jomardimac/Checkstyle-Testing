package wholePartCheckTests.whiteBoxTests;

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

import customChecks.WholePartCheck;

//@Ignore
@RunWith(PowerMockRunner.class)
@PrepareForTest(DetailAST.class)
public class WholePartCheckWhiteBoxTesting {
	private WholePartCheck wpc;
	private DetailAST ast;
	
	@Before
	public void init() {
		wpc = new WholePartCheck();
	}
	
	@Before
	public void setupMock() {
		PowerMock.mockStatic(DetailAST.class);
		ast = PowerMock.createMock(DetailAST.class);
	}
	
	//Goes through the whitebox testing method of checking if a wholepart is correct:
	@Test
	public void subStringTest() {
		assertTrue(wpc.subStringCheck("StringList", "String"));
		assertFalse(wpc.subStringCheck("notSubString", "wholepart"));
	}
	
	//Goes through the tree that finds the wholepart:
	@Test
	public void isWholePart() {
		
		//first line
		EasyMock.expect(ast.getLineNo()).andReturn(-1);
		//MAN MADE! Should be expecting 58
		EasyMock.expect(ast.getType()).andReturn(58);
	}
	
}
