package org.dzhou.leetcode;

/**
 * 486. Predict the Winner
 * 
 * Given an array of scores that are non-negative integers. Player 1 picks one
 * of the numbers from either end of the array followed by the player 2 and then
 * player 1 and so on. Each time a player picks a number, that number will not
 * be available for the next player. This continues until all the scores have
 * been chosen. The player with the maximum score wins.
 * 
 * Given an array of scores, predict whether player 1 is the winner. You can
 * assume each player plays to maximize his score.
 * 
 * Example 1: Input: [1, 5, 2] Output: False
 * 
 * Explanation: Initially, player 1 can choose between 1 and 2. If he chooses 2
 * (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5,
 * then player 1 will be left with 1 (or 2). So, final score of player 1 is 1 +
 * 2 = 3, and player 2 is 5. Hence, player 1 will never be the winner and you
 * need to return False.
 * 
 * Example 2: Input: [1, 5, 233, 7] Output: True
 * 
 * Explanation: Player 1 first chooses 1. Then player 2 have to choose between 5
 * and 7. No matter which number player 2 choose, player 1 can choose 233.
 * Finally, player 1 has more score (234) than player 2 (12), so you need to
 * return True representing player1 can win.
 * 
 * 
 * @author zhoudong
 *
 */
public class PredictTheWinner {

	public boolean predictTheWinner(int[] nums) {
		Pair[][] table = createDpTable(nums);
		for (int row = 1; row <= nums.length; row++) {
			for (int col = row; col < table[0].length; col++) {
				int low = nums[col - 1];
				int high = nums[col + row];

			}
		}
		return Pair.isFirstWin(table[1][table.length - 1]);
	}

	static class Pair {
		int first, second;

		public Pair() {
			this(0, 0);
		}

		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}

		public static boolean isFirstWin(Pair pair) {
			return pair.first > pair.second;
		}

		public static Pair getWinner(Pair p1, Pair p2) {
			return p1.first > p2.first ? p1 : p2;
		}
	}

	public Pair[][] createDpTable(int[] nums) {
		Pair[][] table = new Pair[nums.length + 1][nums.length + 1];
		for (int col = 0; col < table[0].length; col++) {
			table[0][col] = new Pair();
		}
		for (int row = 0; row < table.length; row++) {
			table[row][0] = new Pair();
		}
		return table;
	}

}
