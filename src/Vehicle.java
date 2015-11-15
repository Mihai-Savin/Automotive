/**
 * 
 */

/**
 * @author Mihai Savin
 *
 */
public interface Vehicle {
	/**
	 * starts the Vehicle
	 */
	public void start();	
	/**
	 * 
	 * @param drives for specified distance in KMs
	 */
	public void drive(float distance); 	//drives the Vehicle
	/**
	 * stops the Vehicle
	 */
	public void stop();		//stops the Vehicle
}