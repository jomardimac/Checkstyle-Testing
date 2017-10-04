package sampleJavaFiles;

public class ClassWithInconsistentIdentifierUse {
	
	public void printBankStatement(double balance, double spent, double income) {
		System.out.println("Starting balance = " + balance);
		double fWithoutExpenses = balance + income;
		double withExpenses = balance + income - spent;
		double without_income = balance - spent;
		System.out.println("without expenses: " + fWithoutExpenses);
		System.out.println("withExpenses: " + withExpenses);
		System.out.println("without income: " + without_income);
	}

	public int addConstants() {
		int MYVAR = 1;
		int fVar = 2;
		int my_var = 3;
		int aVar = 4;
		return MYVAR + fVar + my_var + aVar;
	}
	
	public int subtractConstants() {
		int helloNumber = 1;
		int hello_num = 2;
		int niceDude = 3;
		int hello_number = 4;
		int fV = 5;
		int fVariable = 6;
		return helloNumber + hello_num + niceDude + hello_number + fV + fVariable;
	}
}
