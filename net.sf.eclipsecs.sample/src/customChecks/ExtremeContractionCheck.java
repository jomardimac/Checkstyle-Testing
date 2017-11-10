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
	
	//Extra helper method to ease testing for visitToken
	public ArrayList<Integer> findLinesWithErrors(DetailAST ast) {
		DetailAST child = (DetailAST) ast.getFirstChild();
		ArrayList<Integer> lineNumbers = new ArrayList<Integer>();
		
		//Traversing the AST
		while(child != null) {
			//Debugging output
			System.out.println("text: " + child.getText() + "|" + child.getType());
			//Checking to see if the length of the token is less than the tolerable amount
			if (child.getText().length() < lowestAcceptableCount && child.getType() == 58) {
				lineNumbers.add(child.getLineNo());
			}
			//Progressing in the tree.
			child = (DetailAST) child.getNextSibling();
		}
		
		return lineNumbers;
	}
	
	//Method for behavior of check.
	@Override
	public void visitToken(DetailAST ast) {
		//Calling helper function to get all line numbers of invalid vars
		ArrayList<Integer> lineNumbers = findLinesWithErrors(ast);
		//Adding errors to all lines that didn't meet the parameters
		for(int x : lineNumbers) {
			//Logging error of type "extremecontraction" (defined within the messages.properties file), of size lowestAcceptableCount
			log(x, "extremecontraction", lowestAcceptableCount);
		}
	}
}