
//There are 8 methods most of which could be used in the future

//package ohiohealth;

//hey add some notes

//hey add some notes

//hey add some notes

//hey add some notes

//hey add some notes

//hey add some notes

//hey add some notes


/* Testing is good ir */

/* Testing redo */

/**
 * Actually I could rename it to a Sitter(1) so their would be a Babysitter(2),
 *  a Childsitter(3), and a Teensitter(4).
 *  That would be four objects in all.
*/
/**
 * This young person is a toddler and is going to bed at 8:00 PM.
 * So that is 3 hours + 4 hours + 4 hours = 11 Hours total.
 * 
 */
// maybe that will fix it
public class Babysitter {

	private int mRegularPayRate = 12;
	private int mBedtimePayRate = 8;
	private int mMidnightPayRate = 16;

	private static int regularPayRate = 12;
	private static int bedtimePayRate = 8;
	private static int midnightPayRate = 16;
	private static int startTime = 5;// 3 hours
	private static int bedTime = 8;// 4 hours
	private static int endTime = 4;// 4 hours

	public Babysitter() {
		System.out.println("In the no arg Babysitter Constructor " + "\n");
	}

	public Babysitter(int regularPayRate, int bedtimePayRate, int midnightPayRate) {
		super();
		System.out.println("In the 3 argument Babysitter Constructor " + "\n");

		mRegularPayRate = regularPayRate = 12;// The regularPayRate =
												// regularPayRate
		mBedtimePayRate = bedtimePayRate = 8;// The bedtimePayRate
												// mBedtimePayRate
		mMidnightPayRate = midnightPayRate = 16;// The midnightPayRate =
												// midnightPayRate

	}

	public static void main(String[] args) {

		// Babysitter aSitter = new Babysitter(int regularPayRate,int
		// bedtimePayRate int midnightPayRate);
		// lets see if I can fix the () above
		
		int x = 3 & 5;
		int y = 3 | 5;
		
		System.out.println("the values x is  " +x) ;
		System.out.println("the values y is  " +y) ;

		Babysitter aSitter = new Babysitter(regularPayRate, bedtimePayRate, midnightPayRate);

		System.out.println("I just did a Babysitter who's regularPayRate is " + aSitter.regularPayRate + "\n");

		System.out.println("Your regularPayRate is " + regularPayRate + "\n");

		System.out.println("Your bedtimePayRate is " + bedtimePayRate + "\n");

		System.out.println("Your midnightPayRate is " + midnightPayRate + "\n");

		Babysitter Hello = new Babysitter();

		Hello.convertTime(12);

		int amount = Hello.convertTime(12);

		System.out.println("The amount is " + amount + "\n");

		Hello.convertTime(8);

		amount = Hello.convertTime(8);

		//System.out.println("Now The amount is " + amount + "\n");

		Hello.convertTime(16);

		amount = Hello.convertTime(16);

		//System.out.println("Now The amount is EVEN MORE " + amount + "\n");

		Hello.calculateTotalPay(3, 4, 4);
		int mytotal = Hello.calculateTotalPay(3, 4, 4);

		System.out.println(" The TOTAL IS $" + mytotal + " dollars for working 11 Hours" + "\n");

		Hello.calculateShiftWage(3, 4, 4);
		mytotal = Hello.calculateTotalPay(3, 4, 4);
		System.out.println(" The TOTAL IS with the new method is $" + mytotal + " dollars for working 11 Hours" + "\n");

		Babysitter Sitter = new Babysitter(12, 18, 16);
		
		//Ok lets see what the Sitter can do here
		//11/28/20
		Sitter.calculateTotalPay(3, 4, 4);
		mytotal= Sitter.calculateTotalPay(3, 4, 4);
		System.out.println(" The TOTAL IS $********** " + mytotal + " dollars for working 11 Hours" + "\n");
		System.out.println(" The TOTAL IS with the new method is $**********" + mytotal + " dollars for working 11 Hours" + "\n");
		int aTime = Sitter.convertTime(8);
		System.out.println("The time of the Sitter is "+aTime+ "\n");
		
		aTime= Sitter.calculateMidnightShiftHours(endTime);
		System.out.println("The MidnightShiftHour of the Sitter is "+aTime+ "\n");
		
		aTime = Sitter.calculateBedtimeShiftHours(3, 4, 4);
		System.out.println("The calculateBedtimeShiftHours of the Sitter is "+aTime+ "\n");

	}

	/**
	 * The convertTime method could be used by the sitter or the parents where
	 * they are requiring that the sitter input their time.
	 **/

	public int convertTime(int inputTime) {

		if (inputTime <= 12 && inputTime >= 5) {
			return inputTime - 5;
		} else
			return inputTime + 7;

	}

	/**
	 * Method is not being utilized but may be in the future.
	 * The method validateStartTime validates the sitter's starTime.
	 * 
	 **/

