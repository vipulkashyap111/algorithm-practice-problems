package practice;

public class MultiplyStrings {
	public String multiply(String num1, String num2) {
        int n = num2.length();
        int m = num1.length();
        if(m == 0 || n == 0){
            return "";
        }
        if(m < n)
            return multiply(num2,num1);
        
        if(num1.equals("0")||num2.equals("0"))
        	return "0";
        StringBuilder tempSum = new StringBuilder("0");
        
        String currMul;
        for(int i = 0; i < n; i++){
            currMul = multiply(num1,num2.charAt(n-1-i));
            tempSum = add(tempSum,currMul, i);
        }
        return tempSum.toString();
    }
    
    public String multiply(String num, char ch){
        int n = num.length();
        int val = ch-'0';
        int carry = 0, mul = 0;
        StringBuilder res = new StringBuilder();
        for(int i = 0; i<n; i++){
            mul = (num.charAt(n-1-i) - '0')*val + carry;
            carry = 0;
            if(mul>=10){
            	carry = mul/10;
            	mul%=10;
                
            }
            res.insert(0,mul);
        }
        if(carry!=0){
        	res.insert(0, carry);
        }
        return res.toString();
    }
    
    public StringBuilder add(StringBuilder num1, String num2, int offset){
        int counter1 = num1.length()-1;
        int counter2 = num2.length()-1;
        StringBuilder res = new StringBuilder();
        
        for(int i = 0; i<offset; i++){
            res.insert(0,num1.charAt(counter1)-'0');
            counter1--;
        }
        int carry = 0, sum = 0;
        while(counter1>=0 && counter2>=0){
            sum = carry + (num1.charAt(counter1)-'0') + (num2.charAt(counter2)-'0');
            carry = 0;
            if(sum>=10){
                sum%=10;
                carry = 1;
            }
            res.insert(0,sum);
            counter1--;
            counter2--;
        }
        
        while(counter1>=0){
            sum = carry + (num1.charAt(counter1)-'0');
            carry = 0;
            if(sum>=10){
                sum%=10;
                carry = 1;
            }
            res.insert(0,sum);
            counter1--;
        }
        
        while(counter2>=0){
            sum = carry + (num2.charAt(counter2)-'0');
            carry = 0;
            if(sum>=10){
                sum%=10;
                carry = 1;
            }
            res.insert(0,sum);
            counter2--;
        }
        if(carry!=0){
        	res.insert(0, carry);
        }
        return res;
    }
    
    public static void main(String[] args){
    	MultiplyStrings obj = new MultiplyStrings();
    	String res = obj.multiply("50", "40");
    	System.out.println(res);
    }
}
