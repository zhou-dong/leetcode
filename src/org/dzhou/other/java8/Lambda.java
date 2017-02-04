package org.dzhou.other.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class Lambda {

	@Test
	public void Anonymous_Runnable() {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("Anonymous Runnable");
			}
		};
		runnable.run();
	}

	@Test
	public void Lambda_Runnable() {
		Runnable runnable = () -> System.out.println("Lambda Runnable");
		runnable.run();
	}

	@Test
	public void test_thread() {
		new Thread(() -> System.out.println("This is cool")).start();
	}

	@Test
	public void test_thread2() {
		new Thread(() -> {
			System.out.print("This is cool");
			System.out.println(" cool");
		}).start();
	}

	interface Add {
		int add(int a, int b);
	}

	@Test
	public void test_add() {
		Add ad = (a, b) -> {
			return a + b;
		};
		Assert.assertEquals(7, ad.add(3, 4));

		Add add = (a, b) -> 10;
		Assert.assertEquals(10, add.add(100, 101));
	}

	@Test
	public void test_compare() {
		List<Integer> list = new ArrayList<>();
		list.add(9);
		list.add(3);
		list.add(7);
		Collections.sort(list, (Integer a, Integer b) -> {
			return a - b;
		});
		Assert.assertEquals(3, list.get(0).intValue());
		Assert.assertEquals(7, list.get(1).intValue());
		Assert.assertEquals(9, list.get(2).intValue());
	}

}
