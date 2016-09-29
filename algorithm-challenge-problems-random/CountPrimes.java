package codingChallengePractice;

import java.util.ArrayList;

public class CountPrimes {
	static int dodgeBall(long n) {
        int res = funcCountPrime(n);
        return res;
    }
    
    public static int funcCountPrime(long n){
        if (n <= 2)
            return (int)n;
        
        ArrayList<Boolean> primes = new ArrayList<Boolean>();
        for (int i = 2; i < n; i++)
            primes.add(true);
        
        for (int i = 2; i <= Math.sqrt(n-1); i++){
            if ((boolean)primes.get(i)==true){
                for(int j = i + 1; j < n; j += i)
                    primes.set(j, false);
            }
        }
        
        int count = 0;
        for (int i = 2; i < n; i++){
            if ((boolean)primes.get(i)==true)
                count++;
        }
        return ++count;
    }
	public static void main(String[] args){
		CountPrimes cp = new CountPrimes();
		System.out.println(cp.dodgeBall(4900000000L));
	}
}
