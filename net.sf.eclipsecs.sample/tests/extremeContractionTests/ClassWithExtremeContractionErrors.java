package extremeContractionTests;

import java.util.Scanner;

public class ClassWithExtremeContractionErrors {
	
	public int addFiveToInt(int base) {
		int x = 5;	//should be a check error
		return base + x;
	}

	public void printWelcomMessage() {
		System.out.println("Enter your name: ");
		Scanner s = new Scanner(System.in);
		String st = s.nextLine();
		System.out.println("Hello " + st);
	}
	
	public int returnConstant() {
		int a = 1;
		int ab = 1;
		int abc = 1;
		int abcd = 1;
		int abcde = 1;
		int abcdef = 1;
		
		return a+ab+abc+abcd+abcde+abcdef;
	}
}
