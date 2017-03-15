package org.dzhou.other.rubicon.test;

import java.util.Arrays;
import java.util.HashSet;

import org.dzhou.other.rubicon.ReplaceQuestionMark;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestReplaceQuestionMark {

	ReplaceQuestionMark instance;

	@Before
	public void init() {
		instance = new ReplaceQuestionMark();
	}

	@Test
	public void test() {
		String pattern = "1??1";
		String[] expected = { "1001", "1011", "1101", "1111" };
		Assert.assertEquals(new HashSet<>(Arrays.asList(expected)), instance.combinations(pattern));
	}

}
