package graphComponents;

public class Node {

	private int id;
	private boolean visited;
	
	Node(int id){
		this.id = id;
		visited = false;
	}
	
	public int getID(){
		return this.id;
	}
	
	public void markVisited(){
		this.visited = true;
	}
	
	public boolean isVisited(){
		return this.visited;
	}
}
