package learn.brocode;

import java.util.ArrayList;

public class LearnDepthFirstSearch {
	public static void main(String[] args) {
		GraphDFS graph = new GraphDFS(5);
		graph.addNode(new NodeDFS('A'));
		graph.addNode(new NodeDFS('B'));
		graph.addNode(new NodeDFS('C'));
		graph.addNode(new NodeDFS('D'));
		graph.addNode(new NodeDFS('E'));

		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
    graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(4, 0);
		graph.addEdge(4, 2);
		
		graph.print();
		graph.depthFirstSearch(3);
	}
}

class GraphDFS {

	ArrayList<NodeDFS> nodes;
	int[][] matrix;

	public GraphDFS(int size) {
		nodes = new ArrayList<>();
		matrix = new int[size][size];
	}

	public void addNode(NodeDFS node) {
		nodes.add(node);
	}

	public void addEdge(int from, int to) {
		matrix[from][to] = 1;	
	}

	public boolean checkEdge(int from, int to) {
		return matrix[from][to] == 1;
	}

	public void print() {
		System.out.print("  ");
		for (NodeDFS node : nodes) {
			System.out.print(node.data + " ");
		}
		System.out.println();

		for (int i = 0; i < matrix.length; i++) {
			System.out.print(nodes.get(i).data + " ");
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}	

	}

	public void depthFirstSearch(int node) {
		boolean[] visited = new boolean[matrix.length];
		dfsHelper(node, visited);
	}

	private void dfsHelper(int node, boolean[] visited) {
		// do not explore if already visited
		if (visited[node]) {
			return;
		// if new, add to visited
		} else {
			visited[node] = true;
			// perform some action
			System.out.println(nodes.get(node).data + " = visited");
		}

		// recursively visit every accessible adjacent node
		for (int i = 0; i < matrix[node].length; i++) {
			if (matrix[node][i] == 1) {
				dfsHelper(i, visited);
			}
		}
	}
}

class NodeDFS {
	char data;

	public NodeDFS(char data) {
		this.data = data;
	}
}