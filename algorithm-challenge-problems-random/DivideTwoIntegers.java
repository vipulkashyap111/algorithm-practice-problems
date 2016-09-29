package practice;

public class DivideTwoIntegers {
	public int negate(int a){
        int d = a>0?-1:1;
        int neg = 0;
        while(a!=0){
            neg+=d;
            a+=d;
        }
        return neg;
    }
    
    public int abs(int a){
        if(a<0)
            return negate(a);
        return a;
    }
    public int divide(int dividend, int divisor) {
        if(divisor==0)
            return Integer.MAX_VALUE;
        int x = 0;
        int a = abs(dividend);
        int b = abs(divisor);
        if(b>a)
            return 0;
        int sum = 0;
        while(sum+b<=a){
            sum+=b;
            x++;
        }
        
        if((divisor<0 && dividend<0)||(divisor>0 && dividend>0))
            return x;
        else
            return negate(x);
    }
    
    public static void main(String[] args){
    	DivideTwoIntegers d = new DivideTwoIntegers();
    	System.out.println(d.divide(-2147483648, -1));
    }
}
