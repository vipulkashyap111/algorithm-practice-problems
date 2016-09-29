package practice;
import java.util.*;
public class NumberofIslabds {
	 public int numIslands(char[][] grid) {
	        if(grid.length==0)
	            return 0;
	        int m = grid.length;
	        int n = grid[0].length;
	        boolean[][] visited = new boolean[m][n];
	        int count = 0;
	        for(int i = 0; i<m; i++){
	            for(int j = 0; j<n; j++){
	                if(!visited[i][j] && grid[i][j]=='1'){
	                    dfs(grid,visited,i,j);
	                    count++;
	                }
	            }
	        }
	        return count;
	    }
	    
	    public void dfs(char[][] grid, boolean[][] visited, int i, int j){
	        visited[i][j] = true;
	        int k, l;
	        k = l = 0;
	        List<ArrayList<Integer>> adjacentPoints = new ArrayList<ArrayList<Integer>>();
	        adjacentPoints = getAdjacent(grid,i,j);
	        for(ArrayList<Integer> point: adjacentPoints){
	            k = point.get(0);
	            l = point.get(1);
	            if(!visited[k][l]){
	                dfs(grid, visited, k, l);
	            }
	        }
	    }
	    
	    public List<ArrayList<Integer>> getAdjacent(char[][] grid, int i, int j){
	        List<ArrayList<Integer>> points = new ArrayList<ArrayList<Integer>>();
	        if((i-1)>=0 && grid[i-1][j]=='1'){
	            points.add(new ArrayList<Integer>(Arrays.asList(i-1,j)));
	        }
	        if((j-1)>=0 && grid[i][j-1]=='1'){
	            points.add(new ArrayList<Integer>(Arrays.asList(i,j-1)));
	        }
	        if((i+1)<grid.length && grid[i+1][j]=='1'){
	            points.add(new ArrayList<Integer>(Arrays.asList(i+1,j)));
	        }
	        if((j+1)<grid[0].length && grid[i][j+1]=='1'){
	            points.add(new ArrayList<Integer>(Arrays.asList(i,j+1)));
	        }
	        return points;
	    }
	    
	    public static void main(String[] args){
	    	char[][] grid = {{'1','1','1'},{'0','1','0'},{'1','1','1'}};
	    	NumberofIslabds obj = new NumberofIslabds();
	    	System.out.println(obj.numIslands(grid));
	    }
}
