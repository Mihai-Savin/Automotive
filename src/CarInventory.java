import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * Holds some Cars inside, and is able to add, find or remove Cars from itself.
 * 
 * @author Me
 *
 */
public class CarInventory {
	/** Holds the Cars inside itself.
	 * 
	 */
	private List<Car> carsList = new ArrayList<Car>();

	/** Adds a Car to the List.
	 * @param aCar
	 */
	public void addCar(Car aCar) {
		carsList.add(aCar);
	}

	/**
	 * Finds a Car based on it's unique chassis number.
	 * 
	 * @param chassisNumber
	 * @return the Car object based on its unique chassis number
	 */
	public Car findCar(String chassisNumber) {

		for (Car aCar : carsList) {
			if (aCar.chassisNumber.equals(chassisNumber)) {
				return aCar;
			}
		}
		System.out.println("Chassis number not found in current inventory.");
		return null;

	}

	public void removeCar(String chassisNumber) {
		carsList.remove(findCar(chassisNumber));
		System.out.println("CAR REMOVED");

	}

	/**
	 * @return the a list of cars that consume the least amount fuel
	 */
	public List<Car> getMostFuelEfficientCars() {
		List<Car> aCarsList = new ArrayList<Car>();
		aCarsList.add(new Logan(5, "ASSAAAVVV"));
		aCarsList.add(new Logan(10, "WASSAAAVVV"));
		return aCarsList;

	}

}
