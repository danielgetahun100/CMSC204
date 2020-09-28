public class ArraySumDriver {
	private final static int ARRAY_SIZE = 10;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int index = 0;

		Integer[] myArray = new Integer[ARRAY_SIZE];
		ArraySum arraySum = new ArraySum();
		
		myArray[index++] = 3;
		myArray[index++] = 5;
		myArray[index++] = 2;
		myArray[index++] = 6;
		myArray[index++] = 9;
		myArray[index++] = 4;
		int sum = arraySum.sumOfArray(myArray, 5);
		System.out.println(sum);
		
		myArray[index++] = 7;
		myArray[index++] = 1;
		myArray[index++] = 3;
		myArray[index++] = 10;
		
		sum = arraySum.sumOfArray(myArray, 9);
		System.out.println(sum);
	}

}
