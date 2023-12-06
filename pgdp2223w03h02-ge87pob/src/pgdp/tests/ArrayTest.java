package pgdp.tests;

import static org.junit.jupiter.api.Assertions.*;
import static pgdp.array.Array.print;
import static pgdp.array.Array.minAndMax;
import static pgdp.array.Array.invert;
import static pgdp.array.Array.intersect;
import static pgdp.array.Array.linearize;
import static pgdp.array.Array.bubbleSort;
import static pgdp.PinguLib.*;
import org.junit.jupiter.api.Test;

public class ArrayTest {

	@Test
	void printtest1() {
		setup();
		print(new int[]{1, 2, 3});
		assertEquals("{1, 2, 3}", getConsoleOutput());

		print(new int[]{0, 0, 0});
		assertEquals("{0, 0, 0}", getConsoleOutput());

		print(new int[]{});
		assertEquals("{}", getConsoleOutput());

		print(new int[]{-1, -3});
		assertEquals("{-1, -3}", getConsoleOutput());

		print(new int[]{3434, 25939, -234, 0, 0, 9430, -2394, 1234, 0});
		assertEquals("{3434, 25939, -234, 0, 0, 9430, -2394, 1234, 0}", getConsoleOutput());

		print(new int[]{2_300_400, -2_111});
		assertEquals("{2300400, -2111}", getConsoleOutput());
		reset();
	}

	@Test
	void minAndMaxtest() {
		setup();
		minAndMax(new int[] {1, 2, 3} );
		assertEquals("Minimum = 1, Maximum = 3", getConsoleOutput());

		minAndMax(new int[] {});
		assertEquals("", getConsoleOutput());

		minAndMax(new int[] {1, 2, 1, 10, -5, -3, 0, 4} );
		assertEquals("Minimum = -5, Maximum = 10", getConsoleOutput());

		minAndMax(new int[] {1, 1, 1} );
		assertEquals("Minimum = 1, Maximum = 1", getConsoleOutput());

		minAndMax(new int[] {-1} );
		assertEquals("Minimum = -1, Maximum = -1", getConsoleOutput());
		reset();
	}

	@Test
	void invertTest() {
		setup();

		int [] a = new int[] {1, 2, 3, 4, 5, 6, 7};
		invert(a);
		assertArrayEquals(a, new int[]{7, 6, 5, 4, 3, 2, 1});

		int [] b = new int[] {};
		invert(b);
		assertArrayEquals(b, new int[]{});

		int [] c = new int[] {0, 0};
		invert(c);
		assertArrayEquals(c, new int[]{0, 0});

		int [] d = new int[] {1, 2, 1, 1};
		invert(d);
		assertArrayEquals(d, new int[]{1, 1, 2, 1});

		int [] e = new int[] {-3};
		invert(e);
		assertArrayEquals(e, new int[]{-3});

		int [] f = new int[] {-1029309, 32903293, 0, 0, 392392019, -123321};
		invert(f);
		assertArrayEquals(f, new int[]{-123321, 392392019, 0, 0, 32903293, -1029309});

		reset();
	}

	@Test
	void intersectTest() {
		setup();

		assertArrayEquals(intersect(new int[] {1, 2, 3}, 2), new int[]{1, 2});

		assertArrayEquals(intersect(new int[] {1, 2, 3}, 5), new int[]{1, 2, 3, 0, 0});

		assertArrayEquals(intersect(new int[] {}, 3), new int[]{0, 0, 0});

		assertArrayEquals(intersect(new int[] {1, 2, 3}, 0), new int[]{});

		assertArrayEquals(intersect(new int[] {1, 2, 3}, -10), new int[]{});

		reset();
	}

	@Test
	void linearizeTest() {
		setup();

		assertArrayEquals(linearize(new int[][] {{1, 3}, {25}, {7, 4, 6, 9}}), new int []{1, 3, 25, 7, 4, 6, 9});

		assertArrayEquals(linearize(new int[][] {{}}), new int []{});

		assertArrayEquals(linearize(new int[][] {{1, 3}, {}, {7, 4, 6, 9}}), new int []{1, 3, 7, 4, 6, 9});

		reset();
	}

	@Test
	void bubblesortTest() {
		setup();

		int [] a = new int [] {3, 1, 4, 5, 2};
		bubbleSort(a);
		assertArrayEquals(a, new int [] {1, 2, 3, 4, 5});

		int [] b = new int [] {4, 3, 4, 1, 1};
		bubbleSort(b);
		assertArrayEquals(b, new int [] {1, 1, 3, 4, 4});

		int [] c = new int [] {};
		bubbleSort(c);
		assertArrayEquals(c, new int [] {});

		int [] d = new int [] {-2, -4, 0, 0, 1023};
		bubbleSort(d);
		assertArrayEquals(d, new int [] {-4, -2, 0, 0, 1023});

		reset();
	}
}
