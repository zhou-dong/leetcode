package org.dzhou.leetcode;

/**
 * 123. Best Time to Buy and Sell Stock III
 * 
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most two
 * transactions.
 * 
 * Note: You may not engage in multiple transactions at the same time (ie, you
 * must sell the stock before you buy again).
 * 
 * @author zhoudong
 *
 */
public class BestTimeToBuyAndSellStockIII {

	public class Solution {

		public int maxProfit(int[] prices) {
			if (prices == null || prices.length < 2)
				return 0;

			int length = prices.length;

			int[] before = new int[length];
			int[] after = new int[length];

			int min = prices[0];
			for (int i = 1; i < length; i++) {
				before[i] = Math.max(before[i - 1], prices[i] - min);
				min = Math.min(prices[i], min);
			}

			int max = prices[length - 1];
			for (int i = length - 2; i >= 0; i--) {
				after[i] = Math.max(after[i + 1], max - prices[i]);
				max = Math.max(max, prices[i]);
			}

			int maxSum = 0;
			for (int i = 0; i < length; i++) {
				maxSum = Math.max(maxSum, before[i] + after[i]);
			}
			return maxSum;
		}

	}

}
