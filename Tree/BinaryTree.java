package first.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import javax.xml.stream.events.NotationDeclaration;

import first.LinkedList.StackUsingLL;

class queue {
	
	Node[] arr;
	int front , rear;
	static int size;
	
	queue(int n) {
		size = n;
		arr = new Node[n];
		this.front = -1;
		this.rear = -1;
	}

	public int getFront() {
		return front;
	}

	public int getRear() {
		return rear;
	}

	public void setFront(int front) {
		this.front = front;
	}

	public void setRear(int rear) {
		this.rear = rear;
	}
	
	public void add(Node n) {
		if(rear < size)
		arr[++rear] = n;
	}
	
}
class Node {
	int data;
	Node left, right;

	Node(int N) {
		this.data = N;
		left = right = null;
	}
	
	public int getData() {
		return data;
	}

	public Node getLeft() {
		return left;
	}

	public Node getRight() {
		return right;
	}

	public void setData(int data) {
		this.data = data;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public void setRight(Node right) {
		this.right = right;
	}

}

public class BinaryTree {

	static Node root;

	public BinaryTree() {
		root = null;
	}
	
	public boolean isEmpty() {
		return this.root == null ? true: false;
	}
	
	public void insert(int n) {
		root = insert(root, n);
	}
	
	public Node insert(Node node, int val) {
		
		//when root is null means no tree.
		if(node == null) {
			node = new Node(val);
		}else {
			//add to the right subtreee.
			if(node.right == null) {
				node.right = insert(node.right, val);
			}else {
				//adds to the left sub tree.
				node.left = insert(node.left, val);
			}
		}
		
		return node;
	}
	
	public int countNodes() {
		return countNodes(root);
	}
	
	/**
	 * Method to count the nodes in a tree.
	 * first checks the if first node is null then count is 0.
	 * else checks the left and right subtree.
	 * @param node
	 * @return
	 */
	public int countNodes(Node node) {
		if(node == null) {
			return 0;
		}else {
			int l = 1;
			l += countNodes(node.getLeft());
			l += countNodes(node.getRight());
			return l;
		}
	}
	
	
	public boolean search(int val) {
		return search(root, val);
	}
	
	/**
	 * Method to search the element in whole tree,reursively.
	 * @param node
	 * @param val
	 * @return
	 */
	public boolean search(Node node, int val) {

		//Check the current node value.
		if(node.getData() == val) {
			return true;
		}
		//traverse thorugh the left subtree.
		if(node.getLeft() != null) {
			if(search(node.getLeft(), val)) {
				return true;
			}
		}
		
		//traverse through the right subtree.
		if(node.getRight() != null) {
			if(search(node.getRight(), val)) {
				return true;
			}
		}
		
		//Return false if not found in left/right subree.
		return false;
	}
	
	/**
	 * Method to traverse the tree in preOrder.
	 * 
	 * @param node
	 */
	public void preOrder(Node node) {
		if(node != null) {
			//printing the data.
			System.out.print(node.getData() + " ");
			//traversing the left subtree.
			preOrder(node.getLeft());
			//traversting the right subtree.
			preOrder(node.getRight());
		}
	}

	/**
	 * Traverse the tree in postOrder.
	 * 
	 * @param node
	 */
	public void postOrder(Node node) {
		if (node != null) {
			postOrder(node.getLeft());
			postOrder(node.getRight());
			System.out.print(node.getData() + " ");
		}
	}
	
	/**
	 * Method to traverse in inorder.
	 * 
	 * @param node
	 */
	public void inOrder(Node node) {
		if (node != null) {
			inOrder(node.getLeft());
			System.out.print(node.getData() + " ");
			inOrder(node.getRight());
		}
	}
	
	
	/**
	 * Method to print the inorder traversal of the tree without using recursion.
	 * @param node
	 */
	public void inOrderWithoutRecur(Node node) {
		Stack<Node> stack = new Stack<>();
		while(true) {
			
			//print the left subtree.
			while(node != null) {
				//reaching to the left most element of the tree.
				stack.push(node);
				node = node.getLeft();
			}

			if(stack.isEmpty()) {
				break;
			}
			
			node = stack.pop();
			
			//printing the left most node.
			System.out.print(stack.pop().getData() + " ");
			
			node = node.getRight();
			
		}
	}
	
