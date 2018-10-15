package com.company;

public class Main {
    static final int V = 9;

    int minDistance(int dist[] , boolean sptset[]){
        int min = Integer.MAX_VALUE , min_index = -1;
        for(int i=0 ; i < V ; i++){
            if((sptset[i] == false)&&dist[i]<=min){
                min = dist[i];
                min_index = i;
            }
        }
        return min_index;
    }

    void printSolution(int dist[], int n)
    {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i+" \t "+dist[i]);
    }

    void printPath(int[] parent , int source , int target){
        int main = target;
        System.out.print(main + " <-");
        while(source!=target){
            System.out.print(parent[target] + " <- ");
            target = parent[target];
        }

    }

    void dijkstra(int graph[][] , int source){
        int[] dist = new int[V];
        int[] parent = new int[V];

        boolean[] sptset = new boolean[V];

        for (int i = 0; i < V; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            sptset[i] = false;
        }

        dist[source]  = 0;

        for(int count = 0 ; count< V-1 ; count++){
            int u = minDistance(dist , sptset);

            sptset[u] = true;

            for(int v=0 ; v<V ; v++){
                if(!sptset[v] && graph[u][v]!=0 && dist[u]!= Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]){
                    dist[v] = dist[u] + graph[u][v];
                    parent[v] = u;
                }
            }
        }

        printSolution(dist, V);
        printPath(parent , 0 , 5);



    }

    public static void main(String[] args) {
	// write your code here
        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        Main t = new Main();
        t.dijkstra(graph, 0 );
    }
}
