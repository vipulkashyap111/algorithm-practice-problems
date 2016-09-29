package arrays;

public class Stack{
	  int[] a;
	  int top;
	  
	  Stack(int n){
	    a = new int[n];
	    top = 0;
	  }
	  
	  public boolean isEmpty(){
	    if(top==0)
	      return true;
	    else
	      return false;
	  }
	  
	  public boolean isFull(){
	    if(top==a.length)
	      return true;
	    else
	      return false;
	  }
	  
	  public int peek() throws Exception{
	    if(!isEmpty())
	      return a[top-1];
	    else
	    	return 0;
	  }
	  
	  public void push(int n) throws Exception{
	    if(!isFull()){
	      a[top] = n;
	      top++;
	    }
	    else{
	      throw new Exception("Stack is full!");
	    }
	  }
	  
	  public int pop() throws Exception{
	    if(isEmpty())
	      throw new Exception("Stack is Empty!");
	    else{
	      return a[--top];
	    }
	  }
	}