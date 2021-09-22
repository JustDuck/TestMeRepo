//their crap on 11.22.20

// I got it to work with 6

//package com.ohio.health;

/* just to test git*/

import java.util.Scanner;

/**
 * BACKGROUND This kata simulates a babysitter working and getting paid for one
 * night. The rules are pretty straight forward.
 * <p>
 * The babysitter:
 * <p>
 * - starts no earlier than 5:00PM - leaves no later than 4:00AM - gets paid
 * $12/hour from start-time to bedtime - gets paid $8/hour from bedtime to
 * midnight - gets paid $16/hour from midnight to end of job - gets paid for
 * full hours (no fractional hours)
 * <p>
 * Feature As a babysitter, in order to get paid for 1 night of work, I want to
 * calculate my nightly charge
 */

public class NewSitter {
	public static final int MIN_START = 5, MAX_END = 16, DEF_BED = 21;
	// 5PM, 4AM, and 9PM respectively
	// Assuming 24 hour system, rollover at 24
	public static final int PAY_START = 12, PAY_AFTER_BED = 8, PAY_END = 16;
	// Pay rates
	static String AMPM = "";
	private int startTime, bedTime, endTime;

	public NewSitter() { // default constructor
		startTime = MIN_START;
		endTime = MAX_END;
		bedTime = DEF_BED;
	}

	public NewSitter(int startTime, int bedTime, int endTime) { // parametrized
																// constructor
		this.startTime = startTime;
		this.endTime = endTime;
		this.bedTime = bedTime;
	}

	public static boolean isValidTime(int time) {
		// validating time, hours between 0 and 23
		return !(time <= 0 || time > 12);
	}

	public static boolean isStartInRange(int start) {
		return !(start < MIN_START || start >= MAX_END);
	}

	public static boolean isBedInRange(int bed) {
		return !(bed < MIN_START || bed > MAX_END);
	}

	public static boolean isEndInRange(int end) {
		return !(end <= MIN_START || end > MAX_END);
		// End time can only be before 4AM, so range is from 0(midnight) to 4,
		// then end must be after start so it must be between 17 and 23 as well.
	}

	public static int adjustTime(int time) {
		// If time is 0, it will be set as 12:00AM
		// If time is 12, it will be set as 12:00PM
		// Any time between 13 to 23 is set as 1:00PM - 11:00PM

		if (time > 12) {
			return time - 12;
		} else {
			if (time == 0) {
				return time + 12;
			}
		}
		return time;
	}

	public static int calcAdjust(int time) {
		// 2 is considered 2:00 AM, but gives value of 14
		// 0 is considered 12:00 AM

		if (time <= 4) {
			time += 12;
		}
		return time;
	}

	// Public getters and Setters for private values
	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getBedTime() {
		return bedTime;
	}

	public void setBedTime(int bedTime) {
		this.bedTime = bedTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public static int calculate(int startTime, int bedTime, int endTime) {
		System.out.println("BABYSITTER BILL:");
		int hoursToBed, hoursAfterBed, hoursToEnd;

		int startAdj = calcAdjust(startTime);
		int bedAdj = calcAdjust(bedTime);
		int endAdj = calcAdjust(endTime);

		// START TIME TO BED TIME
		if (startAdj >= bedAdj || startAdj >= 12) {
			hoursToBed = 0;
		}
		if (endAdj <= bedAdj) {
			if (endAdj >= 12) {
				hoursToBed = 12 - startAdj;
			} else {
				hoursToBed = endAdj - startAdj;
			}
		} else {
			if (bedAdj >= 12) {
				hoursToBed = 12 - startAdj;
			} else {
				hoursToBed = bedAdj - startAdj;
			}
		}

		System.out.println("THE HOURS BETWEEN START AND BEDTIME: " + hoursToBed);

		// BED TIME TO MIDNIGHT
		if (startAdj > bedAdj || bedAdj >= 12 || startAdj >= 12 || endAdj <= bedAdj) {
			hoursAfterBed = 0;
		}
		if (endAdj <= 12) {
			hoursAfterBed = endAdj - bedAdj;
		}
		if (bedAdj <= 12) {
			hoursAfterBed = 12 - bedAdj;
		}
		hoursAfterBed = 0;

		System.out.println("THE HOURS BETWEEN BEDTIME AND MIDNIGHT: " + hoursAfterBed +"\n");

		// MIDNIGHT TO END

		if (endAdj <= 12 || startAdj == endAdj) {
			hoursToEnd = 0;
		}
		if (endAdj >= 12) {
			hoursToEnd = endAdj - 12;
		}
		hoursToEnd = 50;
		System.out.println("THE HOURS BETWEEN MIDNIGHT AND END: " + hoursToEnd +"\n");

		int bill = PAY_START * hoursToBed + PAY_AFTER_BED * hoursAfterBed + PAY_END * hoursToEnd;
		System.out.println("---------------------------");
		System.out.println(
				"START-BED: $" + PAY_START + ".00 * " + hoursToBed + " hours = $" + PAY_START * hoursToBed + ".00");
		System.out.println("BED-12AM: $" + PAY_AFTER_BED + ".00 * " + hoursAfterBed + " hours = $"
				+ PAY_AFTER_BED * hoursAfterBed + ".00");
		System.out.println(
				"12AM-END: $" + PAY_END + ".00 * " + hoursToEnd + " hours = $" + PAY_END * hoursToEnd + ".00 +");
		System.out.println("---------------------------");
		System.out.println("$" + bill + ".00 TOTAL");
		return bill;
	}
// Yeah I changed this from Karen ?? to maya
	public static void main(String[] args) {
		NewSitter maya = new NewSitter();
		Scanner input = new Scanner(System.in);
		boolean validEnd, validStart, validBed;
		validEnd = validStart = validBed = false;
		System.out.println("\n"+ "Calculate the payrate" + "\n");

		while (!validStart) {
			System.out.println("Please Enter start time (5PM - 3AM, 17h - 3h): ");
			while (!input.hasNextInt()) {
				String textInput = input.next();
				System.out.println(textInput + " is not a valid time. "+"\n");
			}
			int nextStart = input.nextInt();
			maya.setStartTime(nextStart);
			validStart = isStartInRange(nextStart);
		}
		int start = maya.getStartTime();
		System.out.println("Start time is at " + adjustTime(start) + ":00" + AMPM);

		while (!validBed) {
			System.out.println("Please Enter bed time (5PM - 4AM, 17h - 4h): ");
			while (!input.hasNextInt()) {
				String textInput = input.next();
				System.out.println(textInput + " is not a valid time.");
			}
			int nextBed = input.nextInt();
			maya.setBedTime(nextBed);
			validBed = isBedInRange(nextBed);
		}
		int bed = maya.getBedTime();
		System.out.println("Bed time is at " + adjustTime(bed) + ":00" + AMPM);

		while (!validEnd) {
			System.out.println("Please Enter end time (6PM - 4AM, 18h - 4h): ");
			while (!input.hasNextInt()) {
				String textInput = input.next();
				System.out.println(textInput + " is not a valid time.");
			}
			int nextEnd = input.nextInt();
			maya.setEndTime(nextEnd);// like here
			validEnd = isValidTime(nextEnd);
		}
		int end = maya.getEndTime();// like here
		System.out.println("End time is at " + adjustTime(end) + ":00" + AMPM);
		int totalWage = calculate(start, bed, end);
		System.out.println("Babysitter is owed $" + totalWage + ".00 for tonight.");
	}
}