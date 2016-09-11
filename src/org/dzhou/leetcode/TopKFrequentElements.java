package org.dzhou.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 * For example, <br>
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * 
 * Note: <br>
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements. <br>
 * Your algorithm's time complexity must be better than O(n log n), where n is
 * the array's size. <br>
 * 
 * @author zhoudong
 *
 */
public class TopKFrequentElements {

	public class Solution {

		class Pair implements Comparable<Pair> {
			int value;
			int count;

			Pair(int value) {
				this.value = value;
				this.count = 0;
			}

			@Override
			public int compareTo(Pair o) {
				return this.count - o.count;
			}
		}

		public List<Integer> topKFrequent(int[] nums, int k) {
			Map<Integer, Pair> map = new HashMap<>();
			for (int num : nums) {
				if (!map.containsKey(num))
					map.put(num, new Pair(num));
				map.get(num).count++;
			}

			PriorityQueue<Pair> heap = new PriorityQueue<>();
			for (Pair pair : map.values()) {
				heap.add(pair);
				if (heap.size() > k) {
					heap.poll();
				}
			}

			List<Integer> result = new ArrayList<>();
			while (!heap.isEmpty()) {
				result.add(heap.poll().value);
			}
			Collections.reverse(result);
			return result;
		}

	}

}
