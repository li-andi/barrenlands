package barrenland;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
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
	@Order(1)
	public void testGetFertileLandArea1() throws IOException {
		List<Integer> expectedResult = Arrays.asList(116800, 116800);
		String input = "0 292 399 307";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		bl.readInput();
		System.out.println("Running test 1");
		assertEquals(expectedResult, bl.getFertileLandArea());
		System.out.println("--------------");

	}

	/**
	 * Test input 2 from example
	 * 
	 * @throws IOException
	 */

	@Test
	@Order(2)
	public void testGetFertileLandArea2() throws IOException {
		List<Integer> expectedResult = Arrays.asList(22816, 192608);
		String input = "{“48 192 351 207”, “48 392 351 407”, “120 52 135 547”, “260 52 275 547”}";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		bl.readInput();
		System.out.println("Running test 2");
		assertEquals(expectedResult, bl.getFertileLandArea());
		System.out.println("--------------");
	}
	
	/**
	 * Test with new input
	 * 
	 * @throws IOException
	 */
	@Test
	@Order(3)
	public void testGetFertileLandArea3() throws IOException {

		List<Integer> expectedResult = Arrays.asList(239970);
		String input = "{“0 1 4 6”}";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		bl.readInput();
		System.out.println("Running test 3");
		assertEquals(expectedResult, bl.getFertileLandArea());
		System.out.println("--------------");
	}
	
	/**
	 * Test what happens if the land is all barren
	 * @throws IOException 
	 */
	@Test
	@Order(4)
	public void testGetFertileLandArea4() throws IOException {

		List<Integer> expectedResult = Arrays.asList(0);
		String input = "0 0 399 599";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		bl.readInput();
		System.out.println("Running test 4");
		assertEquals(expectedResult, bl.getFertileLandArea());
		System.out.println("--------------");
	}

	/**
	 * Test what happens if there are non numerical numbers in input
	 * @throws IOException 
	 */

	@Test
	@Order(5)
	public void testGetFertileLandArea5() throws IOException {

		List<Integer> expectedResult = Arrays.asList(240000);
		String input =  "a0 0 3d99 599";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		bl.readInput();
		System.out.println("Running test 5");
		assertEquals(expectedResult, bl.getFertileLandArea());
		System.out.println("--------------");
	}

	/**
	 * Test if input has too many numbers
	 * @throws IOException 
	 */

	@Test
	@Order(6)
	public void testGetFertileLandArea6() throws IOException {

		List<Integer> expectedResult = Arrays.asList(240000);
		String input =  "0 292 399 307 234" ;
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		bl.readInput();
		System.out.println("Running test 6");
		assertEquals(expectedResult, bl.getFertileLandArea());
		System.out.println("--------------");
	}

	/**
	 * Test what happens if the x1 coordinate is out of bounds
	 * @throws IOException 
	 */

	@Test
	@Order(7)
	public void testGetFertileLandArea7() throws IOException {

		List<Integer> expectedResult = Arrays.asList(240000);
		String input = "600 292 399 307";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		bl.readInput();
		System.out.println("Running test 7");
		assertEquals(expectedResult, bl.getFertileLandArea());
		System.out.println("--------------");
	}

	/**
	 * Test what happens if the y1 coordinate is out of bounds
	 * @throws IOException 
	 */

	@Test
	@Order(8)
	public void testGetFertileLandArea8() throws IOException {
		List<Integer> expectedResult = Arrays.asList(240000);
		String input = "0 700 399 307" ;
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		bl.readInput();
		System.out.println("Running test 8");
		assertEquals(expectedResult, bl.getFertileLandArea());
		System.out.println("--------------");
	}

	/**
	 * Test what happens if the x2 coordinate is out of bounds
	 * @throws IOException 
	 */

	@Test
	@Order(9)
	public void testGetFertileLandArea9() throws IOException {

		List<Integer> expectedResult = Arrays.asList(240000);
		String input = "0 292 400 307";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		bl.readInput();
		System.out.println("Running test 9");
		assertEquals(expectedResult, bl.getFertileLandArea());
		System.out.println("--------------");
	}

	/**
	 * Test what happens if the y2 coordinate is out of bounds
	 * @throws IOException 
	 */
	@Test
	@Order(10)
	public void testGetFertileLandArea10() throws IOException {

		List<Integer> expectedResult = Arrays.asList(240000);
		String input =  "0 292 399 600" ;
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		bl.readInput();
		System.out.println("Running test 10");
		assertEquals(expectedResult, bl.getFertileLandArea());
		System.out.println("--------------");
	}
	
	/**
	 * Test what happens if an empty string is passed in
	 * @throws IOException 
	 */
	@Test
	@Order(11)
	public void testGetFertileLandArea11() throws IOException {
		List<Integer> expectedResult = Arrays.asList(240000);
		String input = " ";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		bl.readInput();
		System.out.println("Running test 11");
		assertEquals(expectedResult, bl.getFertileLandArea());
		System.out.println("--------------");
	}
	
	/**
	 * Test check overlapping points
	 */
	@Test
	@Order(12)
	public void testGetFertileLandArea12() throws IOException {
		List<Integer> expectedResult = Arrays.asList(216032);
		String input = "{“123 456 234 567”, “256 456 357 567”}";	
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		bl.readInput();
		System.out.println("Running test 12");
		assertEquals(expectedResult, bl.getFertileLandArea());
		System.out.println("--------------");
	}

	/**
	 * Test overlapping barren land
	 * 
	 * @throws IOException
	 */
	@Test
	@Order(13)
	public void testGetFertileLandArea13() throws IOException {
		List<Integer> expectedResult = Arrays.asList(116800, 116800);
		String input ="{“0 292 399 307”, “0 292 399 307”}";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		bl.readInput();
		System.out.println("Running test 13");
		assertEquals(expectedResult, bl.getFertileLandArea());
		System.out.println("--------------");

	}
	
	/**
	 * Test 3 chunks of fertile land
	 * 
	 * @throws IOException
	 */
	@Test
	@Order(14)
	public void testGetFertileLandArea14() throws IOException {
		List<Integer> expectedResult = Arrays.asList(1600,7600,211600);
		String input ="{“0 0 399 10”, “0 15 399 30”,“0 50 399 70”}";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		bl.readInput();
		System.out.println("Running test 14");
		assertEquals(expectedResult, bl.getFertileLandArea());
		System.out.println("--------------");

	}
	
	/**
	 * Test straight line
	 */
	@Test
	@Order(15)
	public void testGetFertileLandArea15() throws IOException {
		List<Integer> expectedResult = Arrays.asList(239984);
		String input = "{“0 0 0 15”}";	
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		bl.readInput();
		System.out.println("Running test 15");
		assertEquals(expectedResult, bl.getFertileLandArea());
		System.out.println("--------------");
	}
	
	/**
	 * Test if the input is not in the bottom left to top right coordinate format
	 */
	@Test
	@Order(16)
	public void testGetFertileLandArea16() throws IOException {
		List<Integer> expectedResult = Arrays.asList(240000);
		String input = "{“100 200 0 0”}";	
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		bl.readInput();
		System.out.println("Running test 16");
		assertEquals(expectedResult, bl.getFertileLandArea());
		System.out.println("--------------");
	}
	
	

}
