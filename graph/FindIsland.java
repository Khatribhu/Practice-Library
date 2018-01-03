package first.graph;

public class FindIsland {
	static final int ROW = 5, COL = 5;

	/**
	 * method checks the values passed are proper or not.
	 * @param arr
	 * @param i
	 * @param j
	 * @param visited
	 * @return
	 */
	public boolean isSafe(int[][] arr, int i, int j, boolean[][] visited) {
		return (i >= 0) && (i < ROW) && (j >= 0) && (j < COL) && (!visited[i][j]) && (arr[i][j] == 1);
	}

	/**
	 * DFS for graph.
	 * @param arr
	 * @param i
	 * @param j
	 * @param visited
	 */
	public void DFS(int[][] arr, int i, int j, boolean[][] visited) {
		int rowNbr[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int colNbr[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

		// marking node as visited
		visited[i][j] = true;

		//checking all the nodes in the 8 directions.
		for (int k = 0; k < 8; k++) {
			if (isSafe(arr, i + rowNbr[k], j + colNbr[k], visited)) {
				DFS(arr, i + rowNbr[k], j + colNbr[k], visited);
			}
		}
	}

	/**
	 * Counting island for the array.
	 * @param arr
	 * @return
	 */
	public int countIsland(int[][] arr) {
		boolean visited[][] = new boolean[ROW][COL];
		int count = 0;
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				if (arr[i][j] == 1 && !visited[i][j]) {
					DFS(arr, i, j, visited);
					count++;
				}
			}
		}
		return count;
	}

	/**
	 * Driver
	 * @param args
	 */
	public static void main(String[] args) {
		int M[][] = new int[][] { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 0, 1 } };
		FindIsland FI = new FindIsland();
		int result = FI.countIsland(M);
		System.out.println(result);
	}
}
