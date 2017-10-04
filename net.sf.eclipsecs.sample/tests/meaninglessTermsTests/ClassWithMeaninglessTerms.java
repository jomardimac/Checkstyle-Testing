package meaninglessTermsTests;

public class ClassWithMeaninglessTerms {
	public void displayMessage(String message) {
		String foo = message;
		System.out.println(foo);
	}
	
	public void subtractInt(int x) {
		int asd = x;
		asd = asd - 3;
		System.out.println(asd);
	}
}
