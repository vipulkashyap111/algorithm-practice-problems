package codingChallengePractice;
import java.util.*;
public class ValidParenthesis {
	static boolean isValid(String ip){
        Map<Character,Character> map = new HashMap<Character,Character>();
        map.put('{','}');
        map.put('(',')');
        map.put('[',']');
        Stack<Character> s = new Stack<Character>();
        char ch;
        for(int i=0;i<ip.length();i++){
            ch = ip.charAt(i);
            if(map.containsKey(ch)){//Insert only if input character is one of the parenthesis
                s.push(ch);
            }else if(map.containsValue(ch) && s.isEmpty()){//There is a mismatch as Stack is empty and we encounter a closing brace
                return false;
            }else if(map.containsValue(ch) && (char)(map.get(s.peek()))!=ch){//The braces are not balanced as stack top and current                                                                                       closing brace do not match
                return false;
            }else if(map.containsValue(ch) && (char)(map.get(s.peek()))==ch){//Current set of braces is balanced
                s.pop();
            }
        }
        if(s.isEmpty())
            return true;
        return false;
    }
	
	public static void main(String[] args){
		boolean res = isValid("");
		System.out.println(res);
	}
}
