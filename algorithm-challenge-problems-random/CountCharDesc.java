package codingChallengePractice;

import java.util.*;

public class CountCharDesc {

	public Map<Character,Integer> frequency(String s){
		Map<Character,Integer> freq = new HashMap<Character,Integer>();
		char ch = 'a';
		for(int i=0;i<s.length();i++){
			ch = s.charAt(i);
			if(freq.containsKey(ch)){
				freq.put(ch, freq.get(ch)+1);
			}else{
				freq.put(ch,1);
			}
		}
		
		List<Map.Entry<Character, Integer>> list = new LinkedList<Map.Entry<Character,Integer>>(freq.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>(){
			public int compare(Map.Entry<Character, Integer> entry1, Map.Entry<Character, Integer> entry2) {
				return entry2.getValue().compareTo(entry1.getValue());
			}
		});
		Map<Character,Integer> res = new LinkedHashMap<Character,Integer>();
		for(Map.Entry<Character, Integer> entry:list){
			res.put(entry.getKey(), entry.getValue());
		}
		return res;
	}
	
	public static void main(String[] args){
		CountCharDesc obj = new CountCharDesc();		 
		String s = "abcabbcbccc";
		Map<Character,Integer> res = obj.frequency(s);
		Set set =res.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()){
			Map.Entry entry = (Map.Entry)it.next();
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}
}
