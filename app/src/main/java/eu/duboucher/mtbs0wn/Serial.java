package eu.duboucher.mtbs0wn;

import java.util.Random;

/**
 * Checksum. Implementation left to the user. :)
 */
class Serial {
	private static final Random RANDOM = new Random();
	final int v1;
	final int v2;
	final int month;
	final int day;
	final int id;
	final int c;

	private Serial() {
		v1 = 9183;
		v2 = 53;
		month = 9;
		day = 30;
		id = RANDOM.nextInt(10000);
		c = 0;
	}

	static Serial generateSerial() {
		return new Serial();
	}
}
