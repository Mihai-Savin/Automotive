package ro.mihaisavin.automotive;
/**
 * 
 */

/**
 * @author Meehai Savin
 *
 */
public abstract class Dacia extends Car {
	public Dacia(int fuelAmount, String chassisNumber) {
		super(fuelAmount, chassisNumber);
		manufacturerName = "Dacia-Renault Automobile S.A.";		
		manufacturerLicense = "All type of automobiles";
	}
	public Dacia() {	
		super();
		manufacturerName = "Dacia-Renault Automobile S.A.";		
		manufacturerLicense = "All type of automobiles";
	}
	
}