package net.sf.eclipsecs.sample.deliverableThreeTests;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.api.mockito.PowerMockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;

import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.FileText;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import net.sf.eclipsecs.sample.checks.ExpressionNumberCheck;


import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * The class <code>ExpressionNumberCheckTest</code> contains tests for the class <code>{@link ExpressionNumberCheck}</code>.
 *
 * @generatedBy CodePro at 12/10/17 4:58 PM
 * @author Dillon Johnson
 * @version $Revision: 1.0 $
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(DetailAST.class)
public class ExpressionNumberCheckTest {
	/**
	 * Run the ExpressionNumberCheck() constructor test.
	 *
	 * @generatedBy CodePro at 12/10/17 4:58 PM
	 */
	@Test
	public void testExpressionNumberCheck_1()
		throws Exception {
		ExpressionNumberCheck result = new ExpressionNumberCheck();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the int[] getDefaultTokens() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/10/17 4:58 PM
	 */
	@Test
	public void testGetDefaultTokens_1()
		throws Exception {
		ExpressionNumberCheck fixture = new ExpressionNumberCheck();
		fixture.setMax(1);

		int[] result = fixture.getDefaultTokens();

		// add additional test code here
		assertNotNull(result);
		assertEquals(2, result.length);
		assertEquals(14, result[0]);
		assertEquals(15, result[1]);
	}

	/**
	 * Run the int getDetailASTsForTypeInBranch(DetailAST,int,List<DetailAST>,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/10/17 4:58 PM
	 */
	@Test
	public void testGetDetailASTsForTypeInBranch_1()
		throws Exception {
		int tokenType = TokenTypes.EXPR;
		DetailAST ast = PowerMock.createMock(DetailAST.class);
		List<DetailAST> list = spy(new ArrayList<DetailAST>());
		list.add(ast);
		boolean unique = true;

		int result = ExpressionNumberCheck.getDetailASTsForTypeInBranch(ast, tokenType, list, unique);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.nio.charset.IllegalCharsetNameException: 
		//       at java.nio.charset.Charset.checkName(Unknown Source)
		//       at java.nio.charset.Charset.lookup2(Unknown Source)
		//       at java.nio.charset.Charset.lookup(Unknown Source)
		//       at java.nio.charset.Charset.forName(Unknown Source)
		//       at com.puppycrawl.tools.checkstyle.api.FileText.<init>(FileText.java:118)
		assertEquals(0, result);
	}

	/**
	 * Run the int getDetailASTsForTypeInBranch(DetailAST,int,List<DetailAST>,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/10/17 4:58 PM
	 */
	/*
	@Test
	public void testGetDetailASTsForTypeInBranch_2()
		throws Exception {
		DetailAST expr = new DetailAST();
		int tokenType = 1;
		List<DetailAST> list = new FileText(new File(""), "");
		boolean unique = true;

		int result = ExpressionNumberCheck.getDetailASTsForTypeInBranch(expr, tokenType, list, unique);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.nio.charset.IllegalCharsetNameException: 
		//       at java.nio.charset.Charset.checkName(Unknown Source)
		//       at java.nio.charset.Charset.lookup2(Unknown Source)
		//       at java.nio.charset.Charset.lookup(Unknown Source)
		//       at java.nio.charset.Charset.forName(Unknown Source)
		//       at com.puppycrawl.tools.checkstyle.api.FileText.<init>(FileText.java:118)
		assertEquals(0, result);
	}

	/**
	 * Run the int getDetailASTsForTypeInBranch(DetailAST,int,List<DetailAST>,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/10/17 4:58 PM
	 */
	@Test
	public void testGetDetailASTsForTypeInBranch_3()
		throws Exception {
		DetailAST expr = new DetailAST();
		int tokenType = 1;
		List<DetailAST> list = null;
		boolean unique = true;

		int result = ExpressionNumberCheck.getDetailASTsForTypeInBranch(expr, tokenType, list, unique);

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int getDetailASTsForTypeInBranch(DetailAST,int,List<DetailAST>,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/10/17 4:58 PM
	 */
	@Test
	public void testGetDetailASTsForTypeInBranch_4()
		throws Exception {
		DetailAST expr = new DetailAST();
		int tokenType = 1;
		List<DetailAST> list = null;
		boolean unique = false;

		int result = ExpressionNumberCheck.getDetailASTsForTypeInBranch(expr, tokenType, list, unique);

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int getDetailASTsForTypeInBranch(DetailAST,int,List<DetailAST>,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/10/17 4:58 PM
	 */
	/*
	@Test
	public void testGetDetailASTsForTypeInBranch_5()
		throws Exception {
		DetailAST expr = new DetailAST();
		int tokenType = 1;
		List<DetailAST> list = new FileText(new File(""), "");
		boolean unique = true;

		int result = ExpressionNumberCheck.getDetailASTsForTypeInBranch(expr, tokenType, list, unique);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.nio.charset.IllegalCharsetNameException: 
		//       at java.nio.charset.Charset.checkName(Unknown Source)
		//       at java.nio.charset.Charset.lookup2(Unknown Source)
		//       at java.nio.charset.Charset.lookup(Unknown Source)
		//       at java.nio.charset.Charset.forName(Unknown Source)
		//       at com.puppycrawl.tools.checkstyle.api.FileText.<init>(FileText.java:118)
		assertEquals(0, result);
	}

	/**
	 * Run the int getDetailASTsForTypeInBranch(DetailAST,int,List<DetailAST>,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/10/17 4:58 PM
	 */
	/*
	@Test
	public void testGetDetailASTsForTypeInBranch_6()
		throws Exception {
		DetailAST expr = new DetailAST();
		int tokenType = 1;
		List<DetailAST> list = new FileText(new File(""), "");
		boolean unique = true;

		int result = ExpressionNumberCheck.getDetailASTsForTypeInBranch(expr, tokenType, list, unique);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.nio.charset.IllegalCharsetNameException: 
		//       at java.nio.charset.Charset.checkName(Unknown Source)
		//       at java.nio.charset.Charset.lookup2(Unknown Source)
		//       at java.nio.charset.Charset.lookup(Unknown Source)
		//       at java.nio.charset.Charset.forName(Unknown Source)
		//       at com.puppycrawl.tools.checkstyle.api.FileText.<init>(FileText.java:118)
		assertEquals(0, result);
	}

	/**
	 * Run the void setMax(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/10/17 4:58 PM
	 */
	@Test
	public void testSetMax_1()
		throws Exception {
		ExpressionNumberCheck fixture = new ExpressionNumberCheck();
		fixture.setMax(1);
		int limit = 1;

		fixture.setMax(limit);

		// add additional test code here
	}

	/**
	 * Run the void visitToken(DetailAST) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/10/17 4:58 PM
	 */
	/*@Test
	public void testVisitToken_1()
		throws Exception {
		ExpressionNumberCheck fixture = new ExpressionNumberCheck();
		fixture.setMax(1);
		DetailAST ast = new DetailAST();

		fixture.visitToken(ast);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at net.sf.eclipsecs.sample.checks.ExpressionNumberCheck.getDetailASTsForTypeInBranch(ExpressionNumberCheck.java:44)
		//       at net.sf.eclipsecs.sample.checks.ExpressionNumberCheck.visitToken(ExpressionNumberCheck.java:25)
	}*/

	/**
	 * Run the void visitToken(DetailAST) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/10/17 4:58 PM
	 */
	/*@Test
	public void testVisitToken_2()
		throws Exception {
		ExpressionNumberCheck fixture = new ExpressionNumberCheck();
		fixture.setMax(1);
		DetailAST ast = new DetailAST();

		fixture.visitToken(ast);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at net.sf.eclipsecs.sample.checks.ExpressionNumberCheck.getDetailASTsForTypeInBranch(ExpressionNumberCheck.java:44)
		//       at net.sf.eclipsecs.sample.checks.ExpressionNumberCheck.visitToken(ExpressionNumberCheck.java:25)
	}*/

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 12/10/17 4:58 PM
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 12/10/17 4:58 PM
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 12/10/17 4:58 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(ExpressionNumberCheckTest.class);
	}
}