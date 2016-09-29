package dijkstrasAlgorithms;

import java.util.*;

public class AdjacencyGraph {
	public Map<Integer, List<Edge>> adj;
	public List<Vertex> vertex;
	public boolean[] usp;

	AdjacencyGraph(int v) {
		adj = new HashMap<Integer, List<Edge>>();
		vertex = new ArrayList<Vertex>();
		usp = new boolean[v];
		for (int i = 1; i <= v; i++){
			adj.put(i, new LinkedList<Edge>());
			Vertex u = new Vertex(i);
			vertex.add(u);
			usp[i-1] = true;
		}
			
	}

	public void setEdge(int src, int dest, int wt) {
		if (src > adj.size() || dest > adj.size()) {
			System.out.println("No such vertex exists in the graph");
		} else {
			Edge e = new Edge(dest, wt);
			List<Edge> sList = adj.get(src);
			sList.add(e);
		}
	}

	public List<Edge> getEdge(int src) {
		if (src > adj.size()) {
			System.out.println("No such vertex exists!");
			return null;
		} else
			return adj.get(src);
	}

	public void print(int v, int e) {
		for (int i = 1; i <= v; i++) {
			List<Edge> temp = getEdge(i);
			if (!temp.isEmpty()) {
				for (int j = 1;; j++) {
					if (j != temp.size())
						System.out.println(i + " -> " + temp.get(j - 1).vertex + " wt. " + temp.get(j - 1).weight);
					else {
						System.out.println(i + " -> " + temp.get(j - 1).vertex + " wt. " + temp.get(j - 1).weight);
						break;
					}
				}
			}
		}
	}
}