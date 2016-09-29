package org.dzhou.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 349. Intersection of Two Arrays
 * 
 * Difficulty: Easy
 * 
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * 
 * Note: <br>
 * Each element in the result must be unique.<br>
 * The result can be in any order.
 * 
 * @author zhoudong
 *
 */
public class IntersectionOfTwoArrays {

	public class HashTable_Solution {
		public int[] intersection(int[] nums1, int[] nums2) {
			Set<Integer> set1 = new HashSet<>();
			Set<Integer> set2 = new HashSet<>();

			for (int num : nums1) {
				set1.add(num);
			}
			for (int num : nums2) {
				if (set1.contains(num)) {
					set2.add(num);
				}
			}

			int[] result = new int[set2.size()];
			int index = 0;
			for (int num : set2) {
				result[index++] = num;
			}
			return result;
		}
	}

	public class Sort_Solution {
		public int[] intersection(int[] nums1, int[] nums2) {
			Arrays.sort(nums1);
			Arrays.sort(nums2);
			Set<Integer> set = new HashSet<>();
			for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
				if (nums1[i] == nums2[j]) {
					set.add(nums1[i]);
					i++;
					j++;
				} else if (nums1[i] < nums2[j]) {
					i++;
				} else {
					j++;
				}
			}
			int index = 0;
			int[] result = new int[set.size()];
			for (Iterator<Integer> iterator = set.iterator(); iterator.hasNext(); index++) {
				result[index] = iterator.next();
			}
			return result;
		}
	}

}
