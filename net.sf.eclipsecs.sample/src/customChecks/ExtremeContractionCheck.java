package customChecks;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import antlr.collections.AST;

public class ExtremeContractionCheck extends AbstractCheck {
	
	private int lowestAcceptableCount = 2;
	
	public void setLowestAcceptableCount(int count) {
		lowestAcceptableCount = count;
	}

	@Override
	public int[] getDefaultTokens() {
		return new int[] { TokenTypes.CLASS_DEF, TokenTypes.INTERFACE_DEF,
				TokenTypes.METHOD_DEF};
	}
	
	@Override
	public void visitToken(DetailAST ast) {
		DetailAST objBlock = ast.findFirstToken(TokenTypes.METHOD_DEF);
		
		log(ast.getLineNo(), "extremecontraction", 1);
		
		DetailAST child = (DetailAST) ast.getFirstChild();
		while(child != null) {
			if (child.getText().length() < lowestAcceptableCount) {
				log(ast.getLineNo(), "extremecontraction", 1);
			}
			child = (DetailAST) child.getNextSibling();
		}
	}
}