package practice;



public class SortDescending {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inputArray = new int[] {3,65};
		
	    int[] multiples = new int [inputArray.length-1];
	    for (int i =0; i < inputArray.length-1; i++) {
	        multiples[i] = inputArray[i] * inputArray[i+1];
	    }
		
		
		int[] AscSorted = AscBubbleSort (inputArray);
		System.out.println("AscSorted: ");
		PrintArray(AscSorted);
		
		int[] DescSorted = DescBubbleSort (inputArray);
		System.out.println("DescSorted: ");
		PrintArray(DescSorted);
		

		
		
		
		

	}
	
	public static int[] AscBubbleSort (int[] inputArray) {
		int j = 0;
	      int tmp;
	      boolean sorted = false;
	      while (!sorted) {
	         sorted = true;
	         j++;
	         for (int i = 0; i < inputArray.length-j; i++) {
	            if (inputArray[i] > inputArray[i + 1]) {
	               tmp = inputArray[i];
	               inputArray[i] = inputArray[i + 1];
	               inputArray[i + 1] = tmp;
	               sorted = false;
	            }
	         }
		
	      }
	      return inputArray;
	}
	
	public static int[] DescBubbleSort (int[] inputArray) {
		int j = 0;
	      int tmp;
	      boolean sorted = false;
	      while (!sorted) {
	         sorted = true;
	         j++;
	         for (int i = 0; i < inputArray.length - j; i++) {
	            if (inputArray[i+1] > inputArray[i]) {
	               tmp = inputArray[i];
	               inputArray[i] = inputArray[i + 1];
	               inputArray[i + 1] = tmp;
	               sorted = false;
	            }
	         }
		
	      }
	      return inputArray;
	}
	
	
	private static void PrintArray(int[] inputArray) {
		// TODO Auto-generated method stub
		for (int i=0; i<inputArray.length; i++) {
			System.out.print(inputArray[i]+", ");
		}

	}

}
