package ExtremeContractionTests;

import java.util.Scanner;

public class TestClassWithErrors {
	
	public static void main(String[] args) {
		System.out.println("Hello World");
		System.out.println("Entering getSum with num1 = 5, num2 = 7...");
		getSum(5,7);
		System.out.println("Entering getUserInputAndPrintToScreen...");
		getUserInputAndPrintToScreen();
		System.out.println("End of Program.");
	}
	
	public void foo() {
		//this is a comment
	}
	
	public static int getSum (int num1, int num2) {
		int sum = 0;
		int notSum = 5;
		sum += num1;
		sum += num2;
		sum += notSum;
		sum -= notSum;
		return sum;
	}
	
	public static void getUserInputAndPrintToScreen() {
		String s;
		s = "";
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter something:");
		s = sc.nextLine();
		System.out.println(s);
		sc.close();
	}
}
