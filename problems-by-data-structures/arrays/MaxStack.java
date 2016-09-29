package arrays;

import java.util.*;

public class MaxStack{
  Stack stack;
  Stack temp;
  
  MaxStack(int n){
    stack = new Stack(n);
    temp = new Stack(n);
  }
  
  public boolean isEmpty(){
    if(stack.isEmpty())
      return true;
    else
      return false;
  }
  
  public boolean isFull(){
    if(stack.isFull())
      return true;
    else
      return false;
  }
  
  public void push(int n) throws Exception{
    if(isFull()){
      throw new Exception("Stack is Full!");
    }
    else if(isEmpty()){
    	stack.push(n);
    	temp.push(n);
    }
    else{
      if(n>temp.peek()){
    	  stack.push(n);
    	  temp.push(n);
      }
      else{
    	  stack.push(n);
    	  temp.push(temp.peek());
      }    	  
    }
  }
  
  public int getMax() throws Exception{
	  return temp.peek();
  }
  
  public int pop() throws Exception{
    if(stack.isEmpty())
      throw new Exception("Stack is Empty!");
    else{
    	temp.pop();
    	return stack.pop();
    }
      
  }
  
  public static void main(String[] args) throws Exception{
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    MaxStack s = new MaxStack(n);
    s.push(4);
    System.out.println(s.getMax());
    s.push(2);
    s.push(5);
    s.pop();
    System.out.println(s.getMax());
    s.push(1);
    System.out.println(s.getMax());
    s.push(3);
    System.out.println(s.getMax());
    s.push(7);
    System.out.println(s.getMax());
    s.push(2);
    System.out.println(s.getMax());
    
    
  }
  
}
