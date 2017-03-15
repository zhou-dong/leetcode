package org.dzhou.other.rubicon.test;

import org.dzhou.other.rubicon.SparseMatrix;
import org.dzhou.other.rubicon.SparseMatrixEncodeKey;
import org.dzhou.other.rubicon.SparseMatrixKeyClass;
import org.dzhou.other.rubicon.SparseMatrixTwoMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestSparseMatrix {

	SparseMatrix instance;

	@Before
	public void init() {
		instance = new SparseMatrixKeyClass();
		instance = new SparseMatrixEncodeKey(5);
		instance = new SparseMatrixTwoMap();
	}

	@Test
	public void testGetEmpty() {
		Assert.assertEquals(0, instance.get(1, 1));
	}

	@Test
	public void testInsert() {
		instance.insert(1, 1, 5);
		Assert.assertEquals(5, instance.get(1, 1));
	}

	@Test
	public void testUpdate() {
		instance.insert(1, 1, 5);
		instance.insert(1, 1, 7);
		Assert.assertEquals(7, instance.get(1, 1));
	}

}
