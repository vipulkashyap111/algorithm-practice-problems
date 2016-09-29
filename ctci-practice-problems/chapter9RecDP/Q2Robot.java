package chapter9RecDP;

public class Q2Robot {
	
	public static int offLimitX, offLimitY;
	public static boolean isDownValid(int x, int y, int X, int Y){
		if((y+1<=Y) && !(x == offLimitX && (y+1) == offLimitY))
			return true;
		return false;
	}
	
	public static boolean isRightValid(int x, int y, int X, int Y){
		if((x+1)<=X && !(y == offLimitY && (x+1)==offLimitX))
			return true;
		return false;
	}
	
	public static int countPaths(int x, int y, int X, int Y){
		int count1 = 0 , count2 = 0;
		if(x == X && y == Y)
			return 1;
		if(isDownValid(x, y, X, Y)){
			count1 = countPaths(x, y+1, X, Y);
		}
		if(isRightValid(x, y, X, Y)){
			count2 = countPaths(x+1,y,X,Y);
		}
		return count1 + count2;
	}
	
	public static void main(String[] args){		
		int X = 2;
		int Y = 2;
		offLimitX = 2;
		offLimitY = 1;
		int count = countPaths(0,0,X,Y);
		System.out.println(count);
	}
}
