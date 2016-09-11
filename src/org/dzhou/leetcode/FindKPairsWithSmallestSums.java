package org.dzhou.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 373. Find K Pairs with Smallest Sums
 * 
 * You are given two integer arrays nums1 and nums2 sorted in ascending order
 * and an integer k.
 * 
 * Define a pair (u,v) which consists of one element from the first array and
 * one element from the second array.
 * 
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 * 
 * @author zhoudong
 *
 */
public class FindKPairsWithSmallestSums {

	public class Solution {

		class Pair implements Comparable<Pair> {
			int sum;
			int x;
			int y;

			Pair(int x, int y) {
				this.x = x;
				this.y = y;
				this.sum = x + y;
			}

			@Override
			public int compareTo(Pair o) {
				return this.sum - o.sum;
			}

			int[] getPair() {
				return new int[] { x, y };
			}
		}

		public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
			if (nums1 == null || nums2 == null)
				return Collections.emptyList();
			PriorityQueue<Pair> heap = new PriorityQueue<>(Collections.reverseOrder());
			for (int i = 0; i < nums1.length; i++) {
				for (int j = 0; j < nums2.length; j++) {
					Pair pair = new Pair(nums1[i], nums2[j]);
					heap.add(pair);
					if (heap.size() > k) {
						heap.poll();
					}
				}
			}
			List<int[]> result = new ArrayList<>();
			while (!heap.isEmpty()) {
				result.add(heap.poll().getPair());
			}
			Collections.reverse(result);
			return result;
		}
	}
}
