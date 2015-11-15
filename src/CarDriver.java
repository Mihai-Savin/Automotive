/**
 * 
 */

/**
 * @author Meehai Savin
 *
 */

public class CarDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CarDriver someCarDriver = new CarDriver();	//Anonymous object that handles some Car objects for demo purposes
		someCarDriver.handleCars();
	}
	/**
	 * 
	 */
	private void handleCars() {
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



		Vehicle vehicle = new Golf(30, "1987ddkshik289"); //available fuel and chassis number

		vehicle.start();

		vehicle.drive(1);

		vehicle.stop();

		Car car1 = (Car) vehicle;

		float availableFuel1 = car1.getAvailableFuel();

		float fuelConsumedPer100Km1 = car1.getAverageFuelConsumption();

		float pollutionPerKm1 = car1.getPollution();
		
		System.out.println("Available fuel: " + availableFuel1);
		System.out.println("Average session fuel consumption: " + fuelConsumedPer100Km1);
		System.out.println("Pollution: " + pollutionPerKm1);

		
		
	}

}
