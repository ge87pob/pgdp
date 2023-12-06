package pgdp.math;

public class ControlStructuresII {
	public static void main(String[] args) {
		// Zum Testen
		threeAndSeven(25);
		/*long l = 1000000017538L;
		float f = l;
		System.out.println((byte)320.5f);
		System.out.println(f); */
		//printAsciiCodesFor('a', 5);
		//printPrimesUpTo(100);
	}

	public static int threeAndSeven(int n) {
		// TODO
		if (n < 0) {
			System.out.println("Eingabe muss größer oder gleich 0 sein!");
			return -1;
		}
		int sum = 0;
		int count1 = 1;
		int count2 = 1;
		for (int i = 0; i + 3 <= n; count1++) {
			i = count1 * 3;
			sum += i;
			if (i % 3 == 0 && i % 7 == 0) {
				sum -= i;
			}
		}
		for (int j = 0; j + 7 <= n; count2++) {
			j = count2 * 7;
			sum += j;
		}
		System.out.println(sum);
		return sum;
	}

	/* TODO Musterlösung
	if(n < 0) {
			System.out.println("Eingabe muss größer oder gleich 0 sein!");
			return -1;
		}

		int sum = 0;
		for(int i = 0; i <= n; i++) {
			if(i % 3 == 0 || i % 7 == 0) {
				sum += i;
			}
		}
		return sum;
	 */


	public static void printAsciiCodesFor(char start, int count) {
		// TODO
		for (int i = start; i < start + count; i++) {
			System.out.println("Der ASCII-Code von '" + (char) i + "' ist " + i + ".");
		}
	}

	public static void printMultiplicationTable(int n) {
		// TODO skip for now
		System.out.print("*\t|\t");
		for(int i = 1; i <= n; i++) {
			System.out.print(i + "\t");
		}
		System.out.println();

		for(int i = 1; i <= n+2; i++) {
			System.out.print("----");
		}
		System.out.println();

		for(int i = 1; i <= n; i++) {
			System.out.print(i + "\t|\t");
			for(int j = 1; j <= n; j++) {
				System.out.print(i*j + "\t");
			}
			System.out.println();
		}
	}

	public static void printPrimesUpTo(int n) {
		// TODO Funktion checkt für jede Zahl bis n ob die Zahl (temp1) eine Primzahl ist. Das ist dann der Fall, wenn die Zahl nur durch 1 und sich selber teilbar ist.
		for (int temp1 = 1; temp1 <= n; temp1++ ) {
			int count = 0; // falls die vorherige Zahl keine Primzahl hier wieder reset
			for (int temp2 = 1; temp2 < temp1; temp2++){
				if (temp1 % temp2 == 0) {
					count++;
				}
			}
			if (count == 1) { //count 1 weil nur durch 1 teilbar (und sich selbst, aber wird hier nicht geprüft)
				System.out.print(temp1 + " ");
				count = 0;
			}
		}
	}
}