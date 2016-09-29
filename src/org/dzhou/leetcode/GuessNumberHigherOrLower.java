package org.dzhou.leetcode;

/**
 * 374. Guess Number Higher or Lower
 * 
 * We are playing the Guess Game. The game is as follows:
 * 
 * I pick a number from 1 to n. You have to guess which number I picked.
 * 
 * Every time you guess wrong, I'll tell you whether the number is higher or
 * lower.
 * 
 * You call a pre-defined API guess(int num) which returns 3 possible results
 * (-1, 1, or 0):
 * 
 * -1 : My number is lower <br>
 * 1 : My number is higher<br>
 * 0 : Congrats! You got it!<br>
 * 
 * Example: n = 10, I pick 6.
 * 
 * Return 6.
 * 
 * @author zhoudong
 *
 */
public class GuessNumberHigherOrLower {

	/**
	 * The guess API is defined in the parent class GuessGame.
	 * 
	 * @param num,
	 *            your guess
	 * 
	 * @return -1 if my number is lower, 1 if my number is higher, otherwise
	 *         return 0 int guess(int num);
	 */

	abstract class GuessGame {
		int n;

		int guess(int num) {
			return n == num ? 0 : num < n ? -1 : 1;
		}

		abstract int guessNumber(int num);
	}

	public class Solution extends GuessGame {
		@Override
		public int guessNumber(int n) {
			int start = 1, end = n;
			while (start <= end) {
				int mid = start + (end - start) / 2;
				int response = guess(mid);
				if (response == 0)
					return mid;
				else if (response < 0)
					end = mid - 1;
				else
					start = mid + 1;
			}
			return -1;
		}
	}

}
