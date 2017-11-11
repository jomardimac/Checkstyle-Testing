package customChecks;

import java.util.ArrayList;
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
	//Populating a string list for verbs:
	public List<String> populateVerbList() {		
		List<String> Verbs = new ArrayList<>();
		//Adding common verb terms:
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
	
	//Quick hotfix, will fix later:
	//Populating a stringlist for nouns:
	public List<String> populateNounList() {
		List<String> Nouns = new ArrayList<>();
		//common nouns:
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
	
	//Same as my other check, grabs the methods, interface, classes, and variables.
	@Override
	public int[] getDefaultTokens() {
		
		return new int[] {TokenTypes.METHOD_DEF, TokenTypes.CLASS_DEF, TokenTypes.INTERFACE_DEF, TokenTypes.VARIABLE_DEF};
	}
	
	public boolean subStringCheck(String a, String b) {
		return a.toLowerCase().contains(b.toLowerCase());
	}
	
	public ArrayList<Integer> findLinesWithErrors(DetailAST ast){
		DetailAST child = (DetailAST) ast.getFirstChild();
		ArrayList<Integer> lineNum = new ArrayList<Integer>();
		List<String> Verbs = this.populateVerbList();
		List<String> Nouns = this.populateNounList();
		while(child != null) {
			//Real slow but easiest/fastest way (O(n)^m)) where n = list of nouns and m = length of method name:
			for(String str: Nouns) {
				//if the string in the list is inside the method name:
				if((child.getText().toLowerCase().contains(str.trim().toLowerCase()))) { //&& child.getType == method.
					NounFlag++;
				}
				else if(NounFlag == 1) {
					lineNum.add(child.getLineNo());
					NounFlag = 0;
				}
			}
			//Same for verbs: 
			for(String str: Verbs) {
				if((child.getText().toLowerCase().contains(str.trim().toLowerCase()))){ //&& child.getType == class.
					VerbFlag++;
				}
				if(VerbFlag == 1) {
					//System.out.print("Verbs: " + str);
					lineNum.add(child.getLineNo());
					VerbFlag = 0;
				}
				//System.out.print("Verbs: " + str);
			}
			//progress in the tree:
			//System.out.println("movein" + System.getProperty("user.dir"));
			child = (DetailAST) child.getNextSibling();
		}
		return lineNum;
	}
	int VerbFlag = 0, NounFlag = 0;
	@Override
	public void visitToken(DetailAST ast) {
		ArrayList<Integer> lineNumbers = findLinesWithErrors(ast);
		for(int x : lineNumbers) {
			log(x, "overloadedidentifiers");
		}
	}
}
