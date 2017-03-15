package org.dzhou.other.rubicon.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
	public void test1() {
		String pattern = "1??1";
		Set<String> expected = new HashSet<>(Arrays.asList("1001", "1011", "1101", "1111"));
		Assert.assertEquals(expected, instance.combinations(pattern));
	}

	@Test
	public void test2() {
		String pattern = "10?1";
		Set<String> expected = new HashSet<>(Arrays.asList("1001", "1011"));
		Assert.assertEquals(expected, instance.combinations(pattern));
	}

}
