package org.dzhou.other.miscellaneous;

public class ParkingFee {

	public int solution(String E, String L) {
		// write your code in Java SE 8
		int total = 2 + 3;
		int parkingHour = getParkingHour(toTime(E), toTime(L));
		if (parkingHour > 1) {
			total += 4 * (parkingHour - 1);
		}
		return total;
	}

	private int getParkingHour(int[] entry, int[] left) {
		int total = left[0] - entry[0];
		int entra = (left[1] - entry[1] > 0) ? 1 : 0;
		return total + entra;
	}

	private int[] toTime(String str) {
		String[] array = str.split(":");
		int hour = Integer.parseInt(array[0]);
		int minute = Integer.parseInt(array[1]);
		return new int[] { hour, minute };
	}

}
