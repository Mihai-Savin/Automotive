import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author Meehai Savin 
 * Created @16.11.2015
 *
 */
public class CarWash {

	/**
	 * Opens the CarWash for business.
	 */
	public void openShop() {
		System.out.println("Shop OPENED.");
		
	}

	/**
	 * Inserts a Car in the queue for washing.
	 * @param theCar
	 */
	public void standInLine(Car aCar) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Washes the first car in queue.
	 */
	public void washCar() {
		System.out.println("Car WASHED.");		
	}

	
	/**
	 * Closes the CarWash for business.
	 */
	public void closeShop() {

		System.out.println("Shop CLOSED.");
		
	}

	
	/**
	 * Generates the List of cars that where washed today.
	 * @return a List of Cars. 
	 */
	public List<Car> getTodaysClients() {

		List<Car> theCarsList = new ArrayList<Car>();
		theCarsList.add(new Logan(5, "ASSAAAVVV"));
		theCarsList.add(new Logan(10, "WASSAAAVVV"));
		theCarsList.add(new Logan(10, "XWASSAAAVVV"));
		return theCarsList;		
	}

		
	/**
	 * Generates the List of cars that where not washed today.
	 * @return a list of Cars.
	 */
	public List<Car> getPostponedClients() {
		List<Car> theCarsList = new ArrayList<Car>();
		theCarsList.add(new Logan(5, "ASSAAAVVV"));
		theCarsList.add(new Logan(10, "WASSAAAVVV"));
		theCarsList.add(new Logan(10, "XWASSAAAVVV"));
		return theCarsList;		

	}
	
}
