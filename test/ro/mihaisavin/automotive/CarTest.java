package ro.mihaisavin.automotive;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CarTest {

	Car testCar;

	@Before
	public void setup() {
		testCar = new Logan(10, "SAV123");
	}

	@Test
	public void checkCarConstruction_dummyCar_justForTheFunOfIt() {
		Car aCar = new Logan();
		assertNotNull(aCar);
	}

	@Test
	public void checkCarConstruction_valid_params() {
		Car aCar = new Logan(10, "SAAVVZZ123ASDFG");
		assertEquals(new Float(10), new Float(aCar.fuelAmount));
		assertEquals("SAAVVZZ123ASDFG", aCar.chassisNumber);
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkCarConstruction_negative_fuel_amount_4_0_way() {
		new Logan(-1, "SAAVVZZ123ASDFG");
	}

	@Test
	public void checkCarConstruction_empty_chassis_number_3_8_way() {
		try {
			new Logan(10, "");
			fail("You should not be able to create a car with no chassis number.");
		} catch (IllegalArgumentException ex) {
		}
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
	public void checkShiftGear_valid_gear() {
		testCar.shiftGear(Car.Gears.FIRST);
		assertEquals(testCar.currentGear, Car.Gears.FIRST);
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkShiftGear_randomGear() {
		testCar.shiftGear(99);
	}

	@Test
	public void checkGearChecker_validGears() {
		for (int i = -1; i < 2; i++) { // iterates trough gears REVERSE,
										// NEUTRAL, and FIRST
			testCar.shiftGear(i);
			if (!testCar.checkGear()) {
				fail();
			}
		}
	}

	@Test
	public void checkGearChecker_invalidExistentGear() {
		testCar.shiftGear(Car.Gears.SECOND);
		if (testCar.checkGear()) {
			fail();
		}
	}

	@Test
	public void checkGearChecker_invalidInexistentGear_1() {
		testCar.currentGear = 99;
		if (testCar.checkGear()) {
			fail();
		}
	}

	@Test
	public void checkGearChecker_invalidInexistentGear_2() {
		testCar.currentGear = -99;
		if (testCar.checkGear()) {
			fail();
		}
	}

	//
	//
	//
	//

	@Test
	public void checkNothing() {
		System.out.println("If you can read this on the console \nit means that all went well. :)");

	}

}
