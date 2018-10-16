package com.company;

import java.util.LinkedList;

public class Main {
    static final int V = 6;

    boolean bfs(int residualGraph[][] , int source , int sink , int parent[]){

        boolean[] visited = new boolean[V];
        visited[source] = true;
        parent[source] = -1;

        LinkedList<Integer> queue = new LinkedList<Integer>();

        queue.add(source);

        while(queue.size() != 0){
            int u = queue.poll();
            for(int i = 0 ; i < V ; i++){
                if(visited[i]==false && residualGraph[u][i] > 0) {
                    queue.add(i);
                    parent[i] = u;
                    visited[i] = true;
                }
            }
        }

        return visited[sink] == true;
    }

    int FordFulkerson(int[][] graph , int source , int sink){
        int[][] residualGraph = new int[V][V];
        for(int i = 0 ; i < V ; i++)
            for(int j = 0 ; j < V ; j++)
                residualGraph[i][j] = graph[i][j];
        int[] parent = new int[V];

        int MaxFlow = 0;

        while(bfs(residualGraph , source , sink , parent)){
            int min = Integer.MAX_VALUE;
            int u;
            for (int v=sink; v!=source; v=parent[v])
            {
                u = parent[v];
                min = Math.min(min, residualGraph[u][v]);
            }

            // update residual capacities of the edges and
            // reverse edges along the path
            for (int v=sink; v != source; v=parent[v])
            {
                u = parent[v];
                residualGraph[u][v] -= min;
                residualGraph[v][u] += min;
            }

            // Add path flow to overall flow
            MaxFlow += min;
        }

        // Return the overall flow
        return MaxFlow;
    }

    public static void main(String[] args) {
	// write your code here
        int[][] graph = new int[][]{ {0, 16, 13, 0, 0, 0},
                {0, 0, 10, 12, 0, 0},
                {0, 4, 0, 0, 14, 0},
                {0, 0, 9, 0, 0, 20},
                {0, 0, 0, 7, 0, 4},
                {0, 0, 0, 0, 0, 0}
        };
        Main m = new Main();
        System.out.println("Max Flow in the graph form 0 to 5 is " + m.FordFulkerson(graph , 0 , 5));

    }
}
