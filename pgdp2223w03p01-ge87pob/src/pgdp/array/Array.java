package pgdp.array;


import java.util.*;

public class Array {

	private static int[] a = new int [4];

	public static void main(String[] args) {
		//print(intersect(new int[] {1, 2, 3}, -4));
		//print(filterEvenNumbersFrom(new int[] {1, 3, 5, 7, 9}));
		//print(new int[] {-4});
		//System.out.print(isOrderedAscendingly(new int[] {1, 2, 3, 4, 5}));
		//System.out.println("");
		minAndMax(new int [] {});
	}

	public static void print(int[] a) {
		// TODO
		//int [] b = new int[a.length];
		System.out.print("{");
		for (int i = 0; i < a.length - 1; i++) {
			System.out.print(a[i] + ", ");
		}
		if (a.length > 0) {
			System.out.print(a[a.length - 1]);
		}
		System.out.print("}");
	}

	public static void minAndMax(int[] a) {
		// TODO
		if (a.length == 0) {
			return;
		}
		int min = a[0];
		int max = a[0];
		for (int i = 0; i < a.length; i++) {
			if (a[i] < min) {
				min = a[i];
			}
			if (a[i] > max) {
				max = a[i];
			}
		}
		System.out.println("Minimum = " + min + ", Maximum = " + max);
	}

	public static boolean isOrderedAscendingly(int[] a) {
		// TODO
		if (a.length == 0) {
			return true;
		}
		boolean ordered = true;
		for (int i = 0; i < a.length-1; i++){
			if (a[i] > a[i+1]) {
				ordered = false;
			}
		}
		return ordered;
	}

	public static void invert(int[] a) {
		// TODO
		if (a.length == 0) {
			return;
		}
		for (int i = 0; i < a.length / 2; i++){
			int temp = a[i];
			a[i] = a[a.length - 1 - i];
			a[a.length - 1 - i] = temp;
		}
	}

	public static int[] intersect(int[] a, int length) {
		// TODO
		if (length < 1) {
			return new int [0];
		}
		int [] b = new int [length];
		if (a.length > length)
		{
			for (int i = 0; i < length; i++){
				b[i] = a[i];
			}
			return b;
		}
		else if (a.length == length) {
				return a;
			}
		else {
			for (int i = 0; i < a.length; i++) {
				b[i] = a[i];
			}
			return b;
		}
		/*
	if (length <= 0) {
			return new int[0];
		}

		int[] intersected = new int[length];

		for (int i = 0; i < length && i < a.length; i++) {
			intersected[i] = a[i];
		}

		return intersected;

	 */
	}



	public static int[] filterEvenNumbersFrom(int[] a) {
		// TODO
		int sizeofarray = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 0)
				sizeofarray++;
		}
		int [] b =  new int [sizeofarray];
		int temp = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 0) {
				b[temp] = a[i];
				temp++;
			}
		}

		return b;
	}

	public static int[] distinct(int[] a) {
		// TODO
		int [] b = new int [a.length];
		int sizeofarray = 0;
		for (int i = 0; i < a.length; i++) {
			boolean unique = true;
			for (int j = 0; j < sizeofarray; j++) {
				if (b[j] == a[i]) {
					unique = false;
					break;
				}
			}
			if (unique) {
				b[sizeofarray] = a[i];
				sizeofarray++;
			}
		}
		int [] c = new int [sizeofarray];
		for (int i = 0; i < sizeofarray; i++) {
			c[i] = b[i];
		}
		return c;
	}
}
