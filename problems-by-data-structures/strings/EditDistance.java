package strings;

public class EditDistance {
	 public int min(int i, int j, int k){
	        int s = i<j?i:j;
	        return s<k?s:k;
	    }
	    public int minDistance(String one, String two) {
	        if(one=="" || two==""){
	            return 0;
	        }
	        int[][] m = new int[two.length()+1][one.length()+1];
	        
	        for(int j = 0; j<m[0].length; j++)
	            m[0][j] = j;
	        for(int i =0; i<m.length; i++){
	            m[i][0] = i;
	        }
	        
	        for(int i = 1; i<m.length; i++)
	            for(int j = 1; j<m[0].length; j++){
	                if(one.charAt(j-1)==two.charAt(i-1)){
	                    m[i][j] = m[i-1][j-1];
	                } else{
	                    m[i][j] = min(m[i-1][j], m[i-1][j-1],m[i][j-1])+1;
	                }
	            }
	        return m[two.length()][one.length()];
	    }
	    
	    public static void main(String[] args){
	    	EditDistance obj = new EditDistance();
	    	
	    	System.out.println(obj.minDistance("abc", "abcd"));
	    }
}
