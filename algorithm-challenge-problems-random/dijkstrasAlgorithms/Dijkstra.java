package dijkstrasAlgorithms;

import java.util.*;

public class Dijkstra {
	
	static AdjacencyGraph g; 
	public void initialize_single_source(AdjacencyGraph g, int s){
		g.vertex.get(s-1).distance = 0;
		g.vertex.get(s-1).noOfEdges = 0;
	}
	
	public void relax(int u, int v, int w){
		if(g.vertex.get(v-1).distance>(g.vertex.get(u-1).distance+w)){
			g.vertex.get(v-1).distance = g.vertex.get(u-1).distance+w;
			g.vertex.get(v-1).parent = u;
			g.usp[v-1] = true;
		}
		else if(g.vertex.get(v-1).distance == (g.vertex.get(u-1).distance+w)){
			if(g.vertex.get(v-1).noOfEdges>g.vertex.get(u-1).noOfEdges+1)
				g.vertex.get(v-1).parent = u;
			g.usp[v-1] = false;
		}
	}
	
	public void printpath(){
		for(Vertex v : g.vertex){
			System.out.println(v.label+ " " + v.distance + " " + v.parent);
		}
	}
	
	public void printpath(int s, int d){
		Vertex temp = g.vertex.get(d-1);
		System.out.println("Path from destination to source is as follows:");
		while(temp.parent!=Integer.MIN_VALUE){
			System.out.print(temp.label + " ");
			temp = g.vertex.get(temp.parent - 1);
		}
		System.out.println(temp.label);
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of Vertices in the graph:");
		int v = sc.nextInt();
		System.out.println("Enter number of Edges in the graph");
		int e = sc.nextInt();
		int src, dest, wt;
		src = dest = wt = 0;
		g = new AdjacencyGraph(v);
		for (int i = 1; i <= e; i++) {
			System.out.println("Enter edges in the graph using the format: <source> <destination> <weight>");
			src = sc.nextInt();
			dest = sc.nextInt();
			wt = sc.nextInt();
			g.setEdge(src, dest, wt);
		}

		// Print the graph
		g.print(v,e);
		
		//Djikstra
		System.out.println("Enter the source vertex in the graph");
		int s = sc.nextInt();
		System.out.println("Enter the destination vertex in the graph");
		int d = sc.nextInt();
		
		Dijkstra obj = new Dijkstra();
		obj.initialize_single_source(g,s);
		
		List<Vertex> S = new ArrayList<Vertex>();
		Comparator<Vertex> comparator = new Comparator<Vertex>() {
			
			@Override
			public int compare(Vertex v1, Vertex v2) {
				return v1.distance - v2.distance;
			}
		};
		PriorityQueue<Vertex> Q = new PriorityQueue<Vertex>(comparator);
		for(int i = 0;i<v;i++){
			Q.add(g.vertex.get(i));
		}
		
		while(!Q.isEmpty()){
			Vertex u = Q.poll();
			S.add(u);
			List<Edge> adju = g.adj.get(u.label);
			for(Edge edge : adju){
				obj.relax(u.label, edge.vertex, edge.weight);
			}
			if(!Q.isEmpty())
			Q.add(Q.poll());
		}
		
		obj.printpath();
		obj.printpath(s,d);
		System.out.println("Destination USP "+ g.usp[d-1]);
	}
}
