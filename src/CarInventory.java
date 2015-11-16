import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * This class holds the cars inside a map.
 * 
 * @author Me
 *
 */
public class CarInventory {
	private List<Car> carsList = new ArrayList<Car>();

	public void addCar(Car aCar) {
		carsList.add(aCar);
	}

	/**
	 * @param chassisNumber
	 * @return the car object based on its unique chassis number
	 */
	public Car findCar(String chassisNumber) {

		Car dummyCar = new Logan(5, "SOME001DUMMY123CHASSIS456NUMBER99");

		return dummyCar;

	}

	public void removeCar(String chassisNumber) {
		System.out.println("CAR REMOVED");

	}
	
	/**
	 * @return  the a list of cars that consume the least amount fuel
	 */
	public List<Car> getMostFuelEfficientCars() {
		List<Car> aCarsList = new ArrayList<Car>();
		aCarsList.add(new Logan(5, "ASSAAAVVV"));
		aCarsList.add(new Logan(10, "WASSAAAVVV"));
		return aCarsList;
		
	}

	

}
