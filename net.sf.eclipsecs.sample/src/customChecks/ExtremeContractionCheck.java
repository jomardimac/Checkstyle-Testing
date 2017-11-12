//Dillon Johnson

package customChecks;

import java.util.ArrayList;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import antlr.collections.AST;

public class ExtremeContractionCheck extends AbstractCheck {
	
	//Variable holding the minimum number of chars for a var, method, class, etc...
	private int lowestAcceptableCount = 2;
	
	//getter for the lowestAcceptableCount
	public int getLowestAcceptableCount() {
		return lowestAcceptableCount;
	}
	
	//Setter to change default lowest value for user.
	public void setLowestAcceptableCount(int count) {
		if (count < 1) {
			lowestAcceptableCount = 1;
		}
		else if (count > 15) {
			lowestAcceptableCount = 15;
		}
		else {
			lowestAcceptableCount = count;
		}
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
		//Moving to the first child
		DetailAST child = (DetailAST) ast.getFirstChild();

		//Traversing the AST
		while(child != null) {
			//Debugging output
			System.out.println("text: " + child.getText() + "|" + child.getType());
			//Checking to see if the length of the token is less than the tolerable amount
			if (child.getText().length() < lowestAcceptableCount && child.getType() == 58) {
				//Logging error of type "extremecontraction" (defined within the messages.properties file), of size lowestAcceptableCount
				log(child.getLineNo(), "extremecontraction", lowestAcceptableCount);
			}
			//Progressing in the tree.
			child = (DetailAST) child.getNextSibling();
		}
	}
}