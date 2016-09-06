package org.dzhou.leetcode;

/**
 * 121. Best Time to Buy and Sell Stock
 * 
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * If you were only permitted to complete at most one transaction (ie, buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 * 
 * @author zhoudong
 *
 */
public class BestTimeToBuyAndSellStock {

	public class Solution {

		public int maxProfit(int[] prices) {
			if (prices == null || prices.length == 0)
				return 0;

			int max = 0, minPrice = prices[0];

			for (int i = 1; i < prices.length; i++) {
				max = Math.max(max, prices[i] - minPrice);
				minPrice = Math.min(minPrice, prices[i]);
			}
			return max;
		}

	}

}
