package org.dzhou.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 350. Intersection of Two Arrays II
 * 
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * 
 * Note: <br>
 * Each element in the result should appear as many times as it shows in both
 * arrays.<br>
 * The result can be in any order.
 * 
 * 
 * Follow up:<br>
 * What if the given array is already sorted? How would you optimize your
 * algorithm?<br>
 * What if nums1's size is small compared to num2's size? Which algorithm is
 * better?<br>
 * What if elements of nums2 are stored on disk, and the memory is limited such
 * that you cannot load all elements into the memory at once?
 * 
 * @author zhoudong
 *
 */
public class IntersectionOfTwoArraysII {

	public int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map1 = createMap(nums1);
		Map<Integer, Integer> map2 = createMap(nums2);

		List<Integer> list = new ArrayList<Integer>();
		for (int key : map1.keySet()) {
			if (!map2.containsKey(key))
				continue;
			int min = Math.min(map1.get(key), map2.get(key));
			addElements(list, key, min);
		}

		int[] result = new int[list.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = list.get(i);
		}
		return result;
	}

	private void addElements(List<Integer> list, int element, int time) {
		for (int i = 0; i < time; i++) {
			list.add(element);
		}
	}

	private Map<Integer, Integer> createMap(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			if (!map.containsKey(num)) {
				map.put(num, 1);
			} else {
				map.put(num, map.get(num) + 1);
			}
		}
		return map;
	}

}
