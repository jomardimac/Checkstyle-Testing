package customChecks;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import antlr.collections.AST;

public class ExtremeContractionCheck extends AbstractCheck {
	
	//Variable holding the minimum number of chars for a var, method, class, etc...
	private int lowestAcceptableCount = 2;
	
	//Setter to change default lowest value for user.
	public void setLowestAcceptableCount(int count) {
		lowestAcceptableCount = count;
	}

	//Method that returns all the tokens needed for this check... Here we are looking at Classes, Interfaces, Methods, and Vars.
	@Override
	public int[] getDefaultTokens() {
		return new int[] { TokenTypes.CLASS_DEF, TokenTypes.INTERFACE_DEF,
				TokenTypes.METHOD_DEF, TokenTypes.VARIABLE_DEF};
	}
	
	//Method for behavior of check.
	@Override
	public void visitToken(DetailAST ast) {
		DetailAST child = (DetailAST) ast.getFirstChild();
		
		while(child != null) {
			if (child.getText().length() < lowestAcceptableCount) {
				log(ast.getLineNo(), "extremecontraction", 1);
			}
			child = (DetailAST) child.getNextSibling();
		}
	}
}