package customChecks;

import java.util.ArrayList;
import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import antlr.collections.AST;

public class WholePartCheck extends AbstractCheck {

	//returns the tokens for class, var, methods, interface.
	public int[] getDefaultTokens() { 
		return new int[]{TokenTypes.CLASS_DEF, TokenTypes.INTERFACE_DEF, TokenTypes.METHOD_DEF, TokenTypes.VARIABLE_DEF};
	}
	
	//Needed global variables to find out if class name is in method:
	int foundCl = 0;
	String clname = new String();
	
	public boolean subStringCheck(String a, String b) {
		if(a.toLowerCase().contains(b.toLowerCase())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//Actual check: Finding the line errors and storing it in a list.
	public ArrayList<Integer> findLinesWithErrors(DetailAST ast){
		DetailAST child = (DetailAST) ast.getFirstChild();
		ArrayList<Integer> lineNum = new ArrayList<Integer>();
		
		//go through the tree:
		while(child != null) {
			//Checks if the class is humanmade:
			if(child.getType() == 58) {
				//Flag to see if the class name is found: 
				if(foundCl == 0) {
					clname = child.getText();
					System.out.println("Class " + clname);
					foundCl = 1;
					continue;
				}
				//Checking the actual illegal name:
				if(subStringCheck(child.getText().toLowerCase(),clname.toLowerCase())) {
					lineNum.add(child.getLineNo());
				}
			}
			
			//go to the next tree:
			child = child.getNextSibling();
		}
		return lineNum;
	}
	
	///Called for each token visit.
	@Override
	public void visitToken(DetailAST ast) {											
		//calls the actual line errors:
		ArrayList<Integer> lineNumbers = findLinesWithErrors(ast);
		for(int x : lineNumbers) {
			//logging check line numbers:
			log(x, "wholepartcheck");
		}
	}
	
	//invalid checker:
	public boolean subStringCheck(int i, int j) {
		return false;
	}
	
}
