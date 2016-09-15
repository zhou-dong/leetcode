package org.dzhou.leetcode;

import java.util.Stack;

/**
 * 84. Largest Rectangle in Histogram
 * 
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 * 
 * @author zhoudong
 *
 */
public class LargestRectangleInHistogram {

	public int largestRectangleArea(int[] heights) {
		int max = 0, index = 0;
		Stack<Integer> stack = new Stack<>();
		while (index < heights.length) {
			if (stack.isEmpty() || heights[stack.peek()] <= heights[index]) {
				stack.push(index++);
			} else {
				int height = heights[stack.pop()];
				int width = stack.isEmpty() ? index : width(stack.peek(), index);
				max = Math.max(max, height * width);
			}
		}
		while (!stack.isEmpty()) {
			int height = heights[stack.pop()];
			int width = stack.isEmpty() ? heights.length : width(stack.peek(), heights.length);
			max = Math.max(max, height * width);
		}
		return max;
	}

	private int width(int before, int after) {
		return after - before - 1;
	}

}
