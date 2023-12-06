package pgdp.convexhull;

import java.util.Arrays;
import java.util.Objects;

public class QuickHull {


	/* ================ Zu implementierende Methoden ================ */


	// Returns hull as {p, ..., q, ..., p}, where p is the leftmost point
	public static int[][] quickHull(int[][] points) {
		/* TODO what if only two points
		if (points.length == 2) {
			int [][] result = new int [3][2];
			for (int i = 0; i < result.length; i++)
				for (int j = 0; j < 2; j++) {
					result[i][j] = points [i % 2][j];
			}
		}
		 */
		int [][] left = quickHullLeftOf(points, findLeftmostPoint(points), findRightmostPoint(points));
		int [][] right = quickHullLeftOf(points, findRightmostPoint(points), findLeftmostPoint(points));

		return combineHulls(right, left);
	}

	private static int [][] oldp = new int [999][2];
	private static int [][] combinedhull = new int [0][2];
	private static int index = 0;
	private static boolean firsttime = true;

	// Returns hull-points in counter-clockwise fashion: {q, ..., p}
	public static int[][] quickHullLeftOf(int[][] points, int[] p, int[] q) {

		int[] r = findPointFurthestLeftFrom(points, p, q);
		//if only twopoints
		if (r == null && firsttime) {
			int [][] twopoints = new int [2][2];
			twopoints[0] = q;
			twopoints[1] = p;
			return twopoints;
		}
		//if you go back and there is no r
		if (r == null) {
			int [][] newhull = new int [2][2];
			newhull[0] = q;
			newhull[1] = p;
			combinedhull = combineHulls(combinedhull, newhull);
			if (index == 0) {
				firsttime = true;
				return combinedhull;
			}
			return quickHullLeftOf(points, oldp[--index], p);
		}
		if (existsPointLeftOf(points, r, q)) {
			oldp[index++] = p;
			return quickHullLeftOf(points, r, q);
		}
		else {
			//exception if there is no r the first time
			if (firsttime && index == 0) {
				firsttime = false;
				int [][] twopoints = new int [2][2];
				twopoints[0] = q;
				twopoints[1] = r;
				combinedhull = twopoints;
				return quickHullLeftOf(points, p, r);
			}
			int [][] newhull = new int [3][2];
			newhull[0] = q;
			newhull[1] = r;
			newhull[2] = p;
			if (firsttime) {
				firsttime = false;
				combinedhull = newhull;
			}
			else {
				combinedhull = combineHulls(combinedhull, newhull);
			}
			if (index == 0) {
				firsttime = true;
				return combinedhull;
			}
			return quickHullLeftOf(points, oldp[--index], p);
		}
	}

	public static int[][] combineHulls(int[][] firstHull, int[][] secondHull) {
		int [][] combined = new int [firstHull.length + secondHull.length - 1][2];
		for (int i = 0; i < firstHull.length; i++) {
			for (int j = 0; j < 2; j++) {
				combined[i][j] = firstHull[i][j];
			}
		}
		for (int i = 1; i < secondHull.length; i++) {
			for (int j = 0; j < 2; j++) {
				combined[i + firstHull.length - 1][j] = secondHull[i][j];
			}
		}
		return combined;
	}


	/* ================ Vorgegebene Methoden ================ */


	public static int[] findPointFurthestLeftFrom(int[][] points, int[] firstLinePoint, int[] secondLinePoint) {
		double maxDistance = 0.0;
		int[] leftmostPoint = null;
		for(int i = 0; i < points.length; i++) {
			double distance = Math.abs(signedDistance(points[i], firstLinePoint, secondLinePoint));
			if(isPointLeftOf(points[i], firstLinePoint, secondLinePoint) && distance > maxDistance) {
				maxDistance = distance;
				leftmostPoint = points[i];
			}
		}
		return leftmostPoint;
	}

	public static int[] findLeftmostPoint(int[][] points) {
		int[] currentLeftmost = points[0];
		for(int i = 1; i < points.length; i++) {
			if(points[i][0] < currentLeftmost[0]) {
				currentLeftmost = points[i];
			}
		}
		return currentLeftmost;
	}

	public static int[] findRightmostPoint(int[][] points) {
		int[] currentRightmost = points[0];
		for(int i = 1; i < points.length; i++) {
			if(points[i][0] > currentRightmost[0]) {
				currentRightmost = points[i];
			}
		}
		return currentRightmost;
	}

	public static boolean isPointLeftOf(int[] point, int[] firstLinePoint, int[] secondLinePoint) {
		double n = signedDistance(point, firstLinePoint, secondLinePoint);
		return n < 0;
	}

	public static boolean existsPointLeftOf(int[][] points, int[] firstLinePoint, int[] secondLinePoint) {
		for(int i = 0; i < points.length; i++) {
			if(isPointLeftOf(points[i], firstLinePoint, secondLinePoint)) {
				return true;
			}
		}
		return false;
	}

	public static double signedDistance(int[] point, int[] firstLinePoint, int[] secondLinePoint) {
		int det = (secondLinePoint[0] - firstLinePoint[0]) * (firstLinePoint[1] - point[1])
				- (firstLinePoint[0] - point[0]) * (secondLinePoint[1] - firstLinePoint[1]);
		double len = Math.sqrt(
				Math.pow(secondLinePoint[0] - firstLinePoint[0], 2) + Math.pow(secondLinePoint[1] - firstLinePoint[1], 2)
		);

		return det / len;
	}

	public static String pointsToPlotString(int[][] points) {
		StringBuilder sb = new StringBuilder();
		Arrays.stream(points).filter(Objects::nonNull)
				.forEach(point -> sb.append("point(").append(point[0]).append("|").append(point[1]).append(")\n"));
		return sb.toString();
	}

	public static void main(String[] args) {

		/*int[][] points = new int[][]{
				{-3, 2},
				{-2, 1}, {-2, 3}, {-2, 5},
				{-1, 0}, {-1, 4},
				{0, 4},
				{1, 1}, {1, 4}, {1, 6},
				{2, 3}, {2, 5},
				{3, -1}, {3, 2}, {3, 5},
				{4, 3}
		};
		int[] p = new int[]{-3, 2};
		int[] q = new int[]{4, 3};

		 */
		int[][] points = {
				{0,0}, {10,10},
				{1,5}, {3,7},
				{7,3}, {9,5},
				{1,1}, {5,5}, {0,0}, {2,4}, {7,8}, {9,9}, {2,5}
		};
		//System.out.println(pointsToPlotString(points));
		System.out.println(pointsToPlotString(quickHull(points)));



		/*int[][] points = new int[][]{
				{-3, 2},
				{4, 3}
		};
		int[] p = new int[]{-3, 2};
		int[] q = new int[]{4, 3};
		System.out.println(pointsToPlotString(quickHullLeftOf(points, p, q)));

		 */


		int[][] expected = new int[][]{{4, 3}, {3, 5}, {1, 6}, {-2, 5}, {-3, 2}};
		/*int[][] in = new int[][] { { 0, 0 }, { 0, 2 }, { 2, 0 }, { 2, 2 }, { 1, 1 } };
		int[][] hull = quickHull(in);
		System.out.println(pointsToPlotString(in));
		System.out.println(pointsToPlotString(hull));
		 */
	}

}
