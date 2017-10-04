package customChecks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

public class uselessIdentifiersCheck extends AbstractCheck {

	@Override
	public int[] getDefaultTokens() {
		return new int[] {TokenTypes.CLASS_DEF, TokenTypes.INTERFACE_DEF, TokenTypes.METHOD_DEF, TokenTypes.VARIABLE_DEF};
	}
	
	@Override
	public void visitToken(DetailAST ast) {
		DetailAST child = ast.getFirstChild();
		
		//Determine the type of child, then determine if that type is within the definition name.
		while(child != null) {
			String childType; //Grab type of child.
			
		}
	}
}
