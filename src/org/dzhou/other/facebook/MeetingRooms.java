package org.dzhou.other.facebook;

import java.util.Arrays;

/**
 * 252. Meeting Rooms
 * 
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all
 * meetings.
 * 
 * For example, Given [[0, 30],[5, 10],[15, 20]], return false.
 * 
 * @author zhoudong
 *
 */
public class MeetingRooms {

	// Definition for an interval.
	class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	class Solution {

		public boolean canAttendMeetings(Interval[] intervals) {
			Arrays.sort(intervals, (Interval o1, Interval o2) -> {
				return o1.start - o2.start;
			});
			for (int i = 0; i < intervals.length - 1; i++) {
				if (isOverLap(intervals[i], intervals[i + 1])) {
					return false;
				}
			}
			return true;
		}

		private boolean isOverLap(Interval current, Interval next) {
			return current.end > next.start;
		}

	}

}