	/**
	 * Non recursive method to traverse the tree in preOrder traversal.
	 * @param node
	 */
	public void preOrderNonRecur(Node node) {
		Stack<Node> stack = new Stack<>();
		while(true) {
			while(node != null) {
				//process current node.
				System.out.print(node.getData() +" ");
				stack.push(node);
				node = node.getLeft();
			}
			
			if(stack.isEmpty()) {
				break;
			}
			
			node = stack.pop();
			
			//Indication end of the left tree, now moving towards right.
			node = node.getRight();
		}
		
 	}
	
	public void postOrderNonRecur(Node node) {
		Stack<Node> stack = new Stack<>();
		Node node2;
		Node node3;
		while(true) {
			
			//reaching at the left mode part of tree.
			while(node != null) {
				stack.push(node);
				node = node.getLeft();
			}
			
			//keeping aside the last element of the 
			node2 = stack.pop();
			node = stack.pop();
			node3 = node.getRight();
			
			System.out.println(node2.getData());
			System.out.println(node3.getData());
			System.out.println(node.getData());
			
			node = stack.pop();
		}
	}
	
	
	int ceil(Node root, int input) {
		// Base case
		if (root == null) {
			return -1;
		}

		// when element has equal value.
		if (root.data == input) {
			return root.data;
		}

		// when less than input, henace need to parse right subtree.
		if (root.data < input) {
			return ceil(root.right, input);
		}

		// when input just less than root
		// then find a ceil value and check which suits better (ceil or root.node)
		int ceil = ceil(root.left, input);
		return (ceil >= input) ? ceil : root.data;
	}

	/**
	 * Method to print the level order traversal.
	 * @param node
	 * @return
	 */
	public void levelOrderTraversal(Node node) {
		
		ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
		ArrayList<Integer> nodeValues = new ArrayList<>();
		List<Node> next = new LinkedList<>();
		List<Node> current = new LinkedList<>();
		
		int i = 0;
		current.add(node);
		
		while(!current.isEmpty()) {
			node = current.remove(i);
			
			//add left children to the list.
			if(node.getLeft()  != null) {
				next.add(node.getLeft());
			}
			
			//add right children to the list.
			if(node.getRight() != null) {
				next.add(node.getRight());
			}
			
			//storing the values.
			nodeValues.add(node.getData());
			
			if(current.isEmpty()) {
				current = next;
				next = new LinkedList<>();
				ret.add(nodeValues);
				nodeValues = new ArrayList<>();
			}
		}
		
		for(int j = ret.size()-1; j >= 0; j--) {
			ArrayList<Integer> arr = ret.get(j);
			for(Integer in : arr) {
				System.out.print(in+" ");
			}
		}
	}
	
	/**
	 * Method to find max element in the tree, recursively.
	 * @param node
	 * @return
	 */
	public int findMax(Node node) {
		int left, right, max, node_val;
		if(node == null) {
			return -1;
		}

		node_val = node.getData();
		
		left = findMax(node.getLeft());
		right = findMax(node.getRight());
		
		max = (left > right)? left:right;
		
		if(node_val > max) {
			max = node_val;
		}
		
		return max;
	}
	
	/**
	 * Find max element non-recursively.
	 * @param node
	 * @return
	 */
	public int findMaxNonRecur(Node node) {
		Stack<Node> stk = new Stack<>();
		int max = Integer.MIN_VALUE;
		while(true) {
			if(node == null) {
				break;
			}
			
			while(node != null) {
				stk.push(node);
				node = node.left;
			}
			
			node = stk.pop();
			
			if(null != node && max < node.getData()) {
				max = node.getData();
			}
			
			node = node.right;
		}
		
		return max;
	}
	
