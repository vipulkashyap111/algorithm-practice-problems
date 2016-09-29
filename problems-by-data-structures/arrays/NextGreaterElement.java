package arrays;
import java.util.Stack;
public class NextGreaterElement {
	
	Stack s = new Stack();
  
  public void printNGE(int[] a){
    s.push(a[0]);
    int next = -1;
    int element = 0;
    for(int i = 1; i<a.length; i++){
      next = a[i];
      element = (int)s.pop();
      if(next>element){        
        while(next>element){
          System.out.println(element+"->"+next);
          if(s.isEmpty()){
            break;
          }
          element = (int)s.pop();
        }
        if(element>next)
        	s.push(element);
      }
      else{
        s.push(element);
      }
      s.push(next);
    }
    
    while(!s.isEmpty()){
      System.out.println(s.pop()+"->-1");
    }
  }
  
  public static void main(String[] args){
    NextGreaterElement obj = new NextGreaterElement();
    int[] a = {13, 7, 6, 12};
    obj.printNGE(a);
  }
}
