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
	
	int foundCl = 0;
	String clname = new String();
	
	@Override
	public void visitToken(DetailAST ast) {
		DetailAST objBlock = ast.findFirstToken(TokenTypes.METHOD_DEF);
		DetailAST child = (DetailAST)ast.getFirstChild();
		
		while(child != null) {
						
			//figure out when to grab the class name:
			if(child.getType() == 69 && foundCl == 0) { //child.getType() == 69 means a class is found.
				foundCl = 1;
				continue;
			}
			//the next text will be the classname:
			else if(foundCl == 1 && child.getType() == 58) {
				clname = child.getText();
				//System.out.println("class name: " + clname + "\n\n");
				foundCl = -1;
				continue;
			}
			//Check the whole tree if name contains the classname.
			if(foundCl == -1) {foundCl = -2; continue;} //for some reason the class gets called again.
			if(foundCl == -2) {
				//System.out.println("text: "+ child.getText().toLowerCase() + " type: " + child.getType());
				//The check to see if method is the class name:
				if(child.getText().toLowerCase().contains(clname.toLowerCase()) == true) {
					//System.out.println("This is false: " + child.getText());
					log(ast.getLine(),"wholepartcheck");
				}
			}
			
			//System.out.println("text: "+ child.getText().toLowerCase() + " type: " + child.getType());
			//progress in the tree:
			//System.out.println("movein");
			child = (DetailAST) child.getNextSibling();
			
		}
	}
	
}
