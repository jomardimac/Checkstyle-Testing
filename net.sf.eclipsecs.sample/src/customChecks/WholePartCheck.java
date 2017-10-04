package customChecks;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import antlr.collections.AST;

public class WholePartCheck extends AbstractCheck {

	public int[] getDefaultTokens() { 
		// TODO Grab the class definitions
		return new int[]{TokenTypes.CLASS_DEF, TokenTypes.INTERFACE_DEF, TokenTypes.METHOD_DEF};
	}
	
	
	@Override
	public void visitToken(DetailAST ast) {
		DetailAST objBlock = ast.findFirstToken(TokenTypes.METHOD_DEF);
		
		DetailAST child = (DetailAST)ast.getFirstChild();
		while(child != null) {
			//check if class is a substring of method:
			//method.toLowerCase().contains(class.toLowerCase());
			if(objBlock.getText().toLowerCase().contains(child.getText().toLowerCase())) {
				//WholePart Error:
				log(ast.getLineNo(),"Ambigious or Redundant");
			}
				
			//progress in the tree:
			System.out.println("movein");
			child = (DetailAST) child.getNextSibling();
		}
	}
	
}
