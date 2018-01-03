package first.Tree;
/* ====================================== */
/* Copyright (c) 2017 BK Corporation. */
/*          All rights reserved.          */
/* ====================================== */
public class FindKthSmallest {
	static Node root;
	static int i = 0;
	
	FindKthSmallest() {
		root = null;
	}
	
	public Node insert(Node node, int data) {
		if(node == null) {
			node = new Node(data);
		}else {
			if(node.getData() > data ) {
				node.left = insert(node.getLeft(), data);
			}else {
				node.right = insert(node.getRight(), data);
			}
		}
		return node;
	}
	
	public void insert(int data) {
		root = insert(root, data);
	}
	
	public void inorder(int k) {
		int arr[] = new int[30];
		inorder(root, arr);
		System.out.println(arr[k-1]);
	}
	
	public void inorder(Node node, int[] arr) {
		if (node != null) {
			inorder(node.left, arr);
			arr[i++] = node.getData();
			inorder(node.right, arr);
		}
	}
	
	public void findKthMin(int k) {
		inorder(k);
	}
	
	
	public static void main(String[] args) {
		FindKthSmallest shortBST = new FindKthSmallest();
		
		shortBST.insert(20);
		shortBST.insert(10);
		shortBST.insert(5);
		shortBST.insert(15);
		shortBST.insert(30);
		shortBST.insert(25);
		shortBST.insert(35);
		
		shortBST.findKthMin(2);
	}
}
