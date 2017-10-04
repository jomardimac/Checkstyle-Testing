package customChecks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import antlr.collections.AST;

public class OverloadedIdentifiers extends AbstractCheck{

	List<String> Verbs = new ArrayList<>();
	List<String> Nouns = new ArrayList<>();
	Scanner VerbScan = new Scanner("listverbs.txt");
	Scanner NounScan = new Scanner("listnouns.txt");
	
	//Put verb and noun in the list:
	private void populateLists() {
		while(VerbScan.hasNextLine()) {
			Verbs.add(VerbScan.nextLine());
		}
		while(NounScan.hasNextLine()) {
			Nouns.add(NounScan.nextLine());
		}
	}
	@Override
	public int[] getDefaultTokens() {
		// TODO Method Definitions:
		return new int[] {TokenTypes.METHOD_DEF, TokenTypes.CLASS_DEF};
	}
	
	@Override
	public void visitToken(DetailAST ast) {
		DetailAST objBlock = ast.findFirstToken(TokenTypes.METHOD_DEF);
		int VerbFlag = 0, NounFlag = 0;
		DetailAST child = (DetailAST)ast.getFirstChild();
		while(child != null) {
			
			//Real slow but easiest/fastest way (O(n)^m)) where n = list of verbs and m = length of method name:
			for(String str: Verbs) {
				//if the string in the list is inside the method name:
				if((child.getText().toLowerCase().contains(str.trim().toLowerCase()))) { //&& child.getType == method.
					NounFlag++;
				}
				if(NounFlag > 1) {
					log(ast.getLineNo(),"overloadedidentifiers");
					break;
				}
			}
			
			//Same for classes: 
			for(String str: Nouns) {
				if((child.getText().toLowerCase().contains(str.trim().toLowerCase()))){ //&& child.getType == class.
					VerbFlag++;
				}
				if(VerbFlag > 1) {
					log(ast.getLineNo(),"overloadedidentifiers");
					break;
				}
			}
			//progress in the tree:
			System.out.println("movein");
			child = (DetailAST) child.getNextSibling();
		}
	}
}
