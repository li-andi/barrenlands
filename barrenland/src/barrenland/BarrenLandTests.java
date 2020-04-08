package barrenland;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BarrenLandTests {
	private BarrenLand bl;

	@BeforeEach
	public void init() {
		bl = new BarrenLand();

	}

	/**
	 * Test input 1 from example
	 * 
	 * @throws IOException
	 */
	@Test
	public void testGetFertileLandArea1() throws IOException {
		List<Integer> expectedResult1 = Arrays.asList(116800, 116800);
		String input = "0 292 399 307";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		bl.readInput();
		assertEquals(expectedResult1, bl.getFertileLandArea());

	}

	/**
	 * Test input 2 from example
	 * 
	 * @throws IOException
	 */

	@Test
	public void testGetFertileLandArea2() throws IOException {

		List<Integer> expectedResult2 = Arrays.asList(22816, 192608);
		String input = "{“48 192 351 207”, “48 392 351 407”, “120 52 135 547”, “260 52 275 547”}";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		bl.readInput();
		assertEquals(expectedResult2, bl.getFertileLandArea());
	}

	/**
	 * Test what happens if the land is all barren
	 * @throws IOException 
	 */

	@Test
	public void testGetFertileLandArea4() throws IOException {

		List<Integer> expectedResult4 = Arrays.asList();
		String input = "0 0 399 599";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		bl.readInput();
		assertEquals(expectedResult4, bl.getFertileLandArea());
	}

	/**
	 * Test what happens if there are non numerical numbers in input
	 * @throws IOException 
	 */

	@Test
	public void testGetFertileLandArea5() throws IOException {

		List<Integer> expectedResult5 = Arrays.asList();
		String input =  "a0 0 3d99 599";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		bl.readInput();
		assertEquals(expectedResult5, bl.getFertileLandArea());
	}

	/**
	 * Test if input has too many numbers
	 * @throws IOException 
	 */

	@Test
	public void testGetFertileLandArea6() throws IOException {

		List<Integer> expectedResult6 = Arrays.asList();
		String input =  "0 292 399 307 234" ;
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		bl.readInput();
		assertEquals(expectedResult6, bl.getFertileLandArea());
	}

	/**
	 * Test what happens if the x1 coordinate is out of bounds
	 * @throws IOException 
	 */

	@Test
	public void testGetFertileLandArea7() throws IOException {

		List<Integer> expectedResult = Arrays.asList();
		String input = "600 292 399 307";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		bl.readInput();
		assertEquals(expectedResult, bl.getFertileLandArea());
	}

	/**
	 * Test what happens if the y1 coordinate is out of bounds
	 * @throws IOException 
	 */

	@Test
	public void testGetFertileLandArea8() throws IOException {
		List<Integer> expectedResult = Arrays.asList();
		String input = "0 700 399 307" ;
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		bl.readInput();
		assertEquals(expectedResult, bl.getFertileLandArea());
	}

	/**
	 * Test what happens if the x2 coordinate is out of bounds
	 * @throws IOException 
	 */

	@Test
	public void testGetFertileLandArea9() throws IOException {

		List<Integer> expectedResult = Arrays.asList();
		String input = "0 292 400 307";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		bl.readInput();
		assertEquals(expectedResult, bl.getFertileLandArea());
	}

	/**
	 * Test what happens if the y2 coordinate is out of bounds
	 * @throws IOException 
	 */
	@Test
	public void testGetFertileLandArea10() throws IOException {

		List<Integer> expectedResult = Arrays.asList();
		String input =  "0 292 399 600" ;
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		bl.readInput();
		assertEquals(expectedResult, bl.getFertileLandArea());
	}

}
