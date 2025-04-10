import java.util.ArrayList;
import java.util.LinkedList;

public class LearnGraphAdjacencyList {
	public static void main(String[] args) {
		GraphAL graph = new GraphAL(5);
		graph.addNode(new Node('A'));
		graph.addNode(new Node('B'));
		graph.addNode(new Node('C'));
		graph.addNode(new Node('D'));
		graph.addNode(new Node('E'));

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

	ArrayList<LinkedList<Node>> alist;

	public GraphAL(int size) {
		alist = new ArrayList<>();
	}

	public void addNode(Node node) {
		LinkedList<Node> currentList = new LinkedList<>();
		currentList.add(node);
		alist.add(currentList);
	}

	public void addEdge(int from, int to) {
		LinkedList<Node> currentList = alist.get(from);
		Node toNode = alist.get(to).get(0);
		currentList.add(toNode);
	}

	public boolean checkEdge(int from, int to) {
		LinkedList<Node> currentList = alist.get(from);
		Node toNode = alist.get(to).get(0);

		for (Node node : currentList) {
			if (node == toNode) {
				return true;
			}
		}

		return false;
	}

	public void print() {
		for (LinkedList<Node> currentList : alist) {
			for (Node node : currentList) {
				System.out.print(node.data + " -> ");
			}
			System.out.println();
		}
	}

}

class Node {
	char data;

	public Node(char data) {
		this.data = data;
	}
}