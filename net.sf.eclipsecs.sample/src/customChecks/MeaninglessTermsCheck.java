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
	
	private void populateList() throws IOException {				//Populate the terms list with the terms from the text file.
		terms.add("foo");
		terms.add("var");
		terms.add("bar");
		terms.add("par");
		terms.add("param");
		terms.add("asd");
		terms.add("qwe");
	}

	@Override
	public int[] getDefaultTokens() {
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
	public void visitToken(DetailAST ast) {	
		DetailAST child = (DetailAST)ast.getFirstChild();
		for (String i : terms) {
			System.out.println("Term: " + i);
		}
		while(child != null) {

			System.out.println("text: " + child.getText() + " | " + child.getType());
			if (terms.contains(child.getText()) && child.getType() == 58) {
				log(ast.getLineNo(), "meaninglessterms");
			}
			child = child.getNextSibling();
		}
	}
}