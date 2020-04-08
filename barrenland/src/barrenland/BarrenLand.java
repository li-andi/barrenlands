package barrenland;

import java.util.*;


public class BarrenLand {
	private int[][] land;

    public BarrenLand() {
        land = new int[600][400];
    }

    public List<Integer> getFertileLandArea(String[] coordinates) {
        List<Integer> result = new ArrayList<>();
        if(parseString(coordinates)){
            

            for (int i = 0; i < land.length; i++) {
                for (int j = 0; j < land[0].length; j++) {
                    if (land[i][j] == 0) {
                        int area = bfs(land, i, j);
                        result.add(area);
                    }
                }
            }
            Collections.sort(result);
           
    
        }
        return result;
       
    }

    private void fillLand(int x1, int y1, int x2, int y2) {
        for (int i = y1; i <= y2; i++) {
            for (int j = x1; j <= x2; j++) {
                land[i][j] = 1;
            }
        }
    }

    private boolean parseString(String[] coordinates) {
        for(int i = 0;i<coordinates.length;i++){
            coordinates[i] = coordinates[i].replaceAll("[^.0-9\\s]", "");
        }
        for (int i = 0; i < coordinates.length; i++) {
        	 String[] points = coordinates[i].split(" "); 
             if(points.length>4 || points.length < 4){
                 return false;
             }                     
             int x1 = Integer.valueOf(points[0]);
             int y1 = Integer.valueOf(points[1]);
             int x2 = Integer.valueOf(points[2]);
             int y2 = Integer.valueOf(points[3]);
             try {
                 fillLand(x1, y1, x2, y2);
             } catch (IndexOutOfBoundsException e) {               
                 System.out.println("Parsed string contains values outside of the 400x600 land");
                 return false;
             }         
           
        }

        return true;
    }

    private int bfs(int[][] land, int x, int y) {
        int area = 1;
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { x, y });
        land[x][y] = 1;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : dirs) {
                int newX = curr[0] + dir[0];
                int newY = curr[1] + dir[1];
                if (newX < 0 || newX >= land.length || newY < 0 || newY >= land[0].length) {
                    continue;
                }
                if (land[newX][newY] == 0) {
                    area++;
                    land[newX][newY] = 1;
                    queue.offer(new int[] { newX, newY });
                }
            }
        }
        return area;
    }

    

}
