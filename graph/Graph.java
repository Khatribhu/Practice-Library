package first.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
	// Number of vertex.
	private int v;

	// Adjacency list( array of linkedList ).
	private LinkedList<Integer> adj[];

	public int getV() {
		return v;
	}

	public LinkedList<Integer>[] getAdj() {
		return adj;
	}

	public void setV(int v) {
		this.v = v;
	}

	public void setAdj(LinkedList<Integer>[] adj) {
		this.adj = adj;
	}

	/**
	 * Constructor
	 * 
	 * @param v
	 */
	Graph(int v) {
		this.v = v;

		adj = new LinkedList[v];

		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	/**
	 * Method to add edge between two nodes.
	 * 
	 * @param v
	 * @param w
	 */
	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	/**
	 * Method implementing BFS.
	 * BFS
	 * 
	 * @param s
	 */
	void BFS(int s) {

		boolean visited[] = new boolean[v];

		// Queue is used to insert from one end and remove from another.
		LinkedList<Integer> queue = new LinkedList<>();

		// marking node as visited.
		visited[s] = true;

		// pushing current node to the queue.
		queue.push(s);

		// looping through all the element in the queue.
		while (queue.size() != 0) {

			// taking the first element from the queue.
			int p = queue.poll();

			// processing that element.
			System.out.print(p + " ");

			// taking all the adj nodes into the LinkedList.
			LinkedList<Integer> ll = adj[p];

			// looping all the nodes one by one.
			for (Integer n : ll) {
				// process only unvisited nodes.
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}

	/**
	 * DFS Util
	 * 
	 * @param n
	 * @param visited
	 */
	void DFSUtil(int n, boolean visited[]) {
		visited[n] = true;
		System.out.print(n + " ");

		LinkedList<Integer> ll = adj[n];
		for (Integer val : ll) {
			if (!visited[val]) {
				visited[val] = true;
				DFSUtil(val, visited);
			}
		}
	}

	/**
	 * DFS
	 * 
	 * @param s
	 */
	void DFS(int s) {

		boolean visited[] = new boolean[v];

		DFSUtil(s, visited);

	}

	/**
	 * 
	 * @param s
	 */
	public void BFSAlgo(int s) {
		boolean[] visited = new boolean[v];

		visited[s] = true;

		LinkedList<Integer> queue = new LinkedList<>();

		queue.add(s);

		while (queue.size() != 0) {
			int index = queue.poll();
			
			System.out.print(index + " ");
			
			LinkedList<Integer> ll = adj[index];

			for (Integer in : ll) {
				if (!visited[in]) {
					visited[in] = true;
					queue.add(in);
				}
			}

		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Graph g = new Graph(6);
/*
		gh.addEdge(0, 1);
		gh.addEdge(0, 2);
		gh.addEdge(1, 2);
		gh.addEdge(2, 0);
		gh.addEdge(2, 3);
		gh.addEdge(3, 3);
*/
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		System.out.println("Following is the BFS for the graph starting from vertex 2:");

		g.BFS(5);
		System.out.println();
		g.BFSAlgo(5);
		
		System.out.println("Deapth first search...");
		g.DFS(5);
		
	}
}
