package pgdp.warmup;

public class PenguWarmup {


	protected PenguWarmup() {
		throw new UnsupportedOperationException();
	}

	public static int penguInfoOut(int penguin) {
		// TODO
		if (penguin < 0) {
			System.out.println("Penguin " +  penguin + " is not a known penguin!");
			return 1;
		}
		System.out.println("Penguin: " + penguin);
		if (penguin % 2 == 0) {
			System.out.println("This penguin is a male.");
		}
		else {
			System.out.println("This penguin is a female.");
		}
		return 0;
	}

	public static int penguEvolution(int penguin, int years) {
		// TODO first determine type of penguin, then execute action depending whether male or female
/*
		boolean isEven;
		boolean isMultipleOf7 = false;
		boolean isHappiest = false;
		int p = 2;
		int counter = 1;
		int y = 1;
		while (y <= years) {
			//check if penguin is even or odd / is male or female
			if (penguin % 2 == 0) {
				isEven = true;
				isHappiest = false;
			} else {
				isEven = false;
			}
			if (isEven) { //pengu is male
				//check is pengu is two squared
				while (p < penguin) {
					p *= 2;
				}
				if (p == penguin) {
					penguin = 1;
				} else {
					penguin = penguin / 2;
				}
			} else { //pengu is female
				//check is pengu is a multiple of seven
				if (penguin % 7 == 0 && isHappiest == false) {
					isMultipleOf7 = true;
				} else {
					penguin = penguin * 3 + 1;
					isHappiest = false;
				}
				if (penguin == 7 && isMultipleOf7 && y <= years - 5) { //wenn pengu == 7 dann wiederhole 6 mal
					penguin = 7;
					isHappiest = true;
					y += 5;
				} else if (isMultipleOf7 && y <= years - 6) { //wenn pengu != 7 aber multibleof7 (e.g. 49) dann wiederhole 7 mal
					penguin = 7;
					isHappiest = true;
					y += 6;
				}
			}
			//System.out.println("isMultipleOf7: " + isMultipleOf7);
			//System.out.println("isHappiest: " + isHappiest);
			//System.out.println("New Pengu Nr: " + penguin + " Year: " + y);
			//System.out.println("_______");
			y++;
		}
		return penguin;
	}
	*/

		//sevenyears will be true if
		boolean sevenyears = false;
		//only penguins > 0
		if (penguin < 1) {
			return 1;
		}
		//iterate for 4 cases as many times as number of years
		for (int i = 0; i < years; i++) {
			// 1. male and not a power of 2: penguin / 2
			if (penguin % 2 == 0) {
				//1.1 power of 2: penguin = 1
				if (ispoweroftwo(penguin)) {
					penguin = 1;
				}
				//1.2 not a power of 2: penguin / 2
				else {
					penguin /= 2;
				}
			}
			// 3. female
			else {
				// 3.1 female and not a factor of 7: penguin * 3 + 1
				if (penguin % 7 != 0 || sevenyears) {
					penguin = penguin * 3 + 1;
					sevenyears = false;
				}
				//3.2 female and factor of seven: 7 for seven years, turn sevenyears true
				else {
					//penguin = 7;
					i += 5;
					sevenyears = true;
				}
			}
		}
		System.out.println(penguin);
		return penguin;
	}



	public static boolean ispoweroftwo(int num) {
		//only gets even int inputs >1
		while (num > 1) {
			if (num % 2 != 0) {
				return false;
			}
			num /= 2;
		}
		return true;
	}

	public static int penguSum(int penguin) {
		// TODO
		int sum = 0;
		while (penguin > 0) {
			sum += penguin % 10;
			penguin /= 10;
		}
		System.out.println(sum);
		return sum;
	}

	public static long penguPermutation(long n, long k) {
		//n!/k! is the same as n*(n-1)*...*(n-k+1)
		long result;
		for (result = 1; k < n; n--) {
			result *= n;
		}
		System.out.println(result);
		return result;
	}

	// TODO This does not work because long doesnt store that big of numbers
		/* long N = 1;
		long K = 1;
		//calculate n!
		for (int i = 0; i < n; n--) {
			N *= n;
		}
		for (int j = 0; j < k; k--) {
			K *= k;
		}
		System.out.println(N / K);
		return (N / K);
		 */
	public static long penguPowers(int x, int i) {
		// TODO
		long result = x;
		if (i == 0) {
			result = 1;
		}
		else {
			for (int j = 1; j < i; j++) {
				result = multiplybyx(result, x);
			}
		}
		System.out.println(result);
		return result;
	}
	public static long multiplybyx(long input, int x) {
		long result = 0;
		for (int i = 0; i < x; i++) {
			result += input;
		}
		return result;
	}

	/*	Die Inhalte der main()-Methode beeinflussen nicht die Bewertung dieser Aufgabe
	 *	(es sei denn natürlich, sie verursachen Compiler-Fehler).
	 */
	public static void main(String[] args) {
		// Here is a place for you to play around :)
		//penguInfoOut(-2323);
		System.out.println(penguEvolution(7, 7));
;
		//penguInfoOut(1);
		//System.out.println(penguEvolution(1337, 5));
		//penguSum(303);
		//penguPermutation( 6, 3);
		//penguPowers(0,0);
	}
}
