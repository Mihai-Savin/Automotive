package ro.mihaisavin.automotive;
/**
 * 
 */

/**
 * @author Mihai Savin
 *
 */
public abstract class Car implements Vehicle {
	protected static final int FIRST = 1;
	protected static final int SECOND = 2;
	protected static final int THIRD = 3;
	protected static final int FOURTH = 4;
	protected static final int FIFTH = 5;
	protected static final int NEUTRAL = 0;
	protected static final int REVERSE = -1;
	protected static final String[] FUEL_TYPES = { "PETROL", "DIESEL", "HYBRID", "ELECTRIC" };
	protected int tankSize;
	protected String fuelType;
	protected int numOfGears = 6;
	protected int currentGear = NEUTRAL;
	protected float standardAverageFuelConsumption; // liters per 100 KM
	protected float averagePollution; // pollution per KM
	protected float fuelAmount; // existent quantity of fuel in tank
	protected String chassisNumber;
	protected String manufacturerName;
	protected String manufacturerLicense;
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
	protected boolean started = false;

	/**
	 * Default constructor.
	 * 
	 * @param fuelAmount
	 * 
	 *            indicates how much fuel there is in the tank
	 * @param chassisNumber
	 */
	public Car(int fuelAmount, String chassisNumber) {
		if (fuelAmount < 0) {
			throw new IllegalArgumentException("Cannot create a Car with negative fuel amount.");
		}
		if ("".equals(chassisNumber) || chassisNumber == null) {
			throw new IllegalArgumentException("Cannot create a Car with null or empty chassis number");
		}
		
		this.fuelAmount = fuelAmount;
		this.chassisNumber = chassisNumber;
	}

	/**
	 * Blank constructor.
	 */
	public Car() {
		this(0, "JUST A DUMMY CAR. NO CHASSIS NUMBER. FOR TESTING PURPOSES");
	}

	public float getStandardAverageFuelConsumption() {
		return standardAverageFuelConsumption;
	}

	/**
	 * Changes form current gear to the one passed as parameter
	 * 
	 * @param gear
	 */
	public void shiftGear(int gear) {
		if ((gear < this.numOfGears) && (gear >= REVERSE)) { // checks for
																// errors
			currentGear = gear;
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
	 * @return the pollution amount since the last start
	 */
	public float getTotalPollution() {
		return distance * averagePollution;
	}

	/**
	 * Drives the Car for some distance defined as double - polymorphism
	 * 
	 * @param distance
	 */
	public void drive(double distance) { // artifice for double type parameter
		this.drive((float) distance);
	}

	/**
	 * Calculates the average fuel consumption per session(start to stop).
	 * 
	 * @return
	 */
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chassisNumber == null) ? 0 : chassisNumber.hashCode());
		result = prime * result + ((fuelType == null) ? 0 : fuelType.hashCode());
		result = prime * result + ((manufacturerLicense == null) ? 0 : manufacturerLicense.hashCode());
		result = prime * result + ((manufacturerName == null) ? 0 : manufacturerName.hashCode());
		result = prime * result + numOfGears;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (chassisNumber == null) {
			if (other.chassisNumber != null)
				return false;
		} else if (!chassisNumber.equals(other.chassisNumber))
			return false;
		if (fuelType == null) {
			if (other.fuelType != null)
				return false;
		} else if (!fuelType.equals(other.fuelType))
			return false;
		if (manufacturerLicense == null) {
			if (other.manufacturerLicense != null)
				return false;
		} else if (!manufacturerLicense.equals(other.manufacturerLicense))
			return false;
		if (manufacturerName == null) {
			if (other.manufacturerName != null)
				return false;
		} else if (!manufacturerName.equals(other.manufacturerName))
			return false;
		if (numOfGears != other.numOfGears)
			return false;
		return true;
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
	 * Consumes a specific amount of fuel depending on the distance and the
	 * current gear.
	 * 
	 * @param distance
	 * @return
	 */
	protected abstract float consume(float distance);

}