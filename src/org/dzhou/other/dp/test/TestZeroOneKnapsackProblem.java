package org.dzhou.other.dp.test;

import org.dzhou.other.dp.ZeroOneKnapsackProblem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestZeroOneKnapsackProblem {

	private ZeroOneKnapsackProblem instance;

	@Before
	public void init() {
		instance = new ZeroOneKnapsackProblem();
	}

	@Test
	public void testNormal1() {
		Assert.assertEquals(9, instance.maxValue(new int[] { 1, 3, 4, 5 }, new int[] { 1, 4, 5, 7 }, 7));
	}

	@Test
	public void testNormal2() {
		Assert.assertEquals(12, instance.maxValue(new int[] { 1, 3, 4, 5 }, new int[] { 1, 4, 5, 7 }, 9));
	}

	@Test
	public void testNormal3() {
		Assert.assertEquals(13, instance.maxValue(new int[] { 1, 3, 4, 5 }, new int[] { 1, 4, 5, 7 }, 11));
	}

	@Test
	public void testNormal4() {
		Assert.assertEquals(13, instance.maxValue(new int[] { 1, 3, 4, 5 }, new int[] { 1, 4, 5, 7 }, 10));
	}

	@Test
	public void testNormal5() {
		Assert.assertEquals(16, instance.maxValue(new int[] { 1, 3, 4, 5 }, new int[] { 1, 4, 5, 7 }, 12));
	}

	@Test
	public void testTooLargeTotalValue() {
		Assert.assertEquals(17, instance.maxValue(new int[] { 1, 3, 4, 5 }, new int[] { 1, 4, 5, 7 }, 100));
	}

	@Test
	public void testSamllTotalValue() {
		Assert.assertEquals(1, instance.maxValue(new int[] { 1, 3, 4, 5 }, new int[] { 1, 4, 5, 7 }, 1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidInput1() {
		Assert.assertEquals(1, instance.maxValue(null, new int[] { 1, 4, 5, 7 }, 1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidInput2() {
		Assert.assertEquals(1, instance.maxValue(null, null, 1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidInput3() {
		Assert.assertEquals(1, instance.maxValue(new int[] { 1, 3, 4, 5 }, new int[] { 1, 4, 5, 7 }, -10));
	}

}
