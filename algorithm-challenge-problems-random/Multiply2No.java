package codingChallengePractice;
import java.util.*;
public class Multiply2No {

	public String multiply(String s1, String s2){
		
		int m = s1.length();
		int n = s2.length();
		if(n>m)
			multiply(s2,s1);
		int carry = 0;
		int val = 0;
		int bigger = 0;
		StringBuffer s = new StringBuffer();
		LinkedList<Integer> current = new LinkedList<Integer>();
		//List<LinkedList<Integer>> imd = new ArrayList<LinkedList<Integer>>();
		for(int i=n-1;i>=0;i--){
			carry = 0;
			for(int k = i;k<n-1;k++)
				current.add(0,0);
			for(int j = m-1;j>=0;j--){
				val = (s2.charAt(i)-'0')*(s1.charAt(j)-'0')+carry;
				if(val>=10){
					carry = val/10;
					val = val%10;
				}
				current.add(0,val);
			}
			if(carry!=0)
				current.add(0,carry);
			s = add(s,current);			
			//imd.add(temp);
			current = new LinkedList<Integer>();
		}
		return s.toString();
	}
	
	public StringBuffer add(StringBuffer s, LinkedList<Integer> c){
		StringBuffer add = new StringBuffer();
		int i = s.length()-1;
		int j = c.size()-1;
		int carry = 0,val = 0;
		while(i>=0 && j>=0){
			val = (s.charAt(i)-'0')+c.get(j)+carry;
			if(val>=10){
				carry = val/10;
				val = val%10;
			}
			c.set(j, val); 
			i--;
			j--;
		}
		if(i==-1){
			while(carry!=0 && j>=0){
				val = c.get(j)+carry;
				carry = 0;
				if(val>=10){
					carry = val/10;
					val = val%10;
				}
				c.set(j, val);
				j--;
			}
			if(j<0 && carry!=0)
				c.add(0,carry);
		}else if(j==-1){
			while(carry!=0 && i>=0){
				val = s.charAt(i)-'0'+carry;
				if(val>=10){
					carry = val/10;
					val = val%10;
				}
				c.add(0, val);
				i--;
			}
			if(i<0 && carry!=0)
				c.add(0,carry);
		}
		for(Integer a:c)
			add.append(a);
		return add;
	}
	
	public static void main(String[] args){
		Multiply2No m = new Multiply2No();
		System.out.println(m.multiply("100", "10"));
	}
}
