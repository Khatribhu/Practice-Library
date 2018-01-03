package coding;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
	int[] distance;
	Set<Integer> processed;
	Set<Integer> unProcessed;
	int nodes;
	int adjMatrix[][];

	Solution(int nodes) {
		this.nodes = nodes;
		distance = new int[nodes + 1];
		processed = new HashSet<>();
		unProcessed = new HashSet<>();
		adjMatrix = new int[nodes + 1][nodes + 1];
	}

	public void algo(int pAdjMatrix[][], int firstNode) {

		// in_process node
		int currentNode;

		for(int i = 1; i <= nodes; i++) {
			this.distance[i] = Integer.MAX_VALUE;
		}
		// Populate Adj matrix
		for (int i = 1; i <= nodes; i++) {
			for (int j = 1; j <= nodes; j++) {
				this.adjMatrix[i][j] = pAdjMatrix[i][j];
			}
		}

		// adding the source node to unprocessed list
		unProcessed.add(firstNode);
		distance[firstNode] = 0;

		// traversing through the list.
		while (!unProcessed.isEmpty()) {
			// finding out the shortest distance node in un-process nodes.
			currentNode = checkShortestNode();

			// remove that node from un-process nodes.
			unProcessed.remove(currentNode);
			processed.add(currentNode);

			// Checking adjacent nodes which to process further.
			checkAdjacentNodes(currentNode);
		}
	}

	/**
	 * Method to find out the shortest distance node in unprocess list.
	 * 
	 * @return
	 */
	public int checkShortestNode() {
		int min_distance;
		int node = 0;

		for (Integer in : this.unProcessed) {
			node = in;
			min_distance = distance[in];
			// traversing through all to nodes to find min distance with nodes in unprocess
			// list.
			for (int i = 1; i <= distance.length; i++) {
				if (unProcessed.contains(i)) {
					if (distance[i] <= min_distance) {
						min_distance = distance[i];
						node = i;
					}
				}
			}
		}

		return node;
	}

	/**
	 * 
	 * @param CurrentNode
	 */
	public void checkAdjacentNodes(int CurrentNode) {
		int distOne = -1;
		int distTwo = -1;
		int distThree = -1;

		for (int i = 1; i <= nodes; i++) {
			if (!processed.contains(i)) {
				if (adjMatrix[CurrentNode][i] != Integer.MAX_VALUE || adjMatrix[i][CurrentNode] != Integer.MAX_VALUE) {
					distOne = adjMatrix[CurrentNode][i];
					if(adjMatrix[CurrentNode][i] != Integer.MAX_VALUE) {
						distOne = adjMatrix[CurrentNode][i];
					}
					
					if(adjMatrix[i][CurrentNode] != Integer.MAX_VALUE) {
						distThree = adjMatrix[i][CurrentNode];
					}
					
					distOne = Math.min(distOne, distThree);
					distTwo = distance[CurrentNode] + distOne;
					if (distTwo < distance[i]) {
						distance[i] = distTwo;
					}
					unProcessed.add(i);
				}
			}
		}
	}

}

public class Driver {
	public static void main(String[] args) {
		int num_Of_nodes = 11, first = 0, last = 0;

		/*int adjacency_matrix[][] = { { 0, 0, 0, 0, 0 }, { 0, 0, 100, 30, 0 }, { 0, 100, 0, 20, 0 },
				{ 0, 30, 20, 0, 20 }, { 0, 5, 0, 20, 0 } };
*/
		
		//Adjacency matrix for the graph.
		
		int adjacency_matrix[][] = {
				{0,0,0,0,0,0,0,0,0,0,0,-2},
				{0,0,4,3,2,0,0,0,0,0,0,0},//1
				{0,4,0,0,0,1,1,0,0,0,0,0},//2
				{0,3,0,0,0,0,1,0,0,0,0,0},//3
				{0,2,0,0,0,0,0,1,0,0,0,0},//4
				{0,0,1,0,0,0,0,0,1,0,0,0},//5
				{0,0,0,1,0,0,0,0,0,4,0,0},//6
				{0,0,0,0,1,0,0,0,0,0,1,0},//7
				{0,0,0,0,0,1,0,0,0,2,0,6},//8
				{0,0,0,0,0,0,4,0,2,0,1,5},//9
				{0,0,0,0,0,0,0,1,0,1,0,1},//10
				{0,-1,0,0,0,0,0,0,6,5,1,0}//11
		};
		
		
		for (int i = 1; i <= num_Of_nodes; i++) {
			for (int j = 1; j <= num_Of_nodes; j++) {
				if (i == j) {
					adjacency_matrix[i][j] = 0;
					continue;
				}
				if (adjacency_matrix[i][j] == 0) {
					adjacency_matrix[i][j] = Integer.MAX_VALUE;
				}
			}
		}

		first = 1;
		last = 11;

		Solution sol = new Solution(num_Of_nodes);
		sol.algo(adjacency_matrix, first);

		for (int i = 1; i <= sol.distance.length - 1; i++) {
			if (i == last)
				System.out.println(sol.distance[i]);
		}
	}
}
