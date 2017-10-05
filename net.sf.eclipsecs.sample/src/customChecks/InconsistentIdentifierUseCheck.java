package customChecks;

import java.util.ArrayList;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import antlr.collections.List;

public class InconsistentIdentifierUseCheck extends AbstractCheck {
	
	private static final int CAMEL_CASE = 1;
	private static final int SNAKE_CASE = 2;
	private static final int PRECEDING_F = 3;
	private static final int ALL_CAPS = 4;

	private int identifier = 0;

	//Method that returns all the tokens needed for this check... Here we are looking at Variables
	@Override
	public int[] getDefaultTokens() {
		return new int[] { TokenTypes.VARIABLE_DEF};
	}
	
	//method to check if the given string contains no uppercase vars
	public boolean isAllLower(String var) {
		if (var == null || var.isEmpty()) {
			return false;
		}
		for (int i = 0; i < var.length(); i++) {
			if (var.charAt(i) >= 65 && var.charAt(i) <= 90) {
				return false;
			}
		}
		return true;
	}
	
	//method to check if the passed string has any uppercase vars
	public boolean hasCapital(String var) {
		if (var == null || var.isEmpty()) {
			return false;
		}
		for (int i = 0; i < var.length(); i++) {
			if (var.charAt(i) >= 65 && var.charAt(i) <= 90) {
				return true;
			}
		}
		return false;
	}
	
	//method to check if the passed string is in camelcase
	public boolean isCamelCase(String var) {
		if (var == null || var.isEmpty()) {
			return false;
		}
		if (isAllLower(var) && !var.contains("_")) {
			return true;
		}
		//checking to see if the first letter is lowercase, it has a capital, and no underscores
		if ((var.charAt(0) >= 97 && var.charAt(0) <= 122) && hasCapital(var) && !var.contains("_")) {
			return true;
		}
		return false;
	}
	
	//method to check if the passed in string is in snake case
	public boolean isSnakeCase(String var) {
		if (var == null || var.isEmpty()) {
			return false;
		}
		//making sure that the variable is atleast 3 chars. "A_B",
		//and contains a non starting or ending underscore
		if (var.length() > 2 && var.substring(1, var.length() - 1).contains("_")) {
			return true;
		}
		return false;
	}
	
	//method to check if the passed in string has a preceding f in the variable name
	public boolean hasPrecedingF(String var) {
		if (var == null || var.isEmpty() || var.length() < 2) {
			return false;
		}
		if (var.charAt(0) == 'f' && (var.charAt(1) >= 65 && var.charAt(1) <= 90)) {
			return true;
		}
		return false;
	}
	
	//Method to check if the passed in string has no lowercase letters
	public boolean isAllCaps(String var) {
		if (var == null || var.isEmpty()) {
			return false;
		}
		for (int i = 0; i < var.length(); i++) {
			if (var.charAt(i) >= 97 && var.charAt(i) <= 122) {
				return false;
			}
		}
		return true;
	}
	
	//returns the identifier type (int) of the passed in string, this correlates to a case
	public int findIndentifierType(String var) {
		if (hasPrecedingF(var)) {
			return 3;
		}
		if (isCamelCase(var)) {
			return 1;
		}
		if (isSnakeCase(var)) {
			return 2;
		}
		if (isAllCaps(var)) {
			return 4;
		}
		//No identifier found, moving to next var for default
		return 0;
	}
	
	//Method for behavior of check.
	@Override
	public void visitToken(DetailAST ast) {
		DetailAST child = (DetailAST) ast.getFirstChild();
		
		//Traversing the AST
		while(child != null) {
			if (child.getType() == 58) {
				String str = child.getText();
				
				switch(identifier) {
					case 0:
						identifier = findIndentifierType(str);
						System.out.println("ident now: " + identifier);
						break;
					case 1:
						if (!isCamelCase(str)) {
							log(ast.getLineNo(), "inconsistentidentifieruse");
						}
						break;
					case 2:
						if (!isSnakeCase(str)) {
							log(ast.getLineNo(), "inconsistentidentifieruse");
						}
						break;
					case 3:
						if (!hasPrecedingF(str)) {
							log(ast.getLineNo(), "inconsistentidentifieruse");
						}
						break;
					case 4:
						if (!isAllCaps(str)) {
							log(ast.getLineNo(), "inconsistentidentifieruse");
						}
						break;
				}
			}
			//Progressing in the tree.
			System.out.println("movin");
			child = (DetailAST) child.getNextSibling();
		}
		
		
	}
}