	/**
	 * method to count the nodes in tree.
	 * @return
	 */
	public int findSize(Node node) {
		if(node == null) {
			return 0;
		}else {
			return (findSize(node.getLeft())+1+findSize(node.getRight()));
		}
	}
	
	/**
	 * Method to find the height of the tree.
	 * @param node
	 * @return
	 */
	public int heightOfTree(Node node) {
		int left, right, height = 1;
		if(node == null) {
			return 0;
		}else {
			left = heightOfTree(node.getLeft());
			right = heightOfTree(node.getRight());
			if(left > right) {
				height += left;
			}else {
				height += right;
			}
			return height;
		}
	}
	
	/**
	 * Method to print path from root to leaf in a tree given.
	 * @param node
	 * @param path
	 * @param pathLen
	 */
	public void printPathRecur(Node node, int path[], int pathLen) {
		//boundry condition.
		if(node == null) {
			return; 
		}
		
		// array to store path for each leaf node.
		path[pathLen] = node.getData();
		pathLen++;
		
		//if node is leaf then print whole path.
		if(node.getLeft() == null && node.getRight() == null) {
			printArray(path, pathLen);
		}else {
			//traversing left and then right subtree.
			printPathRecur(node.getLeft(), path, pathLen);
			printPathRecur(node.getRight(), path, pathLen);
		}
	}
	
	/**
	 * Method to print array
	 * @param arr
	 * @param len
	 */
	public void printArray(int arr[], int len) {
		for(int i = 0; i < len; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	/**
	 * Method to make mirror image of the tree.
	 * @param node
	 * @return
	 */
	public Node makeMirrorTree(Node node) {
		Node temp;
		if(node != null) {
			makeMirrorTree(node.getLeft());
			makeMirrorTree(node.getRight());
			
			temp = node.getLeft();
			node.setLeft(node.getRight());
			node.setRight(temp);
		}
		return node;
	}
	public static void main(String[] args) {
		
		BinaryTree bt = new BinaryTree();
		Scanner scan = new Scanner(System.in);
		System.out.println("Binary Tree Test\n");
		char ch;
		do {
			System.out.println("\nBinary Tree Operations\n");
			System.out.println("1. insert ");
			System.out.println("2. search");
			System.out.println("3. count nodes");
			System.out.println("4. check empty");
			System.out.println("5. Find Max element");
			System.out.println("6. Finf Size of Tree");

			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter integer element to insert");
				bt.insert(scan.nextInt());
				break;
			case 2:
				System.out.println("Enter integer element to search");
				System.out.println("Search result : " + bt.search(scan.nextInt()));
				break;
			case 3:
				System.out.println("Nodes = " + bt.countNodes());
				break;
			case 4:
				System.out.println("Empty status = " + bt.isEmpty());
				break;
			case 5:
			//	System.out.println("Maximum element is = "+bt.findMax(root));
				System.out.println("Maximum element is = "+bt.findMaxNonRecur(root));
				break;
			case 6: 
				System.out.println("Size of the tree is = "+bt.findSize(root));
			default:
				System.out.println("Wrong Entry \n ");
				break;
			}
			/* Display tree */
			System.out.print("\nPost order : ");
			bt.postOrder(root);
			System.out.print("\nPre order : ");
			//bt.preOrder(root);
			bt.preOrderNonRecur(root);
			System.out.print("\nIn order : ");
			bt.inOrder(root);
			System.out.print("\nLevel Order : ");
			bt.levelOrderTraversal(root);
			System.out.print("\nPrint path from root to given node : ");
			int[] arr = new int[50];
			int pathLen = 0;
			bt.printPathRecur(bt.root, arr, pathLen);

			System.out.println("\n\nDo you want to continue (Type y or n) \n");
			ch = scan.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');

	}
}
