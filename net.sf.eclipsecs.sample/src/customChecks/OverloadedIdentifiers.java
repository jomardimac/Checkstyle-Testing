package customChecks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import antlr.collections.AST;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class OverloadedIdentifiers extends AbstractCheck{

	File testFile = new File("");
	String curPath = testFile.getAbsolutePath();
	
	//DOESNT WORK FOR NOW:
	/*private void populateVerbs(String filename) throws FileNotFoundException {
		try (BufferedReader br = new BufferedReader(new FileReader(filename)))
        {
            String str;
            while ((str = br.readLine()) != null) {
                Verbs.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 

		
	}*/
	
	//Quick hotfix, will fix later:
	List<String> Verbs = new ArrayList<>();
	public List<String> populateVerbList() {		
		Verbs.add("do");
		Verbs.add("create");
		Verbs.add("test");
		Verbs.add("implement");
		Verbs.add("return");
		Verbs.add("develop");
		Verbs.add("merge");
		Verbs.add("enforce");
		Verbs.add("build");
		Verbs.add("arrange");
		Verbs.add("explain");
		Verbs.add("join");
		Verbs.add("propose");
		
		return Verbs;		
	}
	List<String> Nouns = new ArrayList<>();
	//Quick hotfix, will fix later:
	public List<String> populateNounList() {
		
		
		Nouns.add("dog");
		Nouns.add("cat");
		Nouns.add("movie");
		Nouns.add("train");
		Nouns.add("bed");
		Nouns.add("rice");
		Nouns.add("snow");
		Nouns.add("rain");
		Nouns.add("water");
		
		return Nouns;
	}
	//Put verb and noun in the list:
	@Override
	public int[] getDefaultTokens() {
		
		return new int[] {TokenTypes.METHOD_DEF, TokenTypes.CLASS_DEF, TokenTypes.INTERFACE_DEF, TokenTypes.VARIABLE_DEF};
	}
	
	@Override
	public void visitToken(DetailAST ast) {
		DetailAST objBlock = ast.findFirstToken(TokenTypes.METHOD_DEF);
		int VerbFlag = 0, NounFlag = 0;
		DetailAST child = (DetailAST)ast.getFirstChild();
		
		//populate verbs:
		/*try {
			populateVerbs("verbs.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*try {
			populateVerbs("listverbs.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		while(child != null) {
			
			//Real slow but easiest/fastest way (O(n)^m)) where n = list of verbs and m = length of method name:
			for(String str: Nouns) {
				//if the string in the list is inside the method name:
				if((child.getText().toLowerCase().contains(str.trim().toLowerCase()))) { //&& child.getType == method.
					NounFlag++;
					
				}
				if(NounFlag > 1) {
					log(ast.getLineNo(),"overloadedidentifiers");
					NounFlag = 0;
					System.out.print("Noun: " + str);
					continue;
				}
			}
			
			//Same for classes: 
			for(String str: Verbs) {
				if((child.getText().toLowerCase().contains(str.trim().toLowerCase()))){ //&& child.getType == class.
					VerbFlag++;
				}
				if(VerbFlag > 1) {
					System.out.print("Noun: " + str);
					log(ast.getLineNo(),"overloadedidentifiers");
					VerbFlag = 0;
					continue;
				}
			}
			//progress in the tree:
			//System.out.println("movein" + System.getProperty("user.dir"));
			
			child = (DetailAST) child.getNextSibling();
		}
		
	}
}
