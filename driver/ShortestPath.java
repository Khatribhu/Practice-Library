package driver;

import java.util.LinkedList;
import java.util.Queue;

class qentry {
	int v;
	int dist;
}

public class ShortestPath {

	 public static int getMinDiceThrows(int move[], int n) 
	 {
	     int visited[] = new int[n];
	     Queue<qentry> q = new LinkedList<>();
	     qentry qe = new qentry();
	     qe.v = 0;
	     qe.dist = 0;

	     // Mark the node 0 as visited and enqueue it.
	     visited[0] = 1;
	     q.add(qe);

	     // Do a BFS starting from vertex at index 0
	     while (!q.isEmpty()) 
	     {
	         qe = q.remove();
	         int v = qe.v;

	         // If front vertex is the destination 
	         // vertex, we are done
	         if (v == n - 1)
	             break;

	         // Otherwise dequeue the front vertex and 
	         // enqueue its adjacent vertices (or cell 
	         // numbers reachable through a dice throw)
	         for (int j = v + 1; j <= (v + 6) && j < n; ++j) 
	         {
	             // If this cell is already visited, then ignore
	             if (visited[j] == 0)
	             {
	                 // Otherwise calculate its distance and 
	                 // mark it as visited
	                 qentry a = new qentry();
	                 a.dist = (qe.dist + 1);
	                 visited[j] = 1;

	                 // Check if there a snake or ladder at 'j'
	                 // then tail of snake or top of ladder
	                 // become the adjacent of 'i'
	                 if (move[j] != -1)
	                     a.v = move[j];
	                 else
	                     a.v = j;
	                 q.add(a);
	             }
	         }
	     }

	     // We reach here when 'qe' has last vertex
	     // return the distance of vertex in 'qe'
	     return qe.dist;
	 }

	 
	public static int findShortestPath(String grid[][]) {
		int N = 100;
		int moves[] = new int[N];
		int i =0;
	    for (i = 0; i < N; i++)
	        moves[i] = -1;
	
	    for(i = 0; i < grid.length; i++) {
	    	//Ladder
	    	moves[Integer.parseInt(grid[i][2])] = Integer.parseInt(grid[i][3]);
	    	moves[Integer.parseInt(grid[i][1])] = Integer.parseInt(grid[i][0]);
	    }
	    
	    return getMinDiceThrows(moves, N);
	    
	}
}
