package interview;

import java.util.*;

public class Reversal{

	public String reverseString(String in){
		int l = in.length();
		if(l==1)
			return in;
		char[] c = in.toCharArray();		//to store reversed characters
		char temp;
		for(int i = 0; i < l/2; i++)
		{
			temp = in.charAt(l-i-1);
			c[l-i-1] = c[i];
			c[i] = temp;
		}
		return new String(c);
	}

	public String reverseWords(String n){
		String r = reverseString(n);		//Eg. "gnirts a si sihT"
		int i = 0;
		int j = 0;
		StringBuilder op = new StringBuilder();
		while(i<r.length()){
			if(r.charAt(i)==' '){
				op.append(reverseString(r.substring(j,i)));
				op.append(" ");
				while(r.charAt(i+1)==' ') i++;		//Skip all whitespaces between words
				j = i + 1;
			}
		i++;
		}
		op.append(reverseString(r.substring(j,r.length())));
		return op.toString();
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		String ip = sc.nextLine();	//Eg. "This is a string."
		boolean hasPeriod = false;
		if(ip.contains(".")){
			hasPeriod = true;
			ip = ip.substring(0,ip.length()-1);
		}
		
		Reversal obj = new Reversal();
		String op = obj.reverseWords(ip);
		if(hasPeriod)
			op = op + ".";
		System.out.println("String with words reversed for input "+ip+ " is: "+op);
	}
}
