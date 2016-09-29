package dijkstrasAlgorithms;

public class Vertex {
	int label;
	int distance;
	int parent;
	int noOfEdges;
	
	Vertex(){
		distance = Integer.MAX_VALUE;
		parent =Integer.MIN_VALUE;
		noOfEdges = Integer.MAX_VALUE;
	}
	
	Vertex(int value){
		label = value;
		distance = Integer.MAX_VALUE;
		parent = Integer.MIN_VALUE;
		noOfEdges = Integer.MAX_VALUE;
	}
	
	Vertex(int distance, int parent){
		this.distance = distance;
		this.parent = parent;
		noOfEdges = Integer.MAX_VALUE;
	}
}
