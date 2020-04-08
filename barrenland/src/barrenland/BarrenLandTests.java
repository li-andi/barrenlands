package barrenland;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BarrenLandTests {
	/**
	 * Test input 1 from example
	 */
	@Test
	public void testGetFertileLandArea1() {
		BarrenLand bl = new BarrenLand();
		List<Integer> expectedResult1 = Arrays.asList(116800, 116800);
		String[] input1 = { "0 292 399 307" };
		assertEquals(expectedResult1, bl.getFertileLandArea(input1));

	}
	/**
	 * Test input 2 from example
	 */
	@Test
	public void testGetFertileLandArea2() {
		BarrenLand bl = new BarrenLand();
		List<Integer> expectedResult2 = Arrays.asList(22816, 192608);
		String[] input2 = { "48 192 351 207", "48 392 351 407", "120 52 135 547", "260 52 275 547" };
		assertEquals(expectedResult2, bl.getFertileLandArea(input2));
	}
	
	/**
	 * Test what happens if the coordinate is out of bounds
	 */
	@Test
	public void testGetFertileLandArea3() {
		BarrenLand bl = new BarrenLand();	
		List<Integer> expectedResult3 = Arrays.asList();
		String[] input3 = {"0 292 400 307"};
		assertEquals(expectedResult3, bl.getFertileLandArea(input3));
	}
	/**
	 * Test what happens if the land is all barren
	 */
	@Test
	public void testGetFertileLandArea4() {
		BarrenLand bl = new BarrenLand();	
		List<Integer> expectedResult4 = Arrays.asList();
		String[] input4 = {"0 0 399 599"};
		assertEquals(expectedResult4, bl.getFertileLandArea(input4));
	}
	/**
	 * Test what happens if there are non numerical numbers in input
	 */
	@Test
	public void testGetFertileLandArea5() {
		BarrenLand bl = new BarrenLand();	
		List<Integer> expectedResult5 = Arrays.asList();
		String[] input5 = {"a0 0 3d99 599"};
		assertEquals(expectedResult5, bl.getFertileLandArea(input5));
	}	
	/**
	 * Test if input has too many numbers
	 */
	@Test
	public void testGetFertileLandArea6() {
		BarrenLand bl = new BarrenLand();	
		List<Integer> expectedResult6 = Arrays.asList();
		String[] input6 = {"0 292 399 307 234"};
		assertEquals(expectedResult6, bl.getFertileLandArea(input6));
	}
	

}
