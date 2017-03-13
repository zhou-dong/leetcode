package org.dzhou.other.dp;

/**
 * 0/1 Knapsack Problem Dynamic Programming
 * 
 * 假设有几个商品，他们的重量和价值分别是：
 * 
 * index, weight, value<br>
 * 1. ------- 1 ------- 1<br>
 * 2. ------- 3 ------- 4<br>
 * 3. ------- 4 ------- 5<br>
 * 4. ------- 5 ------- 7<br>
 * 
 * 介绍你有一个背包，包能装的东西的重量是有限的，选择哪些商品的组合，能在符合重量要求的情况下，装的商品价值最高。如：
 * 
 * total weight = 7， 选择indices：2，3， total value：9
 * 
 * @author zhoudong
 *
 */
public class ZeroOneKnapsackProblem {

	public int maxValue(int[] weights, int[] values, int totalWeight) {

		if (weights == null || values == null || totalWeight < 0) {
			throw new IllegalArgumentException();
		}

		if (totalWeight == 0) {
			return 0;
		}

		int[][] table = new int[weights.length + 1][totalWeight + 1];

		for (int row = 1; row < table.length; row++) {
			int weight = weights[row - 1], value = values[row - 1];
			for (int col = 1; col < table[row].length; col++) {
				if (weight > col) {
					table[row][col] = table[row - 1][col];
				} else {
					table[row][col] = Math.max(table[row - 1][col], value + table[row - 1][col - weight]);
				}
			}
		}

		return table[table.length - 1][table[0].length - 1];
	}

}
