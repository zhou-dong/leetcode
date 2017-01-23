package org.dzhou.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class PhoneBill {

	public int solution(String S) {

		Map<String, PhoneNumber> calls = new HashMap<>();
		for (String log : S.split("\n")) {
			String[] entry = log.split(",");
			String phoneNumber = entry[1];
			int duration = getSeconds(entry[0]);
			addToMap(calls, phoneNumber, duration);
		}

		PriorityQueue<PhoneNumber> heap = new PriorityQueue<>();
		for (PhoneNumber call : calls.values()) {
			heap.add(call);
		}

		heap.poll();
		int total = 0;
		while (!heap.isEmpty()) {
			PhoneNumber phone = heap.poll();
			for (int duration : phone.durations) {
				total += calPrice(duration);
			}
		}

		return total;
	}

	private void addToMap(Map<String, PhoneNumber> map, String key, int value) {
		if (!map.containsKey(key))
			map.put(key, new PhoneNumber(key));
		map.get(key).addDuration(value);
	}

	class PhoneNumber implements Comparable<PhoneNumber> {
		String number;
		int totalDuration;
		List<Integer> durations;

		PhoneNumber(String number) {
			this.number = number;
			this.totalDuration = 0;
			this.durations = new ArrayList<>();
		}

		public void addDuration(int duration) {
			this.durations.add(duration);
			this.totalDuration += duration;
		}

		@Override
		public int compareTo(PhoneNumber other) {
			if (this.totalDuration == other.totalDuration) {
				return this.number.compareTo(other.number);
			} else {
				return other.totalDuration - this.totalDuration;
			}
		}
	}

	private int getSeconds(String time) {
		int total = 0;
		for (String entry : time.split(":")) {
			total = total * 60 + Integer.parseInt(entry);
		}
		return total;
	}

	private int calPrice(int seconds) {
		if (seconds < 300) {
			return 3 * seconds;
		} else {
			return 150 * secondsToMinutes(seconds);
		}
	}

	private int secondsToMinutes(int seconds) {
		int minutes = seconds / 60;
		int extra = (seconds % 60 == 0) ? 0 : 1;
		return minutes + extra;
	}

	public static void main(String[] args) {
		String S = "00:01:07,400-234-090\n00:05:01,701-080-080\n00:05:00,400-234-090";
		System.out.println(new PhoneBill().solution(S));
	}

}
