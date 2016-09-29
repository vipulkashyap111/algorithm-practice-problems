package dynamicProgramming;
import java.util.*;

public class CoinChange{

  public int countWays(int[] coins, int N){
    int[][] table = new int[coins.length+1][N+1];
    
    for(int i=0; i<table.length;i++)
      table[i][0] = 1;
    
    for(int i = 1; i<table.length; i++){
      for(int j = 1; j<table[0].length; j++){
        if(coins[i-1]>j){ //Amount is less than coin value, copy from above row
          table[i][j] = table[i-1][j];
        }
        else{
          table[i][j] = table[i-1][j] + table[i][j-coins[i-1]];
        }
      }
    }
    return table[coins.length][N];
  }
  
  public static void main(String[] args){
    CoinChange obj = new CoinChange();
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt();
    int[] coins = new int[m];
    for(int i =0;i<m;i++){
      coins[i] = sc.nextInt();
    }
    int total = sc.nextInt();
    int res = obj.countWays(coins,total);
    System.out.println(res);
  }
}