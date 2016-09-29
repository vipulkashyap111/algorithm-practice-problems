package codingChallengePractice;

public class SubString {

	static int maxRounds(String s, String t) {
        int res = 0;
        StringBuffer str = new StringBuffer(s);
        int lenT = t.length();
        int lenS = s.length();
        int j = 0;
        int i = 0;
        while(lenS >= lenT && i<lenS){
        	if(i==lenS)
        		return res;
            char c = str.charAt(i);
            if( c == t.charAt(j)){
                j++;
                i++;              
            }else if(j==0){
            	i++;
            }
            else{            	
                j = 0;
            }
            if(j==lenT){
                res++;
                //String str1 = i - lenT;
                str = str.replace(i-j, i, ""); 
                i=0;
                j=0;
                lenS = str.length();
            }            
        }
  
       return res; 
    }
	
	public static void main(String[] args){
		String s = "aaaaaaaaaaaaaaaaaaa";
		String t = "aa";
		/*StringBuffer str = new StringBuffer(s);
		int i = 4;
		int j = 3;
		str = str.replace(i-j, i, "");
		System.out.println(str);*/
		int res = maxRounds(s, t);
		System.out.println(res);
	}
}
