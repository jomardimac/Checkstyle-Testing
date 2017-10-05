package customChecks;

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
	
	//No other functions implemented: 
	
	@Override
	public void visitToken(DetailAST ast) {											//Called for each token visit.
		DetailAST child = ast.getFirstChild();
		
		//Determine the type of child, then determine if that type is within the definition name.
		/*
		 * //figure out when to grab the class name:
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
					System.out.println("This is false: " + child.getText());
					log(ast.getLine(),"wholepartcheck");
				}
			}
			
			//System.out.println("text: "+ child.getText().toLowerCase() + " type: " + child.getType());
			//progress in the tree:
			//System.out.println("movein");
		 */
		while(child != null) {
			//checks to see if its a human made type:
			if(child.getType() == 58) {
				//check to see if class name is found, if it is, store it.
				if(foundCl == 0) {
					clname = child.getText();
					System.out.println("Class " + clname);
					foundCl = 1;
					continue;
				}
				//the actual illegal name:
				if(child.getText().toLowerCase().contains(clname.toLowerCase())) {
					System.out.println("illegal " + clname);
					log(ast.getLineNo(), "wholepartcheck");
				}
				
				//System.out.println("text: "+child.getText() + " Type: " + child.getType());
			}
			
			
			//System.out.println("text: "+child.getText() + " Type: " + child.getType());
			child = child.getNextSibling();									//Progress child to next child in the 'tree'.
			
		}
	}
	
}
