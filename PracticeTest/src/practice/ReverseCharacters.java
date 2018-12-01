package practice;

import java.util.Scanner;

public class ReverseCharacters {
	static String result = "";
	
	public static void main (String [] args) {
		mainprogram();
	}


	public static void mainprogram() {
		// TODO Auto-generated method stub
		System.out.println("String Reversal Tool");
		System.out.println("Choose Method: ");
		System.out.println("1. Using Loops");
		System.out.println("2. Using Recursion");
		
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter choice: ");
		int choice = sc.nextInt();
		sc.nextLine();
		System.out.println("Input text: ");
		String input = sc.nextLine();
		
		String result = "";
		
		long startTime = System.nanoTime();
		
		if (choice == 1) {
			result = Reverseloop(input);
		}
		
		if (choice == 2) {
			result = ReverseRecursion(input);
		}
		
		long endTime = System.nanoTime();
		
		
		System.out.println(result);
		System.out.println("Took "+(endTime - startTime) + " ms");
		
		System.out.println("Run Another?");
		System.out.println("Y for Yes");
		System.out.println("N for No");

		input = sc.nextLine();
		
		if (input.equals("Y")) {
			 mainprogram();
		}
		
		else if (input.equals("N")) {
			sc.close();
			System.exit(0);
		}
		

	}
	
	
	private static String Reverseloop (String input) {
		

		for (int i = 0; i<input.length(); i++) {
			result = input.charAt(i)+result;
		}
		return result;
		
	}
	
	private static String ReverseRecursion (String input) {

		if (input.length()==0) {
//			String tempResult = result;
//			result = "";
			return result;
		}
		
		if (input.length()>0) {
			result = input.charAt(0) + result;
			input = input.substring(1);
			return ReverseRecursion (input);
		}
		
		return null;

	}

}
