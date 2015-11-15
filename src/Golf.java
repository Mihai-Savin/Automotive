
/**
 * 
 */

/**
 * @author Me
 *
 */
public class Golf extends Volkswagen {
	
	
	public Golf() {
		super(); //just for testing purposes
		this.fuelType = FUEL_TYPES[1]; // diesel engine
		this.averageFuelConsumption = 4.3f;
		this.averagePollution = 20; // gramms per KM
		this.tankSize = 55;
	}

	public Golf(int fuelAmount, String chassisNumber) {
		this(); // just for testing purposes
		this.fuelAmount = fuelAmount;
		this.chassisNumber = chassisNumber;
	}

	/* (non-Javadoc) 
	 * @see Vehicle#start()
	 * Starts the Volkswagen Golf Car      WHY DOES THIS NOT SHOW IN JAVADOC??!?
	 */
	@Override
	public void start() {
		if (!this.checkGear())
			return;
		this.distance = 0; // resets the total driven distance
		this.consumption = 0; // resets the total consumption since started
		this.pollution = 0; // resets the total pollution since started
		this.started = true;
		System.out.println("Volkswagen " + this.toString() + " started.");
	}

	@Override
	public void drive(float distance) {
		if (!this.started || this.currentGear == Car.NEUTRAL) { // chechs if car
																// is started
																// and in some
																// driveable
																// gear
			System.out.println("Car not started or not in a gear. Please correct this.");
			return;
		}
		if (this.fuelAmount < 1) {
			System.out.println("Cannot drive anymore. Critical fuel level. Almost empty.");
			
			// return; //exits only the method
			System.out.println("Exiting app...");
			System.exit(1);
		} else if (this.fuelAmount < 10) {
			System.out.println("Low fuel level. Please refuel.");
		}
		float consumedFuel;
		consumedFuel = consume(distance);
		if (consumedFuel > this.fuelAmount) {
			System.out.println("Cannot drive so much, not enough fuel.");
			return;
		}
		this.distance += distance;
		this.consumption += consumedFuel;
		this.fuelAmount -= consumedFuel;
		this.pollution += distance * this.averagePollution;
	}

	

	@Override
	public void stop() {
		if (!this.started) {
			System.out.println("Cannot stop car. It is already stopped.");
			return;
		}
		this.started = false;
		System.out.println(this.toString() + " stopped.");

	}
	
	/**
	 * calculates consumption depending on gear and distance and updates total
	 * car consumption and remaining quantity of fuel
	 * 
	 * @param distance
	 *            distance driven
	 * @return quantity of consumed fuel
	 */
	/**
	 * @param distance
	 * @return
	 */
	protected float consume(float distance) { //
		float amountConsumed = distance / 100 * averageFuelConsumption; // average
																		// fuel
																		// consumed
		switch (this.currentGear) { // Optimized for most often usage of gears
		case Car.NEUTRAL:
			return 0f; // No consumption. In reality should be some liters/hour
		case Car.FIRST:
		case Car.REVERSE:
			return (float) (amountConsumed * 2.0736); // +107%
		case Car.THIRD:
			return (float) (amountConsumed * 1.44); // +44%
		case Car.SECOND:
			return (float) (amountConsumed * 1.728); // +72.8%
		case Car.FOURTH:
			return (float) (amountConsumed * 1.2); // +20%
		case Car.FIFTH:
			return (float) amountConsumed; // 5th gear has average consumption
		default:
			System.out.println("This will never be printed as no other gear is possible.");
			return -1;
		}
	}
	
	
}