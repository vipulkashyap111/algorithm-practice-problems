package practice;

public class UniquePathsMemoization {
	public int[][] matrix;
    public int uniquePaths(int m, int n) {
        if(m==0 && n==0)
            return 0;
        matrix = new int[m+1][n+1];
        for(int i=1;i<m;i++)
            for(int j=1;j<n;j++)
                matrix[i][j]=Integer.MAX_VALUE;
        return countPaths(1,1,m,n);
    }
    
    public int countPaths(int x,int y,int m,int n){
        if(matrix[x][y]>Integer.MAX_VALUE)
            return matrix[x][y];            
        if(x==m && y==n){
            return 1;
        }
        int right = 0;
        int down = 0;
        if(x<m)
            right = countPaths(x+1, y, m, n);
        if(y<n)
            down = countPaths(x,y+1,m,n);
        matrix[x][y] = right+down;
        return matrix[x][y];
    }
    
    public static void main(String[] args){
    	UniquePathsMemoization o = new UniquePathsMemoization();
    	o.uniquePaths(1, 2);
    }
}
