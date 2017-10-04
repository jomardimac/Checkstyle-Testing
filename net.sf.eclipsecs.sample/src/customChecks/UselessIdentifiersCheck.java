package customChecks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

public class UselessIdentifiersCheck extends AbstractCheck {

	List<String> illegalWords = new ArrayList<>();
	
	public void populateList() {
		illegalWords.add("String");
		illegalWords.add("int");
		illegalWords.add("double");
		illegalWords.add("float");
		illegalWords.add("List");
		illegalWords.add("set");
		illegalWords.add("char");
		illegalWords.add("final");
		illegalWords.add("static");
	}
	
	
	@Override
	public int[] getDefaultTokens() {
		populateList();
		return new int[] {TokenTypes.CLASS_DEF, TokenTypes.INTERFACE_DEF, TokenTypes.METHOD_DEF, TokenTypes.VARIABLE_DEF};
	}
	
	@Override
	public void visitToken(DetailAST ast) {
		DetailAST child = ast.getFirstChild();
		
		//Determine the type of child, then determine if that type is within the definition name.
		while(child != null) {
			for(String i : illegalWords) {
				if (child.getText().toLowerCase().contains(i.toLowerCase())) {
					log(ast.getLineNo(), "uselessIdentifiers");
				}
			}
			
			child = child.getNextSibling();
			
		}
	}
}
