package arrays;

import java.util.*;

public class OddNumbers{

  public ArrayList<Integer> findOddFreqNumbers(int[] a){
    HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
    int count = 0;
    for(int no:a){
      if(freq.containsKey(no)){
        count = freq.get(no)+1;
        freq.put(no,count);
      }
      else
        freq.put(no,1);
    }
    
    ArrayList<Integer> res = new ArrayList<Integer>();
    Set entries = freq.entrySet();
    Iterator iterator = entries.iterator();
    while(iterator.hasNext())
    {
      Map.Entry entry = (Map.Entry) iterator.next();
      if((int)(entry.getValue())%2!=0)
        res.add((int)(entry.getKey()));
    }
    return res;
  }
  

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    OddNumbers obj = new OddNumbers();
    int n = sc.nextInt();
    int[] ip = new int[n];
    for(int i = 0; i<n; i++)
      ip[i] = sc.nextInt();
    ArrayList<Integer> res = obj.findOddFreqNumbers(ip);
    for(int i:res)
      System.out.print(i+" ");
    
  }
}