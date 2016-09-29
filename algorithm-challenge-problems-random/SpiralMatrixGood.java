package practice;
import java.util.*;
public class SpiralMatrixGood {
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        int m = matrix.length;
        if(m==0)
            return res;
        int n = matrix[0].length;
        int x = 0;
        int y = 0;
        
        while(m>0 || n>0){
            if(m==1){
                for(int i=0;i<n;i++){
                    res.add(matrix[x][y++]);
                }
                break;
            }else if(n==1){
                for(int j=0;j<m;j++){
                    res.add(matrix[x++][y]);
                }
                break;
            }
            
            //traverse top
            for(int i=0;i<n-1;i++){
                res.add(matrix[x][y++]);
            }
            
            //traverse right
            for(int j=0;j<m-1;j++){
                res.add(matrix[x++][y]);
            }
            
            //traverse bottom
            for(int i=0;i<n-1;i++){
                res.add(matrix[x][y--]);
            }
            
            //traverse left
            for(int j=0;j<m-1;j++){
                res.add(matrix[x--][y]);
            }
            x++;
            y++;
            m=m-2;
            n=n-2;
        }
        return res;
    }
	
	public static void main(String[] args){
		SpiralMatrixGood obj = new SpiralMatrixGood();
		int[][] m = {{1,2,3,4,5},{6,7,8,9,10}};
		//int[][] m = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		//int[][] m = {{1,5},{2,6},{3,7},{4,8}};
		//int[][] m = {{1},{2}};
		obj.spiralOrder(m);
	}
}
