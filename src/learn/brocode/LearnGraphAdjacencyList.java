package learn.brocode;

import java.util.ArrayList;
import java.util.LinkedList;

public class LearnGraphAdjacencyList {
	public static void main(String[] args) {
		GraphAL graph = new GraphAL(5);
		graph.addNode(new NodeAL('A'));
		graph.addNode(new NodeAL('B'));
		graph.addNode(new NodeAL('C'));
		graph.addNode(new NodeAL('D'));
		graph.addNode(new NodeAL('E'));

		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
    graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(4, 0);
		graph.addEdge(4, 2);
		
		graph.print();
		// System.out.println(graph.checkEdge(0, 1));
	}
}

class GraphAL {

	ArrayList<LinkedList<NodeAL>> alist;

	public GraphAL(int size) {
		alist = new ArrayList<>();
	}

	public void addNode(NodeAL node) {
		LinkedList<NodeAL> currentList = new LinkedList<>();
		currentList.add(node);
		alist.add(currentList);
	}

	public void addEdge(int from, int to) {
		LinkedList<NodeAL> currentList = alist.get(from);
		NodeAL toNode = alist.get(to).get(0);
		currentList.add(toNode);
	}

	public boolean checkEdge(int from, int to) {
		LinkedList<NodeAL> currentList = alist.get(from);
		NodeAL toNode = alist.get(to).get(0);

		for (NodeAL node : currentList) {
			if (node == toNode) {
				return true;
			}
		}

		return false;
	}

	public void print() {
		for (LinkedList<NodeAL> currentList : alist) {
			for (NodeAL node : currentList) {
				System.out.print(node.data + " -> ");
			}
			System.out.println();
		}
	}

}

class NodeAL {
	char data;

	public NodeAL(char data) {
		this.data = data;
	}
}
