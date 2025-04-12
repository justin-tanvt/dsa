package learn.brocode;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class LearnBreadthFirstSearch {
	public static void main(String[] args) {
		GraphBFS graph = new GraphBFS(5);
		graph.addNode(new NodeBFS('A'));
		graph.addNode(new NodeBFS('B'));
		graph.addNode(new NodeBFS('C'));
		graph.addNode(new NodeBFS('D'));
		graph.addNode(new NodeBFS('E'));

		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
    graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(4, 0);
		graph.addEdge(4, 2);
		
		graph.print();
		graph.breadthFirstSearch(0);
	}
}

class GraphBFS {

	ArrayList<NodeBFS> nodes;
	int[][] matrix;

	public GraphBFS(int size) {
		nodes = new ArrayList<>();
		matrix = new int[size][size];
	}

	public void addNode(NodeBFS node) {
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
		for (NodeBFS node : nodes) {
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
		System.out.println();
	}

	public void breadthFirstSearch(int node) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[matrix.length];

		// add starting node to queue and mark as visited
		queue.offer(node);
		visited[node] = true;

		while (queue.size() != 0) {
			// process node from queue
			node = queue.poll();
			System.out.println(nodes.get(node).data + " = visited");

			// explore nodes adjacent to current node, breadth-wise
			for (int i = 0; i < matrix[node].length; i++) {
				// add to queue if connected and not visited yet
				if (matrix[node][i] == 1 && !visited[i]) {
					queue.offer(i);
					// mark as visited once queued
					// to prevent double queueing
					visited[i] = true;
				}
			}
		}
	}

}

class NodeBFS {
	char data;

	public NodeBFS(char data) {
		this.data = data;
	}
}