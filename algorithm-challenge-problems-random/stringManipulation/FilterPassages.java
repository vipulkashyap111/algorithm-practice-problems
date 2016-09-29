package stringManipulation;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilterPassages {
	List<String> passages;
	public void readPassages(String location){
		String filePath = new File("").getAbsolutePath();
		passages = new ArrayList<String>();
		String line = null;
		try {
			BufferedReader in = new BufferedReader(new FileReader(filePath + location));
			while((line=in.readLine())!=null){
				if(!line.isEmpty())
					passages.add(line);
			}
			in.close();
		} catch (IOException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		
		//for(String s:passages)
			//System.out.println(s);
	}
	
	public void filter(){
		
		String passage1=null, passage2=null,pattern=null,larger=null;
		for(int i = 0; i<passages.size();i++){
			passage1 = passages.get(i);
			for(int j = i+1;j<passages.size();j++){
				
				passage2 = passages.get(j);				
				pattern = passage1.length()<=passage2.length()?passage1:passage2;
				larger = passage1.length()>passage2.length()?passage1:passage2;
				Pattern r = Pattern.compile(pattern);
				Matcher m = r.matcher(larger);
				if(m.find()){
					System.out.println(m.group(0));
					break;
				}
			}
		}
	}
	
	public static void main(String[] args){
		FilterPassages obj = new FilterPassages();
		String location = "/src/stringManipulation/Passages.txt";
		obj.readPassages(location);
		obj.filter();
	}
}
