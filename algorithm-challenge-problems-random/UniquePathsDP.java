package practice;

public class UniquePathsDP {
	public int[][] matrix;
    public int uniquePaths(int m, int n) {
        if(m==0 && n==0)
            return 0;
        matrix = new int[m+1][n+1];
        
        for(int i = 1;i<=n;i++){
            matrix[1][i] = 1;
        }
        for(int i=1;i<=m;i++){
            matrix[i][1] = 1;
        }
        
        for(int i=2;i<=m;i++){
            for(int j = 2;j<=n;j++){
                matrix[i][j]=matrix[i-1][j] + matrix[i][j-1];
            }
        }
        
        return matrix[m][n];
    }
    
    public static void main(String[] args){
    	UniquePathsDP o = new UniquePathsDP();
    	o.uniquePaths(3, 3);
    }
}
