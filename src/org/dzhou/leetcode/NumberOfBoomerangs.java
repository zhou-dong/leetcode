package org.dzhou.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 447. Number of Boomerangs
 * 
 * Difficulty: Easy
 * 
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is
 * a tuple of points (i, j, k) such that the distance between i and j equals the
 * distance between i and k (the order of the tuple matters).
 * 
 * Find the number of boomerangs. You may assume that n will be at most 500 and
 * coordinates of points are all in the range [-10000, 10000] (inclusive).
 * 
 * Example: Input: [[0,0],[1,0],[2,0]]
 * 
 * Output: 2
 * 
 * Explanation: The two boomerangs are [[1,0],[0,0],[2,0]] and
 * [[1,0],[2,0],[0,0]]
 * 
 * @author zhoudong
 *
 */
public class NumberOfBoomerangs {

	public int numberOfBoomerangs(int[][] points) {
		int count = 0;
		for (int[] point1 : points) {
			Map<Long, Integer> map = new HashMap<>();
			for (int[] point2 : points) {
				increase(map, distance(point1, point2));
			}
			for (int value : map.values()) {
				count += value * (value - 1);
			}
		}
		return count;
	}

	private long distance(int[] p1, int[] p2) {
		return square(p1[0] - p2[0]) + square(p1[1] - p2[1]);
	}

	private long square(int num) {
		return num * num;
	}

	private void increase(Map<Long, Integer> map, long key) {
		if (!map.containsKey(key)) {
			map.put(key, 1);
		} else {
			map.put(key, map.get(key) + 1);
		}
	}

}
