package org.dzhou.leetcode.test;

import org.dzhou.leetcode.KdiffPairsInAnArray;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestKdiffPairsInAnArray {

	KdiffPairsInAnArray instance;

	@Before
	public void init() {
		instance = new KdiffPairsInAnArray();
	}

	@Test
	public void testNormalCase() {
		int expected = 2;
		int actual = instance.findPairs(new int[] { 3, 1, 4, 1, 5 }, 2);
		Assert.assertEquals(expected, actual);
	}

}
