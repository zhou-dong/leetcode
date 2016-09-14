package org.dzhou.leetcode;

import java.util.Arrays;

/**
 * 322. Coin Change
 * 
 * You are given coins of different denominations and a total amount of money
 * amount. Write a function to compute the fewest number of coins that you need
 * to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 * 
 * Example 1: coins = [1, 2, 5], amount = 11 return 3 (11 = 5 + 5 + 1)
 * 
 * Example 2: coins = [2], amount = 3 return -1.
 * 
 * Note: You may assume that you have an infinite number of each kind of coin.
 * 
 * @author zhoudong
 * 
 *         https://www.youtube.com/watch?v=NJuKJ8sasGk
 *
 */
public class CoinChange {

	public int coinChange(int[] coins, int amount) {
		if (coins == null || coins.length == 0 || amount <= 0)
			return 0;

		int[] dp = new int[amount + 1];
		Arrays.fill(dp, Integer.MAX_VALUE - 1);
		dp[0] = 0;

		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i) {
					dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
				}
			}
		}

		return dp[amount] == (Integer.MAX_VALUE - 1) ? -1 : dp[amount];
	}

}
