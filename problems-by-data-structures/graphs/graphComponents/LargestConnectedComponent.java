package graphComponents;

import java.util.LinkedList;
import java.util.List;

public class LargestConnectedComponent {
	private int[][] adjMat;
	private boolean[] nodes;
	private int lcSize = 0;
	private int firstNode = 0;
	private int farthestNode = 0;
	private int diameter = 0;
	

	public void findLCC(Graph g) {
		adjMat = g.getAdjacencyMatrix();
		nodes = g.getNodes();
		int count = 0;

		for (int i = 0; i < nodes.length; i++) {
			count = BFS(i);
			//System.out.println(count);
			if (count > lcSize) {
				lcSize = count;
				firstNode = i;
			}
			nodes = new boolean[nodes.length];
		}
		System.out.println("Size of Largest Connected Component is:" + lcSize);
		//nodes = new boolean[nodes.length];
		//System.out.println(BFS(firstNode));
		
		DFS(firstNode,0);
		System.out.println("Diameter of the largest connected component is :"+(diameter+1));
		System.out.println("The farthest two vertices are " + firstNode + " " + farthestNode);
	}

	public void DFS(int node, int depth) {

		for (int i = 0; i < nodes.length; i++) {
			if (adjMat[node][i] == 1) {
				if (!nodes[i]) {		
					System.out.println("From "+ node + " to " + i + " at depth "+ depth);
					nodes[i] = true;
					if (depth >= diameter) {
						diameter = depth;
						farthestNode = i;
					}
					DFS(i, depth + 1);
				}				
			}

		}
	}

	/*
	 * public int BFS(int node) { List<Integer> nextq = new
	 * LinkedList<Integer>(); List<Integer> currq = new LinkedList<Integer>();
	 * int count = 0; currq.add(node); count++; nodes[node] = true; int temp;
	 * while (!currq.isEmpty()) { temp = currq.remove(0); for (int i = 0; i <
	 * adjMat.length; i++) { if (adjMat[temp][i] == 1 && !nodes[i]) {
	 * nextq.add(i); nodes[i] = true; count++; } } if (currq.isEmpty()) { if
	 * (nextq.size() > diameter) { diameter = nextq.size(); firstNode =
	 * nextq.get(0); farthestNode = nextq.get(diameter - 1); } currq = nextq;
	 * nextq = new LinkedList<Integer>(); } } return count; }
	 */

	public int BFS(int node) {
		List<Integer> q = new LinkedList<Integer>();
		int count = 0;
		q.add(node);
		count++;
		nodes[node] = true;
		int temp;
		while (!q.isEmpty()) {
			temp = q.remove(0);
			for (int i = 0; i < adjMat.length; i++) {
				if (adjMat[temp][i] == 1 && !nodes[i]) {
					q.add(i);
					nodes[i] = true;
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		LargestConnectedComponent lc = new LargestConnectedComponent();
		Graph g = new Graph();
		g.buildAdjacencyMatrix();
		// g.displayAdjMat();
		lc.findLCC(g);

	}
}
