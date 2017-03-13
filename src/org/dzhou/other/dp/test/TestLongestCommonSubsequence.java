package org.dzhou.other.dp.test;

import org.dzhou.other.dp.LongestCommonSubsequence;
import org.junit.Assert;
import org.junit.Test;

public class TestLongestCommonSubsequence {

	@Test
	public void test() {
		LongestCommonSubsequence instance = new LongestCommonSubsequence();
		Assert.assertEquals(4, instance.countMaxLength("abcdaf", "acbcf"));
	}

}
