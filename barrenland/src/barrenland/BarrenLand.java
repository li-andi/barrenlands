package barrenland;

import java.util.*;


/**
 * @author Andi
 *
 */

public class BarrenLand {
	private int[][] land;
	private static final int ROW = 600;
	private static final int COLUMN = 400;

    public BarrenLand() {    	
        land = new int[ROW][COLUMN];
    }
    /**
     * This function takes in the coordinates of the barren land and finds the amount of fertile land
     * @param coordinates
     * @return Returns a the area of the fertile land in order of smallest to greatest
     */
    public List<Integer> getFertileLandArea(String[] coordinates) {
        List<Integer> result = new ArrayList<>();//create result list
        if(parseString(coordinates)){ //checks to make sure that the input is valid before performing bfs           
        	//loops through matrix to check for 0's (fertile land)
            for (int i = 0; i < land.length; i++) {
                for (int j = 0; j < land[0].length; j++) {
                    if (land[i][j] == 0) {
                        int area = bfs(land, i, j);
                        result.add(area);//add the area to list
                    }
                }
            }
            Collections.sort(result);//sort the list from least to greatest
           
    
        }
        return result;
       
    }
   
    /**
     * This function marks the land as barren in this case it marks it as 1(visited)
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    private void fillLand(int x1, int y1, int x2, int y2) {
        for (int i = y1; i <= y2; i++) {
            for (int j = x1; j <= x2; j++) {
                land[i][j] = 1;//mark the tile as visited(barren)
            }
        }
    }
    /**
     * This function takes the input string and parses it to extract the coordinates 
     * @param coordinates
     * @return
     */
    private boolean parseString(String[] coordinates) {
        for(int i = 0;i<coordinates.length;i++){
            coordinates[i] = coordinates[i].replaceAll("[^.0-9\\s]", "");//remove non numbers
        }
        for (int i = 0; i < coordinates.length; i++) {
        	 String[] points = coordinates[i].split(" "); 
             if(points.length>4 || points.length < 4){//checks if the format of the string is correct
                 return false;
             }                     
             int x1 = Integer.valueOf(points[0]);//changes string to int
             int y1 = Integer.valueOf(points[1]);
             int x2 = Integer.valueOf(points[2]);
             int y2 = Integer.valueOf(points[3]);
           
             //checks if the numbers are with the 400x600
             try {
                 fillLand(x1, y1, x2, y2);
             } catch (IndexOutOfBoundsException e) {               
                 System.out.println("Parsed string contains values outside of the 400x600 land");
                 return false;
             }         
           
        }

        return true;
    }
    /**
     * This function performs breadth first search on the adj matrix to count area of the fertile(unvisited land)
     * @param land
     * @param x
     * @param y
     * @return
     */
    private int bfs(int[][] land, int x, int y) {
        int area = 1;//start the area count
        
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } }; //check neighbors
        Queue<int[]> queue = new LinkedList<>(); 
        queue.offer(new int[] { x, y });
        land[x][y] = 1; //mark first tile as visited
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : dirs) {//loop through adjacent neighbors
                int newX = curr[0] + dir[0];
                int newY = curr[1] + dir[1];
                if (newX < 0 || newX >= land.length || newY < 0 || newY >= land[0].length) {//checks if the neighbor is in bounds
                    continue;
                }
                if (land[newX][newY] == 0) {//fertile land found
                    area++; //increment area
                    land[newX][newY] = 1;//change the land to barren
                    queue.offer(new int[] { newX, newY });//add neighbor to queue
                }
            }
        }
        return area;
    }

    

}
