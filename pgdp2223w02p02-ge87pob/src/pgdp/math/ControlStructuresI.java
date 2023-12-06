package pgdp.math;

public class ControlStructuresI {

	public static void main(String[] args) {
	    // Für Experimente und für's Testen der Funktionen
		printCollatz(25);
		//printPowersOfTwoUpTo(4);
		//printTriangle(1000);
		//calculateNumberOfDigits(2147483647);
		//int n = 2;
		//int k = ++n;
		//System.out.println(n + ", " + k);
		//reverseNumber(112);
		//System.out.print(isPalindrome(0));
	}

	public static void printCollatz(int n) {
		// TODO
		int laenge = 0;
		if (n > 0) {
			while (n != 1)
				if (n % 2 == 0) {
					System.out.print(n + " ");
					n = n / 2;
					laenge++;
				} else {
					System.out.print(n + " ");
					n = 3 * n + 1;
					laenge++;
				}
			if (n == 1){
				laenge++;
				System.out.println("1");
			}
			System.out.println("Länge: " + laenge);
		}
		else {
			System.out.println("Eingabe muss größer als 0 sein!");
		}

	}

	public static void printPowersOfTwoUpTo(int n) {
		// TODO
		if (n <= 0){
			System.out.println("Eingabe muss größer als 0 sein!");
		}
		else {
			int x = 1;
			System.out.print(x);
			x++;
			while (x <= n) {
				System.out.print(" " + x);
				x = x*2;
			}
			System.out.println();
		}

	}

	public static void printTriangle(int sideLength) {
		// TODO
		if (sideLength <= 0) {
			System.out.println("Eingabe muss größer als 0 sein!");
		}
		else {
			int x = sideLength;
			int i = 0;
			int j = 0;
			//Zeilen des Dreiecks ausgeben
			while (i < x) {
				//Anzahl der Sternchen  ausgeben
				while (j < x - i) {
					System.out.print("*");
					j++;
				}
				System.out.println();
				j = 0;
				i++;
			}

			/*for (int i = 0; i < x; i++) {
				for (int j = 0; j < x-i; j++) {
					System.out.print("*");
				}
				System.out.println();

			} */
		}
	}


	public static int calculateNumberOfDigits(int n) {
		// TODO um die Ziffern zu berechnen, kann man versuchen von der Zahl 1, 10, 100, usw. zu subtrahieren und schauen ob das Ergebnis >= 0 ist.
		int num;
		int count = 0;
		long digit = 1;
		long i = 1;
		while (i > 0) {
			num = n;
			i = num - digit;
			if (i >= 0) {
				count++;
				digit *= 10;
			}
		}
		//System.out.println(count);
		return count;
	}

	/* TODO Musterlösung
	int numberOfDigits = 0;
		while(n > 0) {
			n = n / 10;
			numberOfDigits = numberOfDigits + 1;
		}
		return numberOfDigits;
	 */

	public static int reverseNumber(int n) {
		// TODO
		int z;
		int result = 0;
		int digits = calculateNumberOfDigits(n);
		while (n > 0) {
			z = n % 10;
			result = result + z * pow10(digits-1);
			n = (n - z) / 10;
			digits--;
		}
		System.out.println(result);
		return result;
	}

	public static int pow10 (int n) {
		// TODO
		int result = 1;
		while (n > 0) {
			result *= 10;
			n--;
		}

		return result;
	}

	/* TODO Musterlösung
	int reversedNumber = 0;
		while(n > 0) {
			reversedNumber = reversedNumber * 10;
			reversedNumber = reversedNumber + n % 10;
			n = n / 10;
		}
		return reversedNumber;
	 */


	public static boolean isPalindrome(int n) {
		// TODO
		return n == reverseNumber(n);
	}
}
