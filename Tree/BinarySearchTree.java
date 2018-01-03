package first.Tree;

import java.util.Scanner;

/* ====================================== */
/* Copyright (c) 2017 BK Corporation. */
/*          All rights reserved.          */
/* ====================================== */
public class BinarySearchTree {
	private Node root;

	public BinarySearchTree() {
		this.root = null;
	}

	public BinarySearchTree(Node node) {
		root = node;
	}

	public boolean isEmpty() {
		return this.root == null ? true : false;
	}

	public void insert(int data) {
		root = insert(root, data);
	}

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

	public boolean search(int val) {
		return search(root, val);
	}

	/**
	 * Method to find the element in the tree. recusively.
	 * 
	 * @param node
	 * @param val
	 * @return
	 */
	private boolean search(Node node, int val) {
		if (node.getData() == val) {
			return true;
		}
		if (node.getData() < val) {
			search(node.getLeft(), val);
		} else {
			search(node.getRight(), val);
		}
		return false;
	}

	public int countNodes() {
		return countNodes(root);
	}

	public int countNodes(Node node) {
		if (node == null) {
			return 0;
		} else {
			int l = 1;
			l += countNodes(node.getLeft());
			l += countNodes(node.getRight());
			return l;
		}
	}

	public Node findMax(Node node) {
		int max = 0;

		if (node == null) {
			return null;
		}

		Node res = node;
		Node left = findMax(node.getLeft());
		Node right = findMax(node.getRight());

		if (left.getData() > res.getData()) {
			res = left;
		}

		if (right.getData() > res.getData()) {
			res = right;
		}

		return res;
	}

	public void delete(int data) {
		delete(root, data);
	}

	/**
	 * Method is to delete the node form BST, has cases as 1. if node has no
	 * children directly delete the node. 2. if node has one child then make that
	 * node as parent. 3. if node has two children then take the max element from
	 * left sub tree and place at place of node.
	 * 
	 * @param node
	 * @param data
	 * @return
	 */
	public Node delete(Node node, int data) {
		Node temp;
		if (node == null) {
			System.out.println("Element not there in tree");
		} else if (data < node.getData()) {
			node.left = delete(node.getLeft(), data);
		} else if (data > node.getData()) {
			node.right = delete(node.getRight(), data);
		} else {
			// found the element.

			// Node to delete has 2 children.
			if (node.getLeft() != null && node.getRight() != null) {
				/* replace the largest element in the left subtree. */
				temp = findMax(node.getLeft());
				node.setData(temp.getData());
				node.left = delete(node.getLeft(), data);
			} else {
				// One child
				temp = node;
				// if only right child
				if (node.getLeft() == null) {
					node = node.getRight();
				}

				// if only left child.
				if (node.getRight() == null) {
					node = node.getLeft();
				}

				// else
				temp = null;
			}
		}

		return node;
	}

	/**
	 * Method to find LCA(Least common ancestor) between two nodes.
	 * 
	 * @param node
	 * @param alpha
	 * @param beta
	 * @return
	 */
	public Node findLCA(Node node, Node alpha, Node beta) {
		while (true) {
			// Check if value in between alpha and beta.
			if (node.getData() > alpha.getData() && node.getData() < beta.getData()
					|| node.getData() < alpha.getData() && node.getData() > beta.getData()) {
				return node;
			}

			// if not then move acc to left/right tree.
			if (alpha.getData() < node.getData()) {
				node = node.getLeft();
			} else {
				node = node.getRight();
			}
		}
	}
	/* Function for inorder traversal */
	public void inorder() {
		inorder(root);
	}

	private void inorder(Node r) {
		if (r != null) {
			inorder(r.getLeft());
			System.out.print(r.getData() + " ");
			inorder(r.getRight());
		}
	}

	/* Function for preorder traversal */
	public void preorder() {
		preorder(root);
	}

	private void preorder(Node r) {
		if (r != null) {
			System.out.print(r.getData() + " ");
			preorder(r.getLeft());
			preorder(r.getRight());
		}
	}

	/* Function for postorder traversal */
	public void postorder() {
		postorder(root);
	}

	private void postorder(Node r) {
		if (r != null) {
			postorder(r.getLeft());
			postorder(r.getRight());
			System.out.print(r.getData() + " ");
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/* Creating object of BST */
		BinarySearchTree bst = new BinarySearchTree();
		System.out.println("Binary Search Tree Test\n");
		char ch;
		/* Perform tree operations */
		do {
			System.out.println("\nBinary Search Tree Operations\n");
			System.out.println("1. insert ");
			System.out.println("2. delete");
			System.out.println("3. search");
			System.out.println("4. count nodes");
			System.out.println("5. check empty");

			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter integer element to insert");
				bst.insert(scan.nextInt());
				break;
			case 2:
				System.out.println("Enter integer element to delete");
				bst.delete(scan.nextInt());
				break;
			case 3:
				System.out.println("Enter integer element to search");
				System.out.println("Search result : " + bst.search(scan.nextInt()));
				break;
			case 4:
				System.out.println("Nodes = " + bst.countNodes());
				break;
			case 5:
				System.out.println("Empty status = " + bst.isEmpty());
				break;
			default:
				System.out.println("Wrong Entry \n ");
				break;
			}
			/* Display tree */
			System.out.print("\nPost order : ");
			bst.postorder();
			System.out.print("\nPre order : ");
			bst.preorder();
			System.out.print("\nIn order : ");
			bst.inorder();

			System.out.println("\nDo you want to continue (Type y or n) \n");
			ch = scan.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');
	}

}
