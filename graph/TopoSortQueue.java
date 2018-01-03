package first.graph;

/* ====================================== */
/* Copyright (c) 2017 BK Corporation. */
/*          All rights reserved.          */
/* ====================================== */
//A Java program to print topological sorting of a graph
//using indegrees
import java.util.*;

//Class to represent a graph
class Graphhh {
	int V;// No. of vertices

	// An Array of List which contains
	// references to the Adjacency List of
	// each vertex
	List<Integer> adj[];

	public Graphhh(int V)// Constructor
	{
		this.V = V;
		adj = new ArrayList[V];
		for (int i = 0; i < V; i++)
			adj[i] = new ArrayList<Integer>();
	}

	// function to add an edge to graph
	public void addEdge(int u, int v) {
		adj[u].add(v);
	}

	/**
	 * Method to print topo logical sorting for the graph.
	 * 
	 */
	public void topologicalSort() {
		// array to store in-degree.
		int indegree[] = new int[V];

		//traverse through all the nodes to mark indegree.
		//O(V+E)
		for (int i = 0; i < V; i++) {
			ArrayList<Integer> temp = (ArrayList<Integer>) adj[i];
			for (int node : temp) {
				indegree[node]++;
			}
		}

		//Enque all the vertices with indegree 0.
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < V; i++) {
			if (indegree[i] == 0)
				q.add(i);
		}

		// Initialize count of visited vertices
		int cnt = 0;

		//list to store the output.
		List<Integer> topOrder = new ArrayList<Integer>();
		while (!q.isEmpty()) {
			// perform dequeue
			// and add it to topological order
			int u = q.poll();
			topOrder.add(u);

			// Iterate through all its neighbouring nodes
			// of dequeued node u and decrease their in-degree
			// by 1
			for (int node : adj[u]) {
				// If in-degree becomes zero, add it to queue
				if (--indegree[node] == 0)
					q.add(node);
			}
			cnt++;
		}

		// Check if there was a cycle
		if (cnt != V) {
			System.out.println("There exists a cycle in the graph");
			return;
		}

		// Print topological order
		for (int i : topOrder) {
			System.out.print(i + " ");
		}
	}
}

// Driver program to test above functions
public class TopoSortQueue {
	public static void main(String args[]) {
		// Create a graph given in the above diagram
		Graphhh g = new Graphhh(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		System.out.println("Following is a Topological Sort");
		g.topologicalSort();

	}
}
