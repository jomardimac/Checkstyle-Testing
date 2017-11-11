//Dillon Johnson

package extremeContractionTests.blackBoxTests;

import static org.junit.Assert.*;
import java.util.Random;

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

import customChecks.ExtremeContractionCheck;

//Input for the findLinesWithErrors method can be partitioned into 2 classes
//Class 1: AST is invalid	(has line number(s) < 0)
//Class 2: AST is valid		(does not contain negative line numbers)

@Ignore
@RunWith(PowerMockRunner.class)
@PrepareForTest(DetailAST.class)
public class FindLinesWithErrorsEquivalenceClassPartitioningTest {

	private DetailAST ast;
	private ExtremeContractionCheck ecc;
	
	@Before
	public void init() {
		ecc = new ExtremeContractionCheck();
	}
	
	@Before
	public void setupMock() {
		PowerMock.mockStatic(DetailAST.class);
		ast = PowerMock.createMock(DetailAST.class);
	}
	
	//Class 1
	@Test
	public void shouldReturnNullGivenInvalidLineNumber() {
		EasyMock.expect(ast.getLineNo()).andReturn(-1);
		EasyMock.expect(ast.getFirstChild()).andReturn(ast);
		EasyMock.expect(ast.getNextSibling()).andReturn(null);
		EasyMock.expect(ast.getText()).andReturn("a");
		EasyMock.expect(ast.getType()).andReturn(58);
		PowerMock.replayAll();
		
		assertNull(ecc.findLinesWithErrors(ast));
	}
}
