package first.graph;

import java.util.LinkedList;

/* ====================================== */
/* Copyright (c) 2017 BK Corporation. */
/*          All rights reserved.          */
/* ====================================== */
public class DetectCycleGraph {

	private Graph gh;

	DetectCycleGraph(int in) {
		gh = new Graph(in);

	}

	public void findCycle(Graph gh, int s) {
		boolean[] visited = new boolean[gh.getV()];
		LinkedList<Integer> processed = new LinkedList<>();
		DFSUtil(visited, s, processed);
	}

	public void DFSUtil(boolean[] visited, int val, LinkedList<Integer>processed) {
		visited[val] = true;

		LinkedList<Integer> nodes = this.gh.getAdj()[val];

		System.out.print(val+" ");
		processed.add(val);

		for (Integer in : nodes) {
			if(processed.contains(in)) {
				System.out.println("\nGraph Contains a Loop at the vertex : "+in);
				System.exit(0);
			}
			if (!visited[in]) {
				DFSUtil(visited, in, processed);
			}
		}
	}

	public static void main(String[] args) {
		Graph gh = new Graph(4);
		gh.addEdge(0, 1);
		gh.addEdge(0, 2);
		gh.addEdge(1, 2);
		gh.addEdge(2, 0);
		gh.addEdge(2, 3);
		gh.addEdge(3, 3);
		
		DetectCycleGraph dh = new DetectCycleGraph(4);
		dh.gh = gh;
		dh.findCycle(gh, 0);
		
		
	}
}
