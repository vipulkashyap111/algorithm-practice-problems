package codingChallengePractice;

public class Fibonacci {
	static int[] fibonacci(int n) {
        int[] fib = new int[n];
        fib[0]=0;
        if(n>1){
           fib[1]=1;
            for(int i = 2; i<n;i++){
                fib[i]=fib[i-1]+fib[i-2];
            } 
        }        
        return fib;
    }
	
	public static void main(String[] args){
		int[] res = fibonacci(2);
		for(int i:res)
			System.out.print(i+" ");
	}
}
