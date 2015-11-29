package ro.mihaisavin.automotive;
import java.util.ArrayList;
import java.util.List;

/**
 *  This class fools around with some Cars for demo & testing purposes.
 */

/**
 * @author Meehai Savin
 *
 */

public class CarDriver {

	public static void main(String[] args) {
		CarDriver someCarDriver = new CarDriver(); // This object is able to
													// handle some Cars for demo
													// & testing purposes.
		try {
			someCarDriver.handleCars();
		} catch (NotEnoughFuelException e) {
			System.out.println("There was a car that tried to dirve a distance without having enoug fuel in the tank.");
			e.printStackTrace();
		}
	}

	/**
	 * Fools around with some random hard-coded Cars
	 * @throws NotEnoughFuelException 
	 */
	private void handleCars() throws NotEnoughFuelException {
		registerCars();		//Car Inventory Homework
		washCars();		//Car washing HW
		driveCars(); //Legacy HW

	}

	@SuppressWarnings("deprecation")
	private void driveCars() throws NotEnoughFuelException {
		
		System.out.println("------------------CARS DRIVING-----------------");

		Logan jimmy = new Logan(30, "SAAVVVZZ877887");
		jimmy.shiftGear(Car.FIRST);
		jimmy.start();
		jimmy.drive(10);
		jimmy.shiftGear(Car.FIFTH);
		jimmy.drive(200);
		jimmy.drive(20.1);
		jimmy.drive(0.2);

		jimmy.stop();

		Car car = new Logan(27, "oiqe0934hkkadsn");

		car.start();

		car.shiftGear(1); // shifts to first gear

		car.drive(0.01);// drives 0.01 KMs

		car.shiftGear(2);

		car.drive(0.02);

		car.shiftGear(3);

		car.drive(0.5);

		car.shiftGear(4);

		car.drive(0.5);

		car.shiftGear(4);

		car.drive(0.5);

		car.shiftGear(5);

		car.drive(10);

		car.shiftGear(4);

		car.drive(0.5);

		car.shiftGear(3);

		car.drive(0.1);

		car.stop();

		float availableFuel = car.getAvailableFuel();

		float fuelConsumedPer100Km = car.getAverageFuelConsumption();

		float pollutionPerKm = car.getPollution();

		System.out.println("Available fuel: " + availableFuel);
		System.out.println("Average session fuel consumption: " + fuelConsumedPer100Km);
		System.out.println("Pollution: " + pollutionPerKm);

		Vehicle vehicle = new Golf(30, "1987ddkshik289"); // available fuel and
															// chassis number

		vehicle.start();
		

		try {
			vehicle.drive(1);
		} catch (IllegalStateException e) {			
			System.out.println(e.getMessage());
		}

		vehicle.stop();

		Car car11 = (Car) vehicle;

		float availableFuel1 = car11.getAvailableFuel();

		float fuelConsumedPer100Km1 = car11.getAverageFuelConsumption();

		float pollutionPerKm1 = car11.getPollution();

		System.out.println("Available fuel: " + availableFuel1);
		System.out.println("Average session fuel consumption: " + fuelConsumedPer100Km1);
		System.out.println("Pollution: " + pollutionPerKm1);

	}

	private void washCars() {
		
		System.out.println("------------------CARS WASHING-----------------");
		
		CarWash carWash = new CarWash();

//		String aChassisNumber = "SOME123CHASSIS000NUMBER";
		Car car1 = new Logan(5, "SOME123CHASSIS000NUMBER");
		Car car2 = new Logan(5, "SOME456CHASSIS000NUMBER");
		Car car3 = new Golf(5, "SOME789CHASSIS000NUMBER");
//		Car car4 = new Golf(10, "SOME999CHASSIS000NUMBER");

		carWash.openShop();

		carWash.standInLine(car1); // car stands in line to get washed.

		carWash.standInLine(car2); // car2 stands in line to get washed.

		carWash.washCar(); // will wash the first car standing in line, which is
							// car1

		carWash.standInLine(car3);

		carWash.washCar(); // will wash the next car standing in line, which is
							// car2

		carWash.standInLine(car1);

		carWash.washCar();

		carWash.standInLine(car2);

		carWash.standInLine(car3);

		carWash.standInLine(car3);

		carWash.closeShop();

		List<Car> todaysClients = carWash.getTodaysClients(); // returns all
																// clients that
																// have visited
																// the shop
																// today. If car
																// was washed
																// twice, it
																// should be
																// returned
																// once.

		System.out.println("Today the following Cars were washed: \n" + todaysClients);

		List<Car> postponedClients = carWash.getPostponedClients(); // returns a
																	// list of
																	// clients
																	// who did
																	// not get
																	// to have
																	// their car
																	// washed.
																	// The shop
																	// closed
																	// while
																	// they were
																	// standing
																	// in line.

		System.out.println("Today the following Cars were left unwashed: \n" + postponedClients);

	}

	private void registerCars() {
		
		System.out.println("------------------CARS INVENTORY-----------------");
		
		CarInventory ci = new CarInventory();

		String aChassisNumber = "SOME123CHASSIS000NUMBER";
		Car car1 = new Logan(5, "SOME123CHASSIS000NUMBER");
		Car car2 = new Logan(5, "SOME456CHASSIS000NUMBER");
		Car car3 = new Golf(5, "SOME789CHASSIS000NUMBER");
		Car car4 = new Golf(10, "SOME999CHASSIS000NUMBER");
		ci.add(car1);
		ci.add(car2);
		ci.add(car3);
		ci.add(car4);

		System.out.println("Most fuel eficient cars in descending order are: " + ci.getMostFuelEfficientCars());

		Car theCar = ci.find(aChassisNumber); // clones a car object based on
													// its unique chassis number

		System.out.println("The Car which has " + aChassisNumber + " is: " + theCar);

		ci.remove(aChassisNumber); // removes the car from the collection if
										// it exists

		theCar = ci.find(aChassisNumber);
		System.out.println("The Car which has " + aChassisNumber + " is: " + theCar);

		List<Car> aCarsList = new ArrayList<Car>();

		aCarsList = ci.getMostFuelEfficientCars(); // returns the cars that
													// consume the least amount
													// fuel.

		System.out.println(aCarsList);

	}

}
