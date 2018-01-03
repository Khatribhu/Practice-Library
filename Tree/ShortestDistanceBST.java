package first.Tree;
/* ====================================== */
/* Copyright (c) 2017 BK Corporation. */
/*          All rights reserved.          */
/* ====================================== */
public class ShortestDistanceBST {
	
	static Node root;
	/**
	 * Find LCA between two nodes.
	 * 
	 * @param node
	 * @param alpha
	 * @param beta
	 * @return
	 */
	public int findLCA(Node node, Node alpha, Node beta) {
		
		if(node == null) {
			return 0;
		}
		
		if (node.getData() <= alpha.getData() && node.getData() >= beta.getData()
				|| node.getData() >= alpha.getData() && node.getData() <= beta.getData()) {
			return distanceFromRoot(node, alpha.getData()) + distanceFromRoot(node, beta.getData());
		}

		//Both keys lies in the left.
		if (node.getData() > alpha.getData() && node.getData() > beta.getData()) {
			return findLCA(node.getLeft(), alpha, beta);
		}

		//Both keys lies in the right.
		if (node.getData() < alpha.getData() && node.getData() < beta.getData()) {
			return findLCA(node.getRight(), alpha, beta);
		}
		return 0;
	}
	
	
	/**
	 * This method to calcualte the distance of the node from the node.
	 * 
	 * @param node
	 * @param key
	 * @return
	 */
	public int distanceFromRoot(Node node, int key) {
		if (node == null) {
			return 0;
		} else {
			if (node.getData() > key) {
				return 1 + distanceFromRoot(node.getLeft(), key);
			} else if (node.getData() < key){
				return 1 + distanceFromRoot(node.getRight(), key);
			} else {
				return 0;
			}
		}
	}
	
	public void insert(int data) {
		root = insert(root, data);
	}

	/**
	 * Insert the nodes in tree.
	 * @param node
	 * @param data
	 * @return
	 */
	private Node insert(Node node, int data) {

		if (node == null) {
			node = new Node(data);
		} else {
			if (data < node.getData()) {
				node.left = insert(node.getLeft(), data);
			} else {
				node.right = insert(node.getRight(), data);
			}
		}

		return node;
	}

	
	public static void main(String[] args) {
		ShortestDistanceBST shortBST = new ShortestDistanceBST();
		
		shortBST.insert(20);
		shortBST.insert(10);
		shortBST.insert(5);
		shortBST.insert(15);
		shortBST.insert(30);
		shortBST.insert(25);
		shortBST.insert(35);
		
		Node alpha = new Node(5);
		Node beta = new Node(35);
		int a = 5, b = 35;
		
		int result = shortBST.findLCA(root, alpha, beta);
		System.out.println(result);
	}
	
}
