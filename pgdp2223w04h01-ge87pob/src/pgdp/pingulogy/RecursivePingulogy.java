package pgdp.pingulogy;

import javax.print.attribute.standard.DocumentName;

public class RecursivePingulogy {

	// task 1

	private static long [] m = new long [4];
	private static boolean first = true;
	private static boolean firsttime = true;
	private static int original = 0;
	public static long pinguSequenceRec(int n, int p0, int p1, int p2) {
		// TODO
		if (firsttime) {
			original = n;
		}
		if (n == 0) {
			return p0;
		}
		else if (n == 1) {
			return p1;
		}
		else if (n == 2) {
			return p2;
		}
		else if (n == 3) {
			first = false;
			m[1] = p2;
			m[2] = p1;
			m[3] = p0;
			m[0] = m[1] - m[2] + 2 * m[3];
			if (firsttime) {
				return m[0];
			}
			return pinguSequenceRec(n + 1, p0, p1, p2);
		}
		else if (n < 0) {
			return 2 * pinguSequenceRec(-n, p0, p1, p2);
		}
		//exit condition
		else if (original == n && !firsttime) {
			first = true;
			firsttime = true;
			original = 0;
			m[3] = m[2];
			m[2] = m[1];
			m[1] = m[0];
			return m[1] - m[2] + 2 * m[3];
		}
		else {
			if (first || firsttime) {
				firsttime = false;
				return pinguSequenceRec(n - 1, p0, p1, p2);
			} else {
				m[3] = m[2];
				m[2] = m[1];
				m[1] = m[0];
				m[0] = m[1] - m[2] + 2 * m[3];
				return pinguSequenceRec(n + 1, p0, p1, p2);
			}
		}
	}

	// task 2
	// Hint: pinguF and pinguM are not static (and must not be changed to it!)
	// more information in the main-method below
	public int pinguF(int n) {
		// TODO
		if (n == 0) {
			return 1;
		}
		else {
			return n - pinguM(pinguF(n - 1));
		}
	}

	public int pinguM(int n) {
		// TODO
		if (n == 0) {
			return 0;
		}
		else {
			return n - pinguF(pinguM(n - 1));
		}
	}

	// task 3
	private static int interim = 0;
	public static int pinguCode(int n, int m) {
		// TODO
		if (n == 0) {
			int temp = interim + m;
			interim = 0;
			return n + temp;
		}
		if ((n + interim) % 2 == 0) {
			interim += n/2;
			return pinguCode(m, n/2);
		}
		else {
			interim += m;
			return pinguCode(n-1, m/2);
		}
	}

	// task 4
	private static String DNA = "";
	public static String pinguDNA(int f, int m) {
		// TODO
		if (f == 0 && m == 0) {
			String result = DNA;
			DNA = "";
			return result;
		}
		if (f == 0) {
			String s = Integer.toBinaryString(m);
			while (s.length() > 1) {
				DNA = "A" + DNA;
				s = s.substring(1);
			}
			DNA = "A" + DNA;
			String result = DNA;
			DNA = "";
			return result;
		}
		if (m == 0) {
			String s = Integer.toBinaryString(f);
			while (s.length() > 1) {
				DNA = "T" + DNA;
				s = s.substring(1);
			}
			DNA = "T" + DNA;
			String result = DNA;
			DNA = "";
			return result;
		}
		String a = Integer.toBinaryString(f);
		String b = Integer.toBinaryString(m);
		if (a.charAt(a.length() - 1) == b.charAt(b.length() - 1)) {
			if (f > m) {
				DNA = "GT" +  DNA;
			}
			else if (f < m) {
				DNA = "GA" +  DNA;
			}
			else {
				DNA = "GC" + DNA;
			}
		}
		else {
			if (a.charAt(a.length() - 1) == '1') {
				DNA = "TC" + DNA;
			}
			else{
				DNA = "AC" + DNA;
			}
		}
		a = a.substring(0, a.length() - 1);
		b = b.substring(0, b.length() - 1);
		if (a == "" && b == "") {
			String result = DNA;
			DNA = "";
			return result;
		}
		if (a == "") {
			return pinguDNA(0, Integer.parseInt(b, 2));
		}
		else if (b == "") {
			return pinguDNA(Integer.parseInt(a, 2), 0);
		}
		return pinguDNA(Integer.parseInt(a, 2), Integer.parseInt(b, 2));
	}

	public static void main(String[] args) {
		// switch value to test other tasks
		int testTask = 1;
		//System.out.println(pinguSequenceRec(6, 1, 1, 2));

		switch (testTask) {
		case 1:
			System.out.println("Task 1 example output");
			for (int i = 0; i < 145; i++) {
				System.out.println(i + ": " + pinguSequenceRec(i, 1, 1, 2));
			}
			break;
		case 2:
			/**
			 * For better testing, pinguF and pinguM are not static. 
			 * Hence, you have to initialize a new RecursivePingulogy Object and 
			 * call the methods on that instance, as you can see below.
			 * You will learn more about object-oriented-programming in the lecture
			 * and week 05+.
			 */
			RecursivePingulogy rp = new RecursivePingulogy();
			System.out.print("Task 2 example output\npinguF: ");
			for (int i = 0; i < 10; i++) {
				System.out.print(rp.pinguF(i) + ", ");
			}
			System.out.print("\npingM: ");
			for (int i = 0; i < 10; i++) {
				System.out.print(rp.pinguM(i) + ", ");
			}
			break;
		case 3:
			System.out.println("Task 3 example output");
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					System.out.println(i + ", " + j + ": " + pinguCode(i, j));
				}
				System.out.println("----------");
			}
			break;
		case 4:
			System.out.println("Task 4 example output");
			System.out.println("pinguDNA(21, 25) = " + pinguDNA(21, 25));
			break;
		default:
			System.out.println("There are only 4 tasks!");
			break;
		}
	}
}
