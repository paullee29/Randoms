package practice;

public class FizzBuzz {
	
	public static void checker (int i) {
		if ((i % 5 == 0) && (i % 3 ==0))
			System.out.println("FizzBuzz");
		else if (i % 5 == 0)
			System.out.println("Buzz");
		else if (i%3 == 0)
			System.out.println("Fizz");
		else
			System.out.println(i);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 100; i++) {
			checker (i);
		}

	}

}
