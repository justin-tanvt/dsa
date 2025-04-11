public class LearnBinarySearchTree {
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();

   	tree.insert(new NodeBST(5));
		tree.insert(new NodeBST(1));
		tree.insert(new NodeBST(9));
		tree.insert(new NodeBST(2));
		tree.insert(new NodeBST(7));
		tree.insert(new NodeBST(3));
		tree.insert(new NodeBST(6));
		tree.insert(new NodeBST(4));
		tree.insert(new NodeBST(8));

  	tree.display();

  	System.out.println(tree.search(9));
	}
}

class BinarySearchTree {
	NodeBST root;

	public void insert(NodeBST node) {
		root = insertHelper(root, node);
	}

	private NodeBST insertHelper(NodeBST root, NodeBST node) {
		if (root == null) {
			root = node;
			return root;
		}

		int data = node.data;
		if (data < root.data) {
			root.left = insertHelper(root.left, node);
		} else {
			root.right = insertHelper(root.right, node);
		}

		return root;
	}

	public void display() {
		displayHelper(root);
	}

	private void displayHelper(NodeBST root) {
		if (root != null) {
			displayHelper(root.left);
			System.out.println(root.data);
			displayHelper(root.right);
		}
	}

	public boolean search(int data) {
		return searchHelper(root, data);
	}

	private boolean searchHelper(NodeBST root, int data) {
		if (root == null) {
			return false;
		}

		if (data == root.data) {
			return true;
		} else if (data < root.data) {
			return searchHelper(root.left, data);	
		} else {
			return searchHelper(root.right, data);	
		}
	}

	public void remove(int data) {
		if (search(data)) {
			removeHelper(root, data);
		} else {
			System.out.println(data + " could not be found!");
		}
	}

	private NodeBST removeHelper(NodeBST root, int data) {
		if (root == null) {
			return root;
		}

		if (data < root.data) {
			root.left = removeHelper(root.left, data);
		} else if (data > root.data) {
			root.right = removeHelper(root.right, data);
		} else {
			if (root.left == null && root.right == null) {
				root = null;
			} else if (root.right != null) {
				root.data = successor(root);
				root.right = removeHelper(root.right, root.data);
			} else {
				root.data = predecessor(root);
				root.left = removeHelper(root.left, root.data);
			}
		}

		return root;
	}

	private int successor(NodeBST root) {
		root = root.right;
		while (root.left != null) {
			root = root.left;
		}
		return root.data;
	}

	private int predecessor(NodeBST root) {
		root = root.left;
		while (root.right != null) {
			root = root.right;
		}
		return root.data;
	}

}

class NodeBST {
	int data;
	NodeBST left;
	NodeBST right;

	public NodeBST(int data) {
		this.data = data;
	}
}