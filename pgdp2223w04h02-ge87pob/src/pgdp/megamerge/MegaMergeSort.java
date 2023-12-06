package pgdp.megamerge;

import java.util.Arrays;

public class MegaMergeSort {

	/**
	 * Sorts the array using mega merge sort with div splits
	 * @param array the array to be sorted
	 * @param div the split factor
	 * @return the sorted array
	 */
	protected int[] megaMergeSort(int[] array, int div) {
		return megaMergeSort(array, div, 0, array.length);
	}

	/**
	 * Sorts the array using mega merge sort with div splits in the defined range
	 * @param array the array to be sorted
	 * @param div the split factor
	 * @param from the lower bound (inclusive)
	 * @param to the upper bound (exclusive)
	 * @return the sorted array
	 */
	protected int[] megaMergeSort(int[] array, int div, int from, int to) {
		// TODO
		int length = to - from;
		int plusone = 0;
		int contraplusone = 0;
		int newfrom, newto;
		int [][] memory;

		if (length == 1) {
			return new int[]{array[from]};
		}
		if (length == 0) {
			return new int[]{};
		}
		if (length % div == 0) {
			memory = new int[div][length / div];
		}
		else {
			memory = new int[div][(length / div) + 1];
		}

		for (int i = 0; i < div; i++) {
			//initiate plusone, but only once
			if (length % div != 0 && i == 0) {
				plusone = length % div;
			}
			newfrom = from + i * (length / div) + contraplusone;
			if (plusone > 0 && i > 0) {
				newfrom++;
				plusone--;
				contraplusone++;
			}
			newto = newfrom + length / div;
			if (plusone > 0) {
				newto++;
			}
			memory[i] = megaMergeSort(array, div, newfrom, newto);
		}
		return merge(memory, 0, div);
	}

	/**
	 * Merges all arrays in the given range
	 * @param arrays to be merged
	 * @param from lower bound (inclusive)
	 * @param to upper bound (exclusive)
	 * @return the merged array
	 */

	private static boolean firsttime = true;
	private static int [] merged;
	protected int[] merge(int[][] arrays, int from, int to) {
		// TODO
		if (firsttime && to - from < 1) {
			return new int []{};
		}
		if (firsttime && to - from == 1) {
			return arrays[from];
		}
		if (firsttime) {
			firsttime = false;
			int length = 0;
			for (int i = 0; i < arrays.length; i++) {
				length += arrays[i].length;
			}
			merged = new int[length];
			merged = merge(arrays[to - 1], arrays[to - 2]);
			return merge(arrays, from, to - 1);
		}
		if (to - 2 >= from) {
			merged = merge(merged, arrays[to - 2]);
			return merge(arrays, from, to - 1);
		}
		firsttime = true;
		return merged;
	}

	/**
	 * Merges the given arrays into one
	 * @param arr1 the arr1 array
	 * @param arr2 the arr2 array
	 * @return the resulting array
	 */
	protected int[] merge(int[] arr1, int[] arr2) {
		// TODO
		int merged [] = new int[arr1.length + arr2.length];
		int posfirst = 0;
		int possecond = 0;
		int posmerged = 0;

		while (posfirst < arr1.length && possecond < arr2.length) {
			if (arr1[posfirst] < arr2[possecond]) {
				merged[posmerged++] = arr1[posfirst++];
			}
			else {
				merged[posmerged++] = arr2[possecond++];
			}
		}
		while(posfirst < arr1.length) {
			merged[posmerged++] = arr1[posfirst++];
		}
		while(possecond < arr2.length) {
			merged[posmerged++] = arr2[possecond++];
		}

		return merged;
	}

	public static void main(String[] args) {
		//Arrays.toString(merge(new int [][] {{5, -5, 4}, {69, 420, 0}, {-1, -2, -3}}, 0, 3));

		/*MegaMergeSort mms = new MegaMergeSort();
		int[] arr = new int[] { 1, 2, 6, 7, 4, 3, 8, 9, 0, 5 };
		int[] res = mms.megaMergeSort(arr, 4);
		System.out.println(Arrays.toString(res));
		 */
	}
}
