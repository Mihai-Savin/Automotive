package ro.mihaisavin.automotive;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Mihai Savin @16.11.2015
 */

/**
 * Holds some Cars inside, and is able to add, find or remove Cars from itself.
 * 
 * @author Me
 *
 */
public class CarInventory {

	/**
	 * Holds the Cars inside itself.
	 * 
	 */
	private List<Car> theListOfCars = new ArrayList<Car>();

	private static final Comparator<Car> COMPARE_BY_FUEL_CONSUMPTION = new Comparator<Car>() {
		@Override
		public int compare(Car car1, Car car2) {
			return ((Float) (car1.getStandardAverageFuelConsumption()))
					.compareTo((Float) (car2.getStandardAverageFuelConsumption()));
		}
	};

	/**
	 * Adds a Car to the List.
	 * 
	 * @param aCar
	 */
	public void add(Car aCar) {
		theListOfCars.add(aCar);
		System.out.println("Car ADDED.");
	}

	/**
	 * Finds a Car based on it's unique chassis number.
	 * 
	 * 
	 * @param chassisNumber
	 * @return the Car object based on its unique chassis number
	 */
	public Car find(String chassisNumber) {
		for (Car aCar : theListOfCars) {
			if (aCar.chassisNumber.equals(chassisNumber)) {
				System.out.println("Car FOUND.");
				return aCar;
			}
		}
		System.out.println("Chassis number not found in current inventory.");
		return null;

	}

	/**
	 * Removes a Car based on it's unique chassis number.
	 * 
	 * @param chassisNumber
	 */
	public void remove(String chassisNumber) {
		theListOfCars.remove(find(chassisNumber));
		System.out.println("Car REMOVED.");
	}

	/**
	 * Orders the Car records/ objects by fuel efficiency.
	 * 
	 * @return the a list of cars that consume the least amount fuel
	 */
	public List<Car> getMostFuelEfficientCars() {
		List<Car> theCarsList = new ArrayList<Car>();
		Collections.sort(theListOfCars, COMPARE_BY_FUEL_CONSUMPTION);
		theCarsList  = theListOfCars;
		return theCarsList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((theListOfCars == null) ? 0 : theListOfCars.hashCode());
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
		CarInventory other = (CarInventory) obj;
		if (theListOfCars == null) {
			if (other.theListOfCars != null)
				return false;
		} else if (!theListOfCars.equals(other.theListOfCars))
			return false;
		return true;
	}
	

}