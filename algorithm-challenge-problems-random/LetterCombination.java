package practice;
import java.util.*;
public class LetterCombination {
	HashMap<Character,String> map;
    public List<String> letterCombinations(String digits) {
        map = new HashMap<Character,String>();
        fillMap(map);
        List<String> res = new ArrayList<String>();
        if(digits.isEmpty())
            return res;
        char[] ch = new char[digits.length()];
        letterCombinations(digits,res,ch,0);
        return res;
    }
    
    public void letterCombinations(String digits, List<String> res, char[] ch, int index){
        if(index==ch.length){
        	res.add(String.copyValueOf(ch));
        	return;
        }            
        String str = map.get(digits.charAt(index));
        for(int i =0; i<str.length();i++){
            ch[index] = str.charAt(i);
            letterCombinations(digits,res,ch,index+1);
        }
    }
    
    public void fillMap(HashMap<Character,String> map){
        map.put('1',"");
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        map.put('0',"");
    }
    
    public static void main(String[] args){
    	LetterCombination obj = new LetterCombination();
    	obj.letterCombinations("23");
    }
}
