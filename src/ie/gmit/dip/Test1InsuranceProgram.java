package ie.gmit.dip;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
class Test1InsuranceProgram {

	public static InsuranceProgram ip;

	// ip object variable created before each test
	@BeforeEach
	public void testSetUp() {
		ip = new InsuranceProgram();
	}

	// correctly checks expected results for each switch case
	@ParameterizedTest
	@CsvSource({ "0,500", "1,550", "2,625", "3,725", "4,875", "5,1075" })
	public void testValuesOver25(int accidents, int result) {
		ip.setAge(30);
		int returnedValue = ip.numOfAccidents(accidents);
		assertEquals(result, returnedValue);
	}

	// Passes and fails based on TimeUnit used. Tested both Milli and Nano.
	@Timeout(value = 1, unit = TimeUnit.MILLISECONDS)
	@ParameterizedTest
	@CsvSource({ "0,600", "1,650", "2,725", "3,825", "4,975", "5,1175" })
	public void testValuesUnder25(int accidents, int result) {
		ip.setAge(20);
		int returnedValue = ip.numOfAccidents(accidents) + ip.getAgeSurcharge();
		assertEquals(result, returnedValue);
	}

	// simple test to compare values. Disabled to meet assignment specs
	@Disabled
	@Test
	public void testSurcharge() {
		System.out.println("Running a test to check that age surcharge is correctly set.");
		int expectedAgeSurcharge = 100;
		int actualAgeSurcharge = ip.getAgeSurcharge();
		assertEquals(expectedAgeSurcharge, actualAgeSurcharge);
	}

	// ip variable reset after each test
	@AfterEach
	public void testTearDown() {
		ip = null;
		System.out.println("********************************************");
	}
}
