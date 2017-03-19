package org.dzhou.leetcode;

import java.util.List;

/**
 * 539. Minimum Time Difference
 * 
 * Given a list of 24-hour clock time points in "Hour:Minutes" format, find the
 * minimum minutes difference between any two time points in the list.
 * 
 * Example 1: Input: ["23:59","00:00"] Output: 1
 * 
 * Note:
 * 
 * The number of time points in the given list is at least 2 and won't exceed
 * 20000.
 * 
 * The input time is legal and ranges from 00:00 to 23:59.
 * 
 * @author zhoudong
 *
 */
public class MinimumTimeDifference {

	public int findMinDifference(List<String> timePoints) {

		boolean[] mark = new boolean[24 * 60];

		for (String time : timePoints) {
			int seconds = getSeconds(time);
			if (mark[seconds])
				return 0;
			mark[seconds] = true;
		}

		int minInterval = findMinInterval(mark);
		int lastToFirst = intervalLastToFirst(mark);

		return Math.min(minInterval, lastToFirst);
	}

	private int intervalLastToFirst(boolean[] mark) {
		return findFirst(mark) + mark.length - findLast(mark);
	}

	private int findFirst(boolean[] mark) {
		for (int i = 0; i < mark.length; i++) {
			if (mark[i]) {
				return i;
			}
		}
		return -1;
	}

	private int findLast(boolean[] mark) {
		for (int i = mark.length - 1; i >= 0; i--) {
			if (mark[i]) {
				return i;
			}
		}
		return -1;
	}

	private int findMinInterval(boolean[] mark) {
		int prev = -1, min = Integer.MAX_VALUE;
		for (int i = 0; i < mark.length; i++) {
			if (!mark[i]) {
				continue;
			}
			if (prev == -1) {
				prev = i;
				continue;
			}
			min = Math.min(min, i - prev);
			prev = i;
		}
		return min;
	}

	private int getSeconds(String time) {
		String[] strs = time.split(":");
		return getSeconds(strs[0], strs[1]);
	}

	private int getSeconds(String minutes, String seconds) {
		return getSeconds(Integer.parseInt(minutes), Integer.parseInt(seconds));

	}

	private int getSeconds(int minutes, int seconds) {
		return minutes * 60 + seconds;
	}

}
