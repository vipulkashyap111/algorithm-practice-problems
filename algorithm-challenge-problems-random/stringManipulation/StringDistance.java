package stringManipulation;

import java.util.*;

public class StringDistance{

  public int editDistance(String one, String two){
    int[][] distance = new int[two.length()+1][one.length()+1];
    for(int i = 0; i<distance.length;i++){
      distance[i][0] = i;
    }
    
    for(int j = 0; j<distance[0].length;j++){
      distance[0][j] = j;
    }
    
    for(int i = 1; i<distance.length;i++){
      for(int j = 1; j<distance[0].length;j++){
        if(one.charAt(j-1) == two.charAt(i-1)){
          distance[i][j]= distance[i-1][j-1];
        }
        else{
          distance[i][j] = min(distance[i][j-1],distance[i-1][j-1],distance[i-1][j])+1;
        }
      }
    }
    return distance[distance.length-1][distance[0].length-1];
  }
  
  public int min(int i, int j, int k){
    int l = i<j?i:j;
    return l<k?l:k;
  }
  
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    StringDistance obj = new StringDistance();
    String one =sc.next();
    String two = sc.next();
    int distance = obj.editDistance(one, two);
    System.out.println(distance);
  }
}