package graphComponents;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Graph {
	private boolean[] nodes;
	private int[][] adjacencyMatrix;

	public void initializeNodes(int noOfVertices){
		nodes = new boolean[noOfVertices];
		for(int i = 0; i<noOfVertices; i++){
			nodes[i] = false;
		}
	}
	
	public void initializeAdjMat(int noOfVertices){
		adjacencyMatrix = new int[noOfVertices][noOfVertices];
		for(int i = 0; i<noOfVertices; i++){
			for(int j = 0; j<noOfVertices; j++){
				adjacencyMatrix[i][j] = 0;
			}
		}
	}
	
	public void buildAdjacencyMatrix() {
		BufferedReader br = null;
		int noOfVertices = 0;
		String currentLine = null;
		String[] temp = new String[2];
		int fromNode = 0, toNode = 0;
		try {
			InputStream input = getClass().getResourceAsStream("dolphins.txt");
			br = new BufferedReader(new InputStreamReader(input));
			if((currentLine = br.readLine())!=null){
				noOfVertices = Integer.parseInt(currentLine);							
				initializeNodes(noOfVertices);
				initializeAdjMat(noOfVertices);
			}
			while((currentLine = br.readLine())!=null){
				temp = currentLine.split("\\s+");
				fromNode = Integer.parseInt(temp[0]);
				toNode = Integer.parseInt(temp[1]);
				adjacencyMatrix[fromNode][toNode] = 1;
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
	}
	
	public int[][] getAdjacencyMatrix(){
		return adjacencyMatrix;
	}
	
	public boolean[] getNodes(){
		return nodes;
	}
	
	public void displayAdjMat(){
		for(int i = 0; i<adjacencyMatrix.length; i++){
			for(int j = 0; j<adjacencyMatrix[0].length; j++){
				System.out.print(adjacencyMatrix[i][j]+" ");
			}
			System.out.println();
		}
	}
}
