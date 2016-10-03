package org.dzhou.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 401. Binary Watch
 * 
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and
 * the 6 LEDs on the bottom represent the minutes (0-59).
 * 
 * Each LED represents a zero or one, with the least significant bit on the
 * right.
 * 
 * Given a non-negative integer n which represents the number of LEDs that are
 * currently on, return all possible times the watch could represent.
 * 
 * Example:
 * 
 * Input: n = 1
 * 
 * Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08",
 * "0:16", "0:32"]
 * 
 * Note:
 * 
 * The order of output does not matter.
 * 
 * The hour must not contain a leading zero, for example "01:00" is not valid,
 * it should be "1:00".
 * 
 * The minute must be consist of two digits and may contain a leading zero, for
 * example "10:2" is not valid, it should be "10:02".
 * 
 * @author zhoudong
 *
 */
public class BinaryWatch {

	public List<String> readBinaryWatch(int num) {
		List<String> list = new ArrayList<>();
		// 用来表示时间的所有可能的取值
		int timecode[] = new int[10];
		dfs(timecode, 0, 0, list, num);
		return list;
	}

	// dfs 遍历所有可能性
	private void dfs(int[] timecode, int i, int k, List<String> list, int num) {
		if (k == num) {
			String res = decodeToTime(timecode);
			if (res != null)
				list.add(res);
			return;
		}
		if (i == timecode.length)
			return;
		timecode[i] = 1;
		dfs(timecode, i + 1, k + 1, list, num);
		timecode[i] = 0;
		dfs(timecode, i + 1, k, list, num);
	}

	// 输出时间，即输出可能的时间，要是时间不对则输出null
	private String decodeToTime(int[] timecode) {
		int hours = 0;
		// 按照位数转换时间
		for (int i = 0; i < 4; i++) {
			if (timecode[i] == 1) {
				hours = hours + (int) Math.pow(2, i);
			}
		}
		int minutes = 0;
		for (int i = 4; i < 10; i++) {
			if (timecode[i] == 1) {
				minutes = minutes + (int) Math.pow(2, i - 4);
			}
		}
		String min = "" + minutes;
		if (minutes < 10)
			min = "0" + min;
		// 判断时间的可行性
		if (hours >= 12 || minutes >= 60)
			return null;
		return hours + ":" + min;
	}
}
