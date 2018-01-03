package first.Tree;

import java.util.HashMap;

/* ====================================== */
/* Copyright (c) 2017 BK Corporation. */
/*          All rights reserved.          */
/* ====================================== */

class TreeNode {
	  
    // data members
    private int key;
    private TreeNode left;
    private TreeNode right;
  
    // Accessor methods
    public int key()        { return key; }
    public TreeNode left()  { return left; }
    public TreeNode right() { return right; }
  
    // Constructor
    public TreeNode(int key)
   { this.key = key; left = null; right = null; }
  
    // Methods to set left and right subtrees
    public void setLeft(TreeNode left)   { this.left = left; }
    public void setRight(TreeNode right) { this.right = right; }
}

class Tree {
	private TreeNode root;
	
	public Tree() {
		root = null;
	}
	
	public Tree(TreeNode node) {
		root = node;
	}
	
	public void VerticalSumMain() {
		VerticalSumMain(this.root);
	}
	
	private void VerticalSumMain(TreeNode node) {
		if(node == null) {
			return;
		}
		
		HashMap<Integer, Integer> hs = new HashMap<>();
		
		VerticalSumUtil(node, 0, hs);
		
		if(hs != null) {
			System.out.println(hs.entrySet());
		}
	}
	
	private void VerticalSumUtil(TreeNode node, int hd, HashMap<Integer,Integer> hs) {
		if(node == null) {
			return;
		}
		
		VerticalSumUtil(node.left(), hd-1, hs);
		
		int sum = hs.get(hd) == null ? 0 : hs.get(hd);
		hs.put(hd, sum+ node.key());
		
		VerticalSumUtil(node.right(), hd+1, hs);
		
	}
}

public class TreeVerticalSum {
		  
	    public static void main(String[] args) {
	        /* Create following Binary Tree
	              1
	            /    \
	          2        3
	         / \      / \
	        4   5    6   7
	  
	        */
	        TreeNode root = new TreeNode(1);
	        root.setLeft(new TreeNode(2));
	        root.setRight(new TreeNode(3));
	        root.left().setLeft(new TreeNode(4));
	        root.left().setRight(new TreeNode(5));
	        root.right().setLeft(new TreeNode(6));
	        root.right().setRight(new TreeNode(7));
	        Tree t = new Tree(root);
	  
	        System.out.println("Following are the values of" + 
	                           " vertical sums with the positions" +
	                        " of the columns with respect to root ");
	        t.VerticalSumMain();
	    }
}