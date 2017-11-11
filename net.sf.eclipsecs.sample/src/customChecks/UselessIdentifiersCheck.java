package customChecks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

public class UselessIdentifiersCheck extends AbstractCheck {

	List<String> illegalWords = new ArrayList<>();
	
	public List<String> populateList() {					//Create a list of terms that are not allowed in names.
		illegalWords.add("String");
		illegalWords.add("int");
		illegalWords.add("double");
		illegalWords.add("float");
		illegalWords.add("List");
		illegalWords.add("set");
		illegalWords.add("char");
		illegalWords.add("final");
		illegalWords.add("static");
		
		return illegalWords;
	}
	
	public boolean substringFound (String bigString, String subString) {				//Determines if subString is a sub string of bigString and returns the bool answer.
		if (bigString.contains(subString)) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	public boolean isInList(String currWord) {
		for(String i : illegalWords) {
			if (substringFound(currWord.toLowerCase(), i.toLowerCase())) {
				return true;
			}
		}
		return false;
	}
	
	
	@Override
	public int[] getDefaultTokens() {												//Standard getDefaultTokens() used for each check.
		populateList();
		return new int[] {TokenTypes.CLASS_DEF, TokenTypes.INTERFACE_DEF, TokenTypes.METHOD_DEF, TokenTypes.VARIABLE_DEF};
	}
	
	@Override
	public void visitToken(DetailAST ast) {											//Called for each token visit.
		DetailAST child = ast.getFirstChild();
		
		//Determine the type of child, then determine if that type is within the definition name.
		while(child != null) {
			if (isInList(child.getText())) {
				log(ast.getLineNo(), "uselessIdentifiers");
			}
			
			child = child.getNextSibling();									//Progress child to next child in the 'tree'.
			
		}
	}
}
