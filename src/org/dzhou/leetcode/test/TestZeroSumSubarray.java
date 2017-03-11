package org.dzhou.leetcode.test;

import org.dzhou.leetcode.ZeroSumSubarray;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Input: {4, 2, -3, 1, 6} <br>
 * Output: true<br>
 * There is a subarray with zero sum from index 1 to 3.
 * 
 * Input: {4, 2, 0, 1, 6}<br>
 * Output: true<br>
 * There is a subarray with zero sum from index 2 to 2.<br>
 * 
 * Input: {-3, 2, 3, 1, 6} <br>
 * Output: false<br>
 * There is no subarray with zero sum.
 * 
 * @author zhoudong
 *
 */
public class TestZeroSumSubarray {

	ZeroSumSubarray instance;

	@Before
	public void init() {
		instance = new ZeroSumSubarray();
	}

	private void execute(int[] array, int[] expecteds) {
		Assert.assertArrayEquals(expecteds, instance.zeroSumIndices(array));
	}

	@Test
	public void test1() {
		execute(new int[] { 4, 2, -3, 1, 6 }, new int[] { 1, 3 });
	}

	@Test
	public void test2() {
		execute(new int[] { 4, 2, 0, 1, 6 }, new int[] { 2, 2 });
	}

	@Test
	public void test3() {
		execute(new int[] { -3, 2, 3, 1, 6 }, null);
	}

}
