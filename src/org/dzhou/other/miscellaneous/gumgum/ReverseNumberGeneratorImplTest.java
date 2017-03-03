package org.dzhou.other.miscellaneous.gumgum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReverseNumberGeneratorImplTest {

	ReverseNumberGenerator instance;

	@Before
	public void init() {
		instance = new ReverseNumberGeneratorImpl();
	}

	@Test
	public void testSingleNumberPositive() {
		Assert.assertEquals(8, instance.reverseANumber(8).intValue());
	}

	@Test
	public void testSingleNumberNegative() {
		Assert.assertEquals(-8, instance.reverseANumber(-8).intValue());
	}

	@Test
	public void testNormalCasePositve() {
		Assert.assertEquals(1234, instance.reverseANumber(4321).intValue());
	}

	@Test(expected = RuntimeException.class)
	public void testIntegerMax() {
		int actual = instance.reverseANumber(Integer.MAX_VALUE);
		System.out.println(actual);
	}

	@Test
	public void test() {
		System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
		System.out.println(Integer.toBinaryString(Integer.MAX_VALUE + 1));
		System.out.println(Integer.MAX_VALUE + Integer.MAX_VALUE + Integer.MAX_VALUE);
	}

}
