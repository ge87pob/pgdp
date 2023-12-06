package pgdp.math;

public class PinguSqrt {

	public static void sqrt(double n) {
		// TODO
		String result = "0";
		System.out.println("Wurzel aus " + n);
		System.out.println();
		long remainder = 0;
		boolean isEven;
		//determine if left side digits are even or not
		if (numofdigits(n) % 2 == 0) {
			isEven = true;
		}
		else {
			isEven = false;
		}
		//turn number in to one a string an remove the point
		String dividendpoint = String.format("%.4f", n);
		String dividend = dividendpoint.substring(0, numofdigits(n)) + dividendpoint.substring(numofdigits(n) + 1);
		long digitgroup;
		int newdigitgroup;
		while (dividend.length() > 1) {
			int digitresult = 0;
			//get new digitgroup through dividing by power of ten (if 1 or 2 digits don't divide, 3 or 4 digits divide by 100^1, if 5 or 6 digits divide by 100^2, etc.)
			if (isEven == false) {
				newdigitgroup = Integer.parseInt(dividend.substring(0, 1));
			}
			else {
				newdigitgroup = Integer.parseInt(dividend.substring(0, 2));
			}

			//update digitgroup
			digitgroup = Long.valueOf(String.valueOf(remainder) + newdigitgroup);
			System.out.println(digitgroup);
			System.out.println("--------");
			//
			long subtrahend = Long.valueOf(2 * Long.valueOf(result) + String.valueOf(1));
			for (remainder = digitgroup; remainder - subtrahend >= 0; subtrahend += 2) {
				remainder -= subtrahend;
				System.out.println("-" + subtrahend);
				digitresult++;
			}
			System.out.println("--------");
			System.out.println("Rest: " + remainder);
			System.out.println("neue Ergebnis Ziffer: " + digitresult);
			System.out.println();
			//cut out the first digitgroup
			if (isEven == false) {
				dividend = dividend.substring(1);
				isEven = true;
			}
			else {
				dividend = dividend.substring(2);
			}

			result += String.valueOf(digitresult);
		}
		//insert point at right spot
		result = result.substring(1, result.length() - 2) + "." + result.substring(result.length() - 2);
		//if last digit is 0 don't print
		if (result.charAt(result.length() - 1) == '0') {
			result = result.substring(0, result.length() - 1);
		}
		System.out.println("Ergebnis: " + result);
	}

	public static int numofdigits (double n) {
		int digits;
		for (digits = 0; n > 0; digits++) {
			n = (long)n / 10;
		}
		return digits;
	}

	public static long hundredtothepowerof (int n) {
		long result = 1;
		for (int i = 0; i < n; i++) {
			result *= 100;
		}
		return result;
	}

	public static void main(String[] args) {
		// test your implementation here
		sqrt(2111111111.0001);
		//sqrt(40000);
		/*String s = "1";
		int n = 23;
		s += String.valueOf(n);
		System.out.println(s);
		int x = 30;
		x %= 7;
		System.out.println(x);
		 */
		//String a = "23400";
		//a = a.substring(1);
		//System.out.println(a);
	}

}
