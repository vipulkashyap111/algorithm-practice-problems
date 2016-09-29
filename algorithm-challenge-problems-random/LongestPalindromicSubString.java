package practice;

public class LongestPalindromicSubString {
	public String longestPalindrome(String s) {
        int n = s.length();
        String res="";
        if(n==0)
            return res;
        int[][] m = new int[n][n];
        
        for(int i=0;i<n;i++){
            m[i][i]=1;
        }
        int startInd = 0;
        int endInd = 0;
        
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                m[i][i+1]=1;
                startInd = i;
                endInd=i+1;
            }
        }
        int j = 0;
        for(int length=3;length<=n; length++){
            for(int i = 0;i<n-length+1;i++){
                j=i+length-1;
                if(s.charAt(i)==s.charAt(j) && m[i+1][j-1]==1){
                    m[i][j]=1;
                    if(endInd-startInd<j-i){
                    	startInd = i;
                    	endInd=j;
                    }
                        
                }
            }
        }
        return s.substring(startInd,endInd+1);
    }
	
	public static void main(String[] args){
		LongestPalindromicSubString obj = new LongestPalindromicSubString();
		System.out.println(obj.longestPalindrome("abcbd"));
	}
}
