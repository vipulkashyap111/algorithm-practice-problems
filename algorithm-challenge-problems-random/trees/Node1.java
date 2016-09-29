package trees;

public class Node1{
	  int label;
	  boolean visited = false;
	  Node1 left, right, parent;
	  
	  Node1(){
	    this.label = label;
	    this.visited = false;
	    this.left = this.right = this.parent = null;
	  }
	  
	  Node1(int label){
	    this.label = label;
	    this.visited = false;
	    this.left = this.right = this.parent = null;
	  }
	}

