package org.dzhou.other.miscellaneous;

import java.util.Random;

import org.junit.Test;

public class SortTest {

	private int[] array = { 5, 4, 6, 7, 8, 1, 2, 3 };

	@Test
	public void testBubble() {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	@Test
	public void bucketSort() {
		Random random = new Random();
		int[] toBeSorted = new int[20];
		for (int i = 0; i < toBeSorted.length; i++) {
			toBeSorted[i] = random.nextInt(25);
		}
		print(toBeSorted);

		int[] bucket = new int[25 + 1];
		print(bucket);
		
		for (int num : toBeSorted) {
			bucket[num] = num;
		}

		print(bucket);
		for (int num : bucket) {
			if (num != 0)
				System.out.print(num + ", ");
		}
	}

	private void print(int[] array) {
		for (int num : array) {
			System.out.print(num + ", ");
		}
		System.out.println();
	}

}
