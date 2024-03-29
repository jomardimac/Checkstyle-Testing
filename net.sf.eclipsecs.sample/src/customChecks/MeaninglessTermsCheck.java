package customChecks;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

public class MeaninglessTermsCheck extends AbstractCheck{
	
	List<String> terms = new ArrayList<>();
	
	public List<String> populateList() throws IOException {				//Populate the terms list with the terms from the text file.
		terms.add("foo");
		terms.add("var");
		terms.add("bar");
		terms.add("par");
		terms.add("param");
		terms.add("asd");
		terms.add("qwe");
		
		return terms;
	}
	
	public Boolean isPresent(String word) {
		if(terms.contains(word.toLowerCase())) {				//If the variable name is found in the list, it is a meaninglessTerm.
			return true;
		} 
		
		else {
			return false;
		}
	}

	@Override
	public int[] getDefaultTokens() {					//Standard getDefaultTokens used for every check.
		try {
			populateList();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new int[] {TokenTypes.CLASS_DEF, TokenTypes.INTERFACE_DEF,
				TokenTypes.METHOD_DEF, TokenTypes.VARIABLE_DEF};
	}
	
	@Override
	public void visitToken(DetailAST ast) {						//Called with each token visit during the check.
		DetailAST child = (DetailAST)ast.getFirstChild();
		
		while(child != null) {
			if (isPresent(child.getText()) && child.getType() == 58) {			//if the child name is within the list of bad terms, log check error.
				log(ast.getLineNo(), "meaninglessterms");
			}
			child = child.getNextSibling();											//Progress through the 'tree'.
		}
	}
}