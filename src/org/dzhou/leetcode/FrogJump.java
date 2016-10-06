package org.dzhou.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 403. Frog Jump
 * 
 * Difficulty: Hard
 * 
 * A frog is crossing a river. The river is divided into x units and at each
 * unit there may or may not exist a stone. The frog can jump on a stone, but it
 * must not jump into the water.
 * 
 * Given a list of stones' positions (in units) in sorted ascending order,
 * determine if the frog is able to cross the river by landing on the last
 * stone. Initially, the frog is on the first stone and assume the first jump
 * must be 1 unit.
 * 
 * If the frog's last jump was k units, then its next jump must be either k - 1,
 * k, or k + 1 units. Note that the frog can only jump in the forward direction.
 * 
 * Note:
 * 
 * 
 * The number of stones is ≥ 2 and is < 1,100.
 * 
 * Each stone's position will be a non-negative integer < 231.
 * 
 * The first stone's position is always 0.
 * 
 * Example 1:
 * 
 * [0,1,3,5,6,8,12,17]
 * 
 * There are a total of 8 stones.
 * 
 * The first stone at the 0th unit, second stone at the 1st unit,
 * 
 * third stone at the 3rd unit, and so on...
 * 
 * The last stone at the 17th unit.
 * 
 * Return true. The frog can jump to the last stone by jumping
 * 
 * 1 unit to the 2nd stone, then 2 units to the 3rd stone, then
 * 
 * 2 units to the 4th stone, then 3 units to the 6th stone,
 * 
 * 4 units to the 7th stone, and 5 units to the 8th stone.
 * 
 * Example 2:
 * 
 * [0,1,2,3,4,8,9,11]
 * 
 * Return false. There is no way to jump to the last stone as the gap between
 * the 5th and 6th stone is too large.
 * 
 * @author zhoudong
 *
 */
public class FrogJump {

	public static void main(String[] args) {
		// int[] stones = { 0, 1, 3, 4, 5, 7, 9, 10, 12 };
		int[] stones = { 0, 1, 2, 3, 4, 8, 9, 11 };
		boolean r = new DP_Solution().canCross(stones);
		System.out.println(r);
	}

	public static class DP_Solution {

		public boolean canCross(int[] stones) {
			if (stones == null || stones.length == 0 || stones[0] != 0)
				return false;
			HashMap<Integer, HashSet<Integer>> steps = new HashMap<>();

			for (int num : stones) {
				steps.put(num, new HashSet<Integer>());
			}
			for (int num : stones) {
				HashSet<Integer> subStep = steps.get(num);
				if (num == 0) {
					subStep.add(0);
					if (steps.containsKey(1))
						steps.get(1).add(1);
					continue;
				}
				for (int step : subStep) {
					for (int jump = step - 1, pos = num + step - 1; jump <= step + 1; jump++, pos++) {
						if (pos != num && steps.containsKey(pos))
							steps.get(pos).add(jump);
					}
				}
			}
			return !steps.get(stones[stones.length - 1]).isEmpty();
		}
	}

	public class Brute_Force_Solution {
		public boolean canCross(int[] stones) {
			return helper(stones, 0, 0);
		}

		private boolean helper(int[] stones, int index, int k) {
			if (index == stones.length - 1)
				return true;
			// 选择k的步伐，范围k-1到k
			for (int i = k - 1; i <= k + 1; i++) {
				int nextJump = stones[index] + i;
				int nextPosition = Arrays.binarySearch(stones, index + 1, stones.length, nextJump);
				if (nextPosition < 0) {
					continue;
				}
				if (helper(stones, nextPosition, i)) {
					return true;
				}
			}

			return false;
		}
	}
}
