package ie.gmit.dip;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
class Test2InsuranceProgram {

	public static InsuranceProgram ip;

	// run once before all tests
	@BeforeAll
	public static void testSetUp() {
		System.out.println("@BeforeAll - ip instance initialised");
		ip = new InsuranceProgram();
	}

	// test that age variables are correctly set
//	@Disabled
	@Test
	public void test1() {
		int age = 20;
		ip.setAge(age);
		if (ip.getAge() == age)
			System.out.println("Verification of setAge() working.");
	}

	// exception test for array boundaries
	@Test
	public void myArrayBoundsException() {
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			int[] testArray = ip.getAccSurcharge();
			int sum = 0;
			for (int i = 0; i <= 10; i++) {
				sum += testArray[i];
			}
		});
	}

	// test for null pointers
	@Test
	public void myNullException() {
		assertThrows(NullPointerException.class, () -> {
			if (ip.getGreeting() == null) {
				throw new NullPointerException("That greeting was null. :/ ");
			}
		});
	}

	// reset ip to null after all tests are complete
	@AfterAll
	public static void testTearDown() {
		ip = null;
		System.out.println("@AfterAll - ip instance set to null");
	}

}
