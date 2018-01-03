package first.graph;

/* ====================================== */
/* Copyright (c) 2017 BK Corporation. */
/*          All rights reserved.          */
/* ====================================== */
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Dijkstra {
	private int distances[];
	private Set<Integer> settled;
	private Set<Integer> unsettled;
	private int number_of_nodes;
	private int adjacencyMatrix[][];

	/**
	 * Constructor
	 * @param number_of_nodes
	 */
	public Dijkstra(int number_of_nodes) {
		this.number_of_nodes = number_of_nodes;
		distances = new int[number_of_nodes + 1];
		settled = new HashSet<Integer>();
		unsettled = new HashSet<Integer>();
		adjacencyMatrix = new int[number_of_nodes + 1][number_of_nodes + 1];
	}

	/**
	 * Method to find min path.
	 * @param adjacency_matrix
	 * @param source
	 */
	public void dijkstra_algorithm(int adjacency_matrix[][], int source) {
		int evaluationNode;
		
		//Copying the adjacency matrix.
		for (int i = 1; i <= number_of_nodes; i++)
			for (int j = 1; j <= number_of_nodes; j++)
				adjacencyMatrix[i][j] = adjacency_matrix[i][j];

		//Initializing the distance for the nodes.
		for (int i = 1; i <= number_of_nodes; i++) {
			distances[i] = Integer.MAX_VALUE;
		}

		unsettled.add(source);
		distances[source] = 0;
		
		//while unsettled set is not empty.
		while (!unsettled.isEmpty()) {
			
			evaluationNode = getNodeWithMinimumDistanceFromUnsettled();
			unsettled.remove(evaluationNode);
			settled.add(evaluationNode);
			evaluateNeighbours(evaluationNode);
		}
	}

	/**
	 * Method to get the min distance node from unsettled nodes.
	 * Iterated through the unsettled nodes and
	 * @return
	 */
	private int getNodeWithMinimumDistanceFromUnsettled() {
		int min;
		int node = 0;

		Iterator<Integer> iterator = unsettled.iterator();
		node = iterator.next();
		min = distances[node];
		for (int i = 1; i <= distances.length; i++) {
			if (unsettled.contains(i)) {
				if (distances[i] <= min) {
					min = distances[i];
					node = i;
				}
			}
		}
		return node;
	}

	/**
	 * Method to evaluate the neighbour nodes of current nodes.
	 * It checks the distances in adjacency Matrix.
	 * if there is a path from evaluationNode to any other nodes that nodes gets added to the unsettled list.
	 * 
	 * @param evaluationNode
	 */
	private void evaluateNeighbours(int evaluationNode) {
		int edgeDistance = -1;
		int newDistance = -1;

		for (int destinationNode = 1; destinationNode <= number_of_nodes; destinationNode++) {
			if (!settled.contains(destinationNode)) {
				if (adjacencyMatrix[evaluationNode][destinationNode] != Integer.MAX_VALUE) {
					edgeDistance = adjacencyMatrix[evaluationNode][destinationNode];
					newDistance = distances[evaluationNode] + edgeDistance;
					if (newDistance < distances[destinationNode]) {
						distances[destinationNode] = newDistance;
					}
					unsettled.add(destinationNode);
				}
			}
		}
	}

	public static void main(String... arg) {
		int adjacency_matrix[][];
		int number_of_vertices;
		int source = 0, destination = 0;
		Scanner scan = new Scanner(System.in);
		try {
			System.out.println("Enter the number of vertices");
			number_of_vertices = scan.nextInt();
			adjacency_matrix = new int[number_of_vertices + 1][number_of_vertices + 1];

			System.out.println("Enter the Weighted Matrix for the graph");
			for (int i = 1; i <= number_of_vertices; i++) {
				for (int j = 1; j <= number_of_vertices; j++) {
					adjacency_matrix[i][j] = scan.nextInt();
					if (i == j) {
						adjacency_matrix[i][j] = 0;
						continue;
					}
					if (adjacency_matrix[i][j] == 0) {
						adjacency_matrix[i][j] = Integer.MAX_VALUE;
					}
				}
			}

			System.out.println("Enter the source ");
			source = scan.nextInt();

			System.out.println("Enter the destination ");
			destination = scan.nextInt();

			Dijkstra dijkstrasAlgorithm = new Dijkstra(number_of_vertices);
			dijkstrasAlgorithm.dijkstra_algorithm(adjacency_matrix, source);

			System.out.println("The Shorted Path from " + source + " to " + destination + " is: ");
			
			for (int i = 1; i <= dijkstrasAlgorithm.distances.length - 1; i++) {
				if (i == destination)
					System.out.println(source + " to " + i + " is " + dijkstrasAlgorithm.distances[i]);
			}
			
		} catch (InputMismatchException inputMismatch) {
			System.out.println("Wrong Input Format");
		}
		scan.close();
	}
}