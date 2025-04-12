package learn.brocode;

import java.util.ArrayList;

public class LearnGraphAdjacencyMatrix {
	public static void main(String[] args) {
		GraphAM graph = new GraphAM(5);
		graph.addNode(new NodeAM('A'));
		graph.addNode(new NodeAM('B'));
		graph.addNode(new NodeAM('C'));
		graph.addNode(new NodeAM('D'));
		graph.addNode(new NodeAM('E'));

		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
    graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(4, 0);
		graph.addEdge(4, 2);
		
		graph.print();

		System.out.println(graph.checkEdge(0, 1));
	}
}

class GraphAM {

	ArrayList<NodeAM> nodes;
	int[][] matrix;

	public GraphAM(int size) {
		nodes = new ArrayList<>();
		matrix = new int[size][size];
	}

	public void addNode(NodeAM node) {
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
		for (NodeAM node : nodes) {
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
}

class NodeAM {
	char data;

	public NodeAM(char data) {
		this.data = data;
	}
}
