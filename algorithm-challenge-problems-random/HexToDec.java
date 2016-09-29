package interview;

import java.util.*;

public class HexToDec{
	
	public static int getDecimalValue(char ch){
		int n = Integer.MIN_VALUE;
		switch(ch){
		case '0': n = 0; break;
		case '1': n = 1;break;
		case '2': n = 2;break;
		case '3': n = 3;break;
		case '4': n = 4;break;
		case '5': n = 5;break;
		case '6': n = 6;break;
		case '7': n = 7;break;
		case '8': n = 8;break;
		case '9': n = 9;break;
		case 'A': n = 10;break;
		case 'B': n = 11;break;
		case 'C': n = 12;break;
		case 'D': n = 13;break;
		case 'E': n = 14;break;
		case 'F': n = 15;break;
		}
		return n;
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		String ip = sc.next();
		int n = ip.length();
		int val = 0;
		int power = 0;
		char ch;
		int temp= 0;
		for(int i = n-1; i>= 0;i--){
			ch = ip.charAt(i);
			temp = getDecimalValue(ch);
			val += temp * Math.pow(16,power);
			power++;
		}
		System.out.println("Decimal value for the given hexadecimal number is: "+val);
	
	}
}
