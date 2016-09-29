package practice;
import java.util.*;
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        int m = matrix.length;
        if(m==0)
            return res;
        int n = matrix[0].length;
        int levels = (m<n?m:n)/2;
        int i, j;
        i = j = 0;
        int rowsleft = m;
        int colsleft = n;
        for(int level = 0;level<=levels; level++){
        	if(rowsleft==0 || colsleft==0)
        		break;
        	if(rowsleft==1){
        		 i = level;
                 for(int runner = level; runner<n-level; runner++){
                     j = runner;
                     res.add(matrix[i][j]);
                 }
                 break;
        	}else if(colsleft==1){
        		j = n-1-level;
                for(int runner = level; runner<m-level; runner++){
                    i = runner;
                    res.add(matrix[i][j]);
                }
                break;
        	}
            //traverse top
            i = level;
            for(int runner = level; runner<n-level; runner++){
                j = runner;
                res.add(matrix[i][j]);
            }
            //traverse right
            j = n-1-level;
            for(int runner = level+1; runner<m-level; runner++){
                i = runner;
                res.add(matrix[i][j]);
            }
            //traverse  bottom
            i = m-1-level;
            for(int runner = n-1-1; runner>=level; runner--){
                j = runner;
                res.add(matrix[i][j]);
            }
            //traverse left
            j = level;
            for(int runner = m-1-1; runner>level; runner--){
                i = runner;
                res.add(matrix[i][j]);
            }
            rowsleft-=2;
            colsleft-=2;
        }
        
        return res;
    }
	
	public static void main(String[] args){
		SpiralMatrix obj = new SpiralMatrix();
		int[][] m = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		//int[][] m = {{1,5},{2,6},{3,7},{4,8}};
		//int[][] m = {{1},{2}};
		obj.spiralOrder(m);
	}
}