	public boolean validateStartTime(int startTime) {

		if (convertTime(startTime) < 11) {
			return true;
		} else
			return false;

	}

	/**
	 *  Method is not being utilized but may be in the future.
	 * The method validateEndTime validates the sitter's endTime.
	 **/

	public boolean validateEndTime(int endTime, int startTime) {

		if (convertTime(endTime) > convertTime(startTime)) {
			return true;
		} else
			return false;

	}

	/**
	 * Method is not being utilized but may be in the future.
	 * The method validateBedTime validates the for sitter by converting the times of
	 * bedTime, startTime, and endTime.
	 **/

	public boolean validateBedTime(int bedTime, int startTime, int endTime) {

		if (convertTime(startTime) <= convertTime(bedTime) && convertTime(bedTime) <= convertTime(endTime)) {
			return true;
		} else
			return false;

	}

	/**
	 * Method is not being utilized but may be in the future. 
	 * The method is for calculating the sitter's Midnight Shift Hours.
	 * 
	 */
	public int calculateMidnightShiftHours(int endTime) {

		if (convertTime(endTime) > convertTime(12)) {
			return convertTime(endTime) - convertTime(12);
		} else
			return 0;

	}

	/**
	 * Method is not being utilized but may be in the future. 
	 * The method is for calculating the sitter's Bedtime Shift Hours.
	 * 
	 */

	public int calculateBedtimeShiftHours(int startTime, int endTime, int bedTime) {

		if (convertTime(startTime) < convertTime(12)) {
			return convertTime(12) - convertTime(bedTime);
		} else
			return 0;

	}

	/**
	 * Method is not being utilized but may be in the future. 
	 * The method is for calculating the sitter's Regular Shift Hours.
	 */

	public int calculateRegularShiftHours(int startTime, int endTime, int bedTime) {

		if (convertTime(bedTime) >= convertTime(12)) {
			return convertTime(12) - convertTime(startTime);
		} else if (convertTime(bedTime) < convertTime(12)) {
			return convertTime(bedTime) - convertTime(startTime);
		} else
			return 0;

	}

	/**
	 * This seems to be one of 2 methods needed unless the babysitter is
	 * entering their time in some application where input is needed.
	 */

	public int calculateTotalPay(int startTime, int bedTime, int endTime) {

		return (calculateRegularShiftHours(startTime, endTime, bedTime) * regularPayRate)
				+ (calculateBedtimeShiftHours(startTime, endTime, bedTime) * bedtimePayRate)
				+ (calculateMidnightShiftHours(endTime) * midnightPayRate);

	}

	/**
	 * This seems to be one of 2 methods needed unless the babysitter is
	 * entering their time in some application where input is needed.
	 */

	public int calculateShiftWage(int startingHour, int endingHour, int bedtime) {

		return (calculateRegularShiftHours(startTime, endTime, bedTime) * regularPayRate)
				+ (calculateBedtimeShiftHours(startTime, endTime, bedTime) * bedtimePayRate)
				+ (calculateMidnightShiftHours(endTime) * midnightPayRate);
	}

	/**
	 * The method getmRegularPayRate() returns the regular payrate,
	 * @return
	 */
	public int getmRegularPayRate() {
		return mRegularPayRate;
	}
/**
 * The method sets the regular pay rate.
 * @param mRegularPayRate
 */
	public void setmRegularPayRate(int mRegularPayRate) {
		this.mRegularPayRate = mRegularPayRate;
	}

	public int getmBedtimePayRate() {
		return mBedtimePayRate;
	}

	public void setmBedtimePayRate(int mBedtimePayRate) {
		this.mBedtimePayRate = mBedtimePayRate;
	}

	public int getmMidnightPayRate() {
		return mMidnightPayRate;
	}

	public void setmMidnightPayRate(int mMidnightPayRate) {
		this.mMidnightPayRate = mMidnightPayRate;
	}

	public static int getRegularPayRate() {
		return regularPayRate;
	}

	public static void setRegularPayRate(int regularPayRate) {
		Babysitter.regularPayRate = regularPayRate;
	}

	public static int getBedtimePayRate() {
		return bedtimePayRate;
	}

	public static void setBedtimePayRate(int bedtimePayRate) {
		Babysitter.bedtimePayRate = bedtimePayRate;
	}

	public static int getMidnightPayRate() {
		return midnightPayRate;
	}

	public static void setMidnightPayRate(int midnightPayRate) {
		Babysitter.midnightPayRate = midnightPayRate;
	}

	public static int getStartTime() {
		return startTime;
	}

	public static void setStartTime(int startTime) {
		Babysitter.startTime = startTime;
	}

	public static int getBedTime() {
		return bedTime;
	}

	public static void setBedTime(int bedTime) {
		Babysitter.bedTime = bedTime;
	}

	public static int getEndTime() {
		return endTime;
	}

	public static void setEndTime(int endTime) {
		Babysitter.endTime = endTime;
	}

}
