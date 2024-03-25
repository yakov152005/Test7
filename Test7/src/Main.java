public class Main {
	public static void main(String[] args) {
		Ex1();
		Ex2();
		Ex3();
		Ex4();
		Ex5();
	}

	//-------------------------------------------------------------------
	public static void Ex1() {
		int num = 123456;
		int res = itsSeriesOddAndEvenDigitOfNumber(num);
		System.out.println(res);
		int num1 = 33;
		int res1 = itsSeriesOddAndEvenDigitOfNumber(num1);
		System.out.println(res1);
	}

	public static int itsSeriesOddAndEvenDigitOfNumber(int num) {
		int res = 0;
		while (num > 0) {
			int digit = num % 10;
			if (digit % 2 == 0) {
				num /= 10;
				digit = num % 10;
				if (digit % 2 == 1) {
					num /= 10;
					res = 1;
				} else {
					res = 0;
					break;
				}
			} else {
				res = 0;
				break;
			}
		}
		return res;
	}

	//-------------------------------------------------------------------
	public static void Ex2() {
		int[] vec = {10, 4, 2, 9, 8, 7, 3, 1, 10, 12};
		int res = checkIfTheFunctionConditionsAreMet(vec);
		System.out.println(res);

		int[] vec1 = {10, 4, 2, 10, 10, 7, 3, 1, 8, 13};
		int res1 = checkIfTheFunctionConditionsAreMet(vec1);
		System.out.println(res1);
	}

	public static boolean isPositiveArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (!(arr[i] > 0)) {
				return false;
			}
		}
		return true;
	}

	public static boolean sumOfTheTermsInTheFirstHalfArrIsEqualToTheSecondHalf(int[] arr) {
		int length = arr.length;
		int half = length / 2;
		int sumFirstHalf = 0;
		int sumSecondHalf = 0;
		for (int i = 0; i < length; i++) {
			if (i < half) {
				sumFirstHalf += arr[i];
			} else {
				sumSecondHalf += arr[i];

			}
		}
		if (sumFirstHalf == sumSecondHalf) {
			return true;
		}
		return false;
	}

	public static boolean valueOfTheFirstNumberInTheArrayAppearsAtMostTwice(int[] arr) {
		int valueFirstNumber = arr[0];
		int counter = 1;
		for (int i = 1; i < arr.length; i++) {
			if (valueFirstNumber == arr[i]) {
				counter++;
				if (counter > 2) {
					return false;
				}
			}
		}
		return true;
	}

	public static int checkIfTheFunctionConditionsAreMet(int[] arr) {
		if (isPositiveArr(arr)) {
			if (sumOfTheTermsInTheFirstHalfArrIsEqualToTheSecondHalf(arr)) {
				if (valueOfTheFirstNumberInTheArrayAppearsAtMostTwice(arr)) {
					return 1;
				}
			}
		}
		return 0;
	}

	//-------------------------------------------------------------------
	public static void Ex3() {
		int[] vec = {2, 6, 8, 6, 3, 4, 5, 6, 1, 2};
		int indexSecondHighestValue = firstIndexOfTheSecondLargestValueInTheArray(vec);
		System.out.println("In index: " + indexSecondHighestValue);
	}

	public static int firstIndexOfTheSecondLargestValueInTheArray(int[] arr) {
		int highestValue = arr[0];
		int secondHighestValue = 0;
		int indexForSecondHighestValue = 0;
		for (int i = 1; i < arr.length; i++) {
			if (highestValue < arr[i]) {
				highestValue = arr[i];
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < highestValue && arr[i] > secondHighestValue) {
				secondHighestValue = arr[i];
				indexForSecondHighestValue = i;
			}
		}
		int countSecondHighest = 0;
		for (int i = 0; i < arr.length; i++) {
			if (secondHighestValue == arr[i]) {
				countSecondHighest++;
			}
		}
		System.out.println("The number repeats: " + countSecondHighest + " times");
		return indexForSecondHighestValue;
	}

	//-------------------------------------------------------------------
	public static void Ex4() {
		int[] vec = {1, 3, 4, 7, 5, 2, 3, 4, 5, 6, 7, 8, 9};
		int res = indexOfTheMaximumSequence(vec);
		System.out.println(res);
	}

	public static int indexOfTheMaximumSequence(int[] arr) {
		int maxIndex = 0;
		int currentIndex = 0;
		int countSequence = 0;
		int currentSequence = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i; j < arr.length -1; j++) {
				currentIndex = i;
				if (arr[j] < arr[j + 1]) {
					countSequence++;
				}else {
					break;
				}
			}
			if (currentSequence < countSequence) {
				currentSequence = countSequence;
				maxIndex = currentIndex;
			}
			countSequence = 0;
		}
		return maxIndex;
	}
	//-------------------------------------------------------------------
	public static void Ex5(){
		int number = 1145223452;
		printTheMostAppearDigitInTheNumber(number);
	}
	public static void printTheMostAppearDigitInTheNumber(int number){
		String mostAppearDigit = String.valueOf(number);
		String revers = "";
		for (int i = mostAppearDigit.length() -1; i > 0  ; i--) {
			revers += mostAppearDigit.charAt(i);
		}
		int currentCount = 0;
		int maxCount = 0;
		String res = "";
		for (int i = 0; i < revers.length() -1; i++) {
			for (int j = 0; j < revers.length() ; j++) {
				if (revers.charAt(i) == revers.charAt(j)) {
					currentCount++;
				}
			}
			if (currentCount > maxCount) {
				maxCount = currentCount;
				res = revers.charAt(i) + "";
			}
			currentCount = 0;
		}
		System.out.println(res);
	}

}
