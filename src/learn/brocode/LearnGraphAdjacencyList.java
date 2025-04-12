package learn.brocode;

import java.util.ArrayList;
import java.util.LinkedList;

public class LearnGraphAdjacencyList {
	public static void main(String[] args) {
		GraphAL graph = new GraphAL(5);
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
		// System.out.println(graph.checkEdge(0, 1));
	}
}

class GraphAL {

	ArrayList<LinkedList<NodeBFS>> alist;

	public GraphAL(int size) {
		alist = new ArrayList<>();
	}

	public void addNode(NodeBFS node) {
		LinkedList<NodeBFS> currentList = new LinkedList<>();
		currentList.add(node);
		alist.add(currentList);
	}

	public void addEdge(int from, int to) {
		LinkedList<NodeBFS> currentList = alist.get(from);
		NodeBFS toNode = alist.get(to).get(0);
		currentList.add(toNode);
	}

	public boolean checkEdge(int from, int to) {
		LinkedList<NodeBFS> currentList = alist.get(from);
		NodeBFS toNode = alist.get(to).get(0);

		for (NodeBFS node : currentList) {
			if (node == toNode) {
				return true;
			}
		}

		return false;
	}

	public void print() {
		for (LinkedList<NodeBFS> currentList : alist) {
			for (NodeBFS node : currentList) {
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