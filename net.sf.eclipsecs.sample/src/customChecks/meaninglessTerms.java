package customChecks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

public class meaninglessTermsCheck extends AbstractCheck{
	
	List<String> terms = new ArrayList<>();
	Scanner scanner = new Scanner("meaninglessTerms.txt");
	
	private void populateList() {				//Populate the terms list with the terms from the text file.
		while(scanner.hasNextLine()) {
			terms.add(scanner.nextLine());
		}
	}

	@Override
	public int[] getDefaultTokens() {
		return new int[] {TokenTypes.CLASS_DEF, TokenTypes.INTERFACE_DEF,
				TokenTypes.METHOD_DEF};
	}
	
	@Override
	public void visitToken(DetailAST ast) {
		DetailAST objBlock = ast.findFirstToken(TokenTypes.METHOD_DEF);
		
		DetailAST child = (DetailAST)ast.getFirstChild();
		while(child != null) {
			if (terms.contains(child.getText())) {
				//log the error.
			}
		}
	}
	
}