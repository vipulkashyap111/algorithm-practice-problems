package practice;

public class StringtoInt {
	public boolean isNumber(char ch){
        if(ch - '0' >=0 && ch - '0' <10)
            return true;
        return false;
    }
    public int myAtoi(String str) {
        if(str.trim().length()>0){
            str = str.trim();
            boolean isNegative = false;
            boolean continuousNo = true;
            StringBuilder res = new StringBuilder();
            int i = 0;
            char ch = str.charAt(i);
            if(ch == '-'){
                isNegative = true;
                res.append(ch);
                i++;
            }
            else if(ch == '+')
            {
                i++;
            }
            for(int j = i; j<str.length();j++){
                ch = str.charAt(j);
                if(isNumber(ch) && continuousNo){
                    res.append(ch);
                }
                else if(!isNumber(ch))
                    continuousNo = false;
            }
            String ans = res.toString();
            if(ans.length()>0){
                if(isNegative && ans.length()>1){
                    if(ans.length()>12)
                        return Integer.MIN_VALUE;
                    long temp = Long.parseLong(ans);
                    if(temp<=Integer.MIN_VALUE)
                        return Integer.MIN_VALUE;
                    else
                        return Integer.parseInt(ans);
                }
                if(!isNegative && ans.length()>0){
                    if(ans.length()>12)
                        return Integer.MAX_VALUE;
                    long temp = Long.parseLong(ans);
                    if(temp>=Integer.MAX_VALUE)
                        return Integer.MAX_VALUE;
                    else
                        return Integer.parseInt(ans);
                }
            }
        }
        return 0;
    }
	    
	    public static void main(String args[]){
	    	StringtoInt obj = new StringtoInt();
	    	String str = new String("      -11919730356x");
	    	obj.myAtoi(str);
	    }
}
