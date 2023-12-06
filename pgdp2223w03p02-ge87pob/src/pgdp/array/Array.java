package pgdp.array;

public class Array {
	public static int[][] minsAndMaxs(int[][] a) {
		// TODO
		int[][] out = new int[a.length][2];

		for(int i = 0; i < a.length; i++) {
			if(a[i].length <= 0) {
				out[i] = null;
				continue;
			}

			int min = a[i][0];
			int max = a[i][0];
			for(int j = 1; j < a[i].length; j++) {
				if(a[i][j] < min) {
					min = a[i][j];
				}
				if(a[i][j] > max) {
					max = a[i][j];
				}
			}

			out[i] = new int[]{min, max};
		}

		return out;
	}

	public static int[][] transpose(int[][] a) {
		// TODO
		if(a.length == 0 || a[0].length == 0) {
			return null;
		}

		int[][] transposed = new int[a[0].length][a.length];
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				transposed[j][i] = a[i][j];
			}
		}

		return transposed;
	}

	public static int[] linearize(int[][] a) {
		int length = 0;
		for (int i = 0; i < a.length; i++) {
			length += a[i].length;
		}

		int[] linearized = new int[length];
		int linIndex = 0;

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				linearized[linIndex++] = a[i][j];
			}
		}

		return linearized;
	}

	public static boolean crossword(char[][] letterGrid, char[] word) {
		if(letterGrid.length == 0 || letterGrid[0].length == 0) {
			return false;
		}

		if(word.length == 0) {
			return true;
		}

		// Rightward
		for(int i = 0; i < letterGrid.length; i++) {
			for(int j = 0; j <= letterGrid[i].length - word.length; j++) {
				boolean matches = true;
				for(int k = 0; k < word.length; k++) {
					if(letterGrid[i][j + k] != word[k]) {
						matches = false;
						break;
					}
				}
				if(matches) {
					return true;
				}
			}
		}

		// Downward
		for(int i = 0; i <= letterGrid.length - word.length; i++) {
			for(int j = 0; j < letterGrid.length; j++) {
				boolean matches = true;
				for(int k = 0; k < word.length; k++) {
					if(letterGrid[i + k][j] != word[k]) {
						matches = false;
						break;
					}
				}
				if(matches) {
					return true;
				}
			}
		}

		// Diagonally
		for(int i = 0; i <= letterGrid.length - word.length; i++) {
			for(int j = 0; j <= letterGrid[i].length - word.length; j++) {
				boolean matches = true;
				for(int k = 0; k < word.length; k++) {
					if(letterGrid[i + k][j + k] != word[k]) {
						matches = false;
						break;
					}
				}
				if(matches) {
					return true;
				}
			}
		}

		return false;
	}

}
