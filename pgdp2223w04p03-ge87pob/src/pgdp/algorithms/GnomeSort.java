package pgdp.algorithms;

import java.util.Arrays;

public class GnomeSort {

	/**
	 * Sort input array using gnome sort
	 * @param a integer array to be sorted using gnome sort
	 */
	public static void gnomeSort(int[] a) {
		// TODO: implement gnome sort
		int pos = 1;
		while (pos < a.length) {
			if (pos == 0 || a[pos] >= a[pos - 1]) {
				pos++;
			}
			else {
				int temp = a[pos];
				a[pos] = a[pos - 1];
				a[pos - 1] = temp;
				pos--;
			}
		}
	}

	public static void main(String[] args) {
		int[] a = new int[] { 5, 2, 3, 1, 6, 0, 4 };
		gnomeSort(a);
		System.out.println(Arrays.toString(a));
	}

}
