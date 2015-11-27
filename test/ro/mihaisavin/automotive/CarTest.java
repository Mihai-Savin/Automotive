package ro.mihaisavin.automotive;

import static org.junit.Assert.*;
import org.junit.Test;


public class CarTest {
	
	@Test
	public void constructCarTest_just_for_fun_a_dummy_car() {
		Car aCar = new Logan();
		assertNotNull(aCar);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void checkCarConstruction_negative_fuel_amount_4_0_way() {		
		new Logan(-1, "SAAVVZZ123ASDFG");		
	}
	
	@Test
	public void checkCarConstruction_valid_params() {
		Car aCar = new Logan(10, "SAAVVZZ123ASDFG");		
		assertEquals(new Float(10), new Float(aCar.fuelAmount));
		assertEquals("SAAVVZZ123ASDFG", aCar.chassisNumber);
	}
	
	@Test
	public void checkCarConstruction_empty_chassis_number_3_8_way() {		
		try {
			new Logan(10, "");
			fail("You should not be able to create a car with no chassis number.");
		} catch (IllegalArgumentException ex) {}		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void checkCarConstruction_empty_chassis_number_4_0_way() {		
		new Logan(10, "");		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void checkCarConstruction_null_chassis_number_4_0_way() {		
		new Logan(10, null);		
	}
	
	@Test
	public void randomTest() {
		System.out.println("If you can read this on the console \nit means that all went well. :)");
		

		
	}

}
