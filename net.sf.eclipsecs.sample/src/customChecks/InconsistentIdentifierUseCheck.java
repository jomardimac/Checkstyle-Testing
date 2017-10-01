package customChecks;

import java.util.ArrayList;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import antlr.collections.List;

public class InconsistentIdentifierUseCheck extends AbstractCheck {

	//Method that returns all the tokens needed for this check... Here we are looking at Variables
	@Override
	public int[] getDefaultTokens() {
		return new int[] { TokenTypes.VARIABLE_DEF};
	}
	
	//Method for behavior of check.
	@Override
	public void visitToken(DetailAST ast) {
		DetailAST child = (DetailAST) ast.getFirstChild();
		boolean lowercaseFlag = false;
		boolean uppercaseFlag = false;
		boolean camelFlag = false;
		boolean snakeFlag = false;
		boolean precedingFFlag = false;
		boolean allCapsFlag = false;
		
		//Traversing the AST
		while(child != null) {
			if (child.getType() == 58) {
				String str = child.getText();
				
				//Checking to see if the vars start with upper or lower case chars.
				if ((int)str.charAt(0) >= 97 && (int)str.charAt(0) <= 122) {
					if (uppercaseFlag) {
						log(ast.getLineNo(), "inconsistentidentifieruse");
					}
					else {
						lowercaseFlag = true;
						if (str.length() <= 1) {
							if (precedingFFlag) {
								log(ast.getLineNo(), "inconsistentidentifieruse");
							}
						}
						else if (str.charAt(0) == 'f' && (str.charAt(1) >= 65 && str.charAt(1) <= 90)) {
							precedingFFlag = true;
						}
					}
				}
				else if ((int)str.charAt(0) >= 65 && (int)str.charAt(0) <= 90) {
					if (lowercaseFlag) {
						log(ast.getLineNo(), "inconsistentidentifieruse");
					}
					else {
						//if not lowercase starting char, then uppercase
						uppercaseFlag = true;
						if (allCapsFlag) {
							for (int i = 1; i < str.length(); i++) {
								//if there is atleast one non-capitalized letter, we mark the flag as false and break
								if (!(((int)str.charAt(i) >= 65 && (int)str.charAt(i) <= 90) || str.charAt(i) == '_')) {
									log(ast.getLineNo(), "inconsistentidentifieruse");
									break;
								}
							}
						}
						else {
							//temporarily set all caps to true; then check
							allCapsFlag = true;
							for (int i = 1; i < str.length(); i++) {
								//if there is atleast one non-capitalized letter, we mark the flag as false and break
								if (!(((int)str.charAt(i) >= 65 && (int)str.charAt(i) <= 90) || str.charAt(i) == '_')) {
									allCapsFlag = false;
									break;
								}
							}
						}
					}
				}
				
				//checking for camel case
				
				//checking for snake case
			}
			//Progressing in the tree.
			System.out.println("movin");
			child = (DetailAST) child.getNextSibling();
		}
		
		
	}
}
