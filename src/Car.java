/**
 * 
 */

/**
 * @author Mihai Savin
 *
 */
/**
 * @author Me
 *
 */
public abstract class Car implements Vehicle {
	protected int tankSize;
	protected String fuelType;
	protected static final String[] FUEL_TYPES = { "PETROL", "DIESEL", "HYBRID", "ELECTRIC" };
	protected int numOfGears = 6;
	protected int currentGear = NEUTRAL;
	protected static final int FIRST = 1, SECOND = 2, THIRD = 3, FOURTH = 4, FIFTH = 5, NEUTRAL = 0, REVERSE = -1;
	protected float averageFuelConsumption; // liters per 100 KM
	protected float averagePollution; // pollution per KM
	protected float fuelAmount; // existent quantity of fuel in tank
	protected String chassisNumber;
	protected String manufacturerName;
	protected String manufacturerLicense;
	protected boolean started = false;
	/**
	 * distance driven from last start of car
	 */
	protected float distance;

	/**
	 * total consumption from since last start of car
	 */
	protected float consumption;
	/**
	 * total pollution since last start of car
	 */
	protected float pollution;


	/**
	 * @param fuelAmount
	 *            indicates how much fuel there is in the tank
	 * @param chassisNumber
	 */
	public Car(int fuelAmount, String chassisNumber) {
		this.fuelAmount = fuelAmount;
		this.chassisNumber = chassisNumber;
	}

	public Car() {
		this(-1, "JUST A DUMMY CAR. NO CHASSIS NUMBER. FOR TESTING PURPOSES");
	}

	/**
	 * @return true if in correct gear, false if in some other gear
	 */
	protected boolean checkGear() {
		if (this.currentGear > FIRST) {
			System.out.println("Please make sure you are in the correct gear(NEUTRAL, FIRST or REVERSE)");
			// this line could System.exit(1) I chose to simply return an error
			// message in the following return statement
			return false;
		}
		return true;
	}

	/**
	 * Changes form current gear to the one passed as parameter
	 * 
	 * @param gear
	 */
	public void shiftGear(int gear) {
		if ((gear < this.numOfGears) && (gear >= REVERSE)) { // checks for
																// errors
			this.currentGear = gear;
			System.out.println("Changing gear...\nCurrent gear is: " + this.currentGear);
		} else {
			System.out.println("Error: Invalid gear. Current gear is: " + this.currentGear);
			System.out.println("Exiting app...");
			System.exit(1);
		}

	}

	/**
	 * @return amount of available fuel in gas tank
	 */
	public float getAvailableFuel() {
		return this.fuelAmount;
	}

	

	/**
	 * @return the average pollution of the car
	 */
	public float getPollution() {
		return averagePollution;
	}

	/**
	 * @return  the pollution amount since the last start
	 */
	public float getTotalPollution() {
		return distance * averagePollution; 
	}

	/** Drives the Car for some distance defined as double - polymorphism
	 * @param distance
	 */
	public void drive(double distance) { // artifice for double type parameter
		this.drive((float) distance);
	}
	
	protected abstract float consume(float distance);
	
	public float getAverageFuelConsumption() {
		if (consumption != 0) {
			return consumption / distance * 100; // returns the average
													// consumption since the
													// last start of the car
		} else {
			System.out.println("Car has not consumed anything.");
			return 0f;
		}

	}

}