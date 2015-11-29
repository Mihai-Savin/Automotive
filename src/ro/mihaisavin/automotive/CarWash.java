package ro.mihaisavin.automotive;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author Meehai Savin Created @16.11.2015
 *
 */
public class CarWash {
	private boolean open;
	private byte currentCar = 0;
	private byte lastWashedCar = -1;
	private ArrayList<Car> carsList = new ArrayList<Car>(); // Holds the Cars
															// waiting to be
															// washed.

	/**
	 * Opens the CarWash for business.
	 */
	public void openShop() {
		setOpen(true);
		System.out.println("Shop OPENED.");
	}

	/**
	 * Inserts a Car in the queue for washing.
	 * 
	 * @param theCar
	 */
	public void standInLine(Car aCar) {
		carsList.add(aCar);
		System.out.println("Added the Car to the waiting list (washing queue).");
	}

	/**
	 * Washes the next car in queue.
	 */
	public void washCar() {
		System.out.println("Car #" + currentCar++ + " WASHED.");
	}

	/**
	 * Closes the CarWash for business.
	 */
	public void closeShop() {
		setOpen(false);
		System.out.println("Shop CLOSED.");
		if (currentCar > 0) {
			setLastWashedCar((byte) (currentCar - 1));
		} else {
			System.out.println("No Cars washed today.");
		}
	}

	/**
	 * Generates the List of cars that where washed today.
	 * 
	 * @return a List of Cars.
	 */
	public List<Car> getTodaysClients() {
		ArrayList<Car> theCarsList = new ArrayList<Car>();
		if (currentCar > 0) {
			for (int i = 0; i < currentCar; i++) {
				theCarsList.add(carsList.get(i));
			}
		}
		return theCarsList;
	}

	/**
	 * Generates the List of cars that where not washed today.
	 * 
	 * @return a list of Cars.
	 */
	public List<Car> getPostponedClients() {
		ArrayList<Car> theCarsList = new ArrayList<Car>();
		if (currentCar > 0) {
			for (int i = currentCar; i < carsList.size(); i++) {
				theCarsList.add(carsList.get(i));
			}
		}
		return theCarsList;

	}

	/**
	 * @return the open
	 */
	public boolean isOpen() {
		return open;
	}

	/**
	 * @param open the open to set
	 */
	public void setOpen(boolean open) {
		this.open = open;
	}

	/**
	 * @return the lastWashedCar
	 */
	public byte getLastWashedCar() {
		return lastWashedCar;
	}

	/**
	 * @param lastWashedCar the lastWashedCar to set
	 */
	public void setLastWashedCar(byte lastWashedCar) {
		this.lastWashedCar = lastWashedCar;
	}

}
