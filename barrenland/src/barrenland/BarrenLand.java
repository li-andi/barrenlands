package barrenland;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author Andi
 *
 */

public class BarrenLand {
	private int[][] land;
	private static final int ROW = 600;
	private static final int COLUMN = 400;
	private static final int BARREN_LAND = 1;
	private static final int FERTILE_LAND = 0;
	private static boolean validInput;

	public BarrenLand() {
		land = new int[ROW][COLUMN];
		validInput = true;
	}
	/**
	 * Read the string from stdin and populate the barren land
	 * @throws IOException
	 */
	public void readInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//continue reading from stdin as long as the input is valid
		while (validInput) {
			sb.append(br.readLine());
			if (sb.toString().matches("[0-9\",}{“” ]+")) { //checks if input matches the required format  
				break;
			} else {
				validInput = false;				
			}
		}

		String[] subStrings = sb.toString().split(",");
		
		for (String s : subStrings) {
			s = s.replaceAll("[^.0-9\\s]", ""); // remove all non numbers
			s = s.replaceAll("^ ", "");     // remove leading space		
			parseString(s);
		}

	}

	/**
	 * This function takes in the coordinates of the barren land and finds the
	 * amount of fertile land
	 * 
	 * @param listOfCoordinates
	 * @return Returns a the area of the fertile land in order of smallest to
	 *         greatest
	 */
	public List<Integer> getFertileLandArea() {
		List<Integer> result = new ArrayList<>();
		if(validInput) {
			// loops through matrix to check for 0's (fertile land)
			for (int i = 0; i < land.length; i++) {
				for (int j = 0; j < land[0].length; j++) {
					if (land[i][j] == FERTILE_LAND) {
						int area = bfs(land, i, j);
						result.add(area);// add the area to list
					}
				}
			}			
			Collections.sort(result);// sort the list from least to greatest
		}
		else {
			System.out.println("Input was not valid");
			result.add(ROW*COLUMN);
		}
		
		if(result.isEmpty()) result.add(0);
		// return the area of the land
		System.out.println(result); // print result to std out
		return result;

	}

	/**
	 * This function marks the land as barren in this case it marks it as 1(visited)
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	private void fillLand(int x1, int y1, int x2, int y2) {
		for (int i = y1; i <= y2; i++) {
			for (int j = x1; j <= x2; j++) {
				land[i][j] = BARREN_LAND;// mark the tile as visited(barren)
			}
		}
	}

	/**
	 * This function takes the input string and parses it to extract the coordinates
	 * 
	 * @param listOfCoordinates
	 * @return
	 */
	private void parseString(String listOfCoordinates) {
		String[] points = listOfCoordinates.split(" ");
		if (points.length == 4 ) {// checks if the format of the string is correct
			int x1 = Integer.valueOf(points[0]);// changes string to int
			int y1 = Integer.valueOf(points[1]);
			int x2 = Integer.valueOf(points[2]);
			int y2 = Integer.valueOf(points[3]);
			if (checkBoundries(x1, y1, x2, y2)) {
				fillLand(x1, y1, x2, y2);

			} else {
				validInput = false;				

			}
		}
		else {
			validInput = false;
		}
		
	}

	/**
	 * This functions makes sure that the coordinates are within the bounds of the area
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return
	 */
	private boolean checkBoundries(int x1, int y1, int x2, int y2) {
		if (y1 < 0 || y1 > ROW - 1) {
			return false;
		}
		if (x1 < 0 || x1 > COLUMN - 1) {
			return false;
		}
		if (y2 < 0 || y2 > ROW - 1) {
			return false;
		}
		if (x2 < 0 || x2 > COLUMN - 1) {
			return false;
		}
		if(y1>y2 || x1>x2) { //check if the top right corner of the rectangle is actually in the top right corner
			return false;
		}

		return true;

	}

	/**
	 * This function performs breadth first search on the adj matrix to count area
	 * of the fertile(unvisited land)
	 * 
	 * @param land
	 * @param x
	 * @param y
	 * @return
	 */
	private int bfs(int[][] land, int x, int y) {
		int area = 1;

		int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } }; //coordinates of north east south west
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { x, y });
		land[x][y] = BARREN_LAND; // mark first tile as visited
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			for (int[] dir : dirs) {// loop through adjacent neighbors
				int newX = curr[0] + dir[0];
				int newY = curr[1] + dir[1];
				if (newX < 0 || newX >= land.length || newY < 0 || newY >= land[0].length) {// checks if the neighbor is
																							// in bounds
					continue;
				}
				if (land[newX][newY] == FERTILE_LAND) {// fertile land found
					area++; // increment area
					land[newX][newY] = BARREN_LAND;// change the land to barren
					queue.offer(new int[] { newX, newY });// add neighbor to queue
				}
			}
		}
		return area;
	}


}
