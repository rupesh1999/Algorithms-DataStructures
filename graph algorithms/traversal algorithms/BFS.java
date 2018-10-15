package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class BFS {
    public int V;
    int[] parent;
    int[] dist;

    private LinkedList<Integer> adj[];
    BFS(int v){
        parent = new int[v];

        dist = new int[v];
        V = v;
        adj = new LinkedList[v];
        for(int i=0 ; i<v ; i++){
            adj[i] = new LinkedList();
        }
    }
    void addEdge(int v , int w){
        adj[v].add(w);
    }

    public void bfs(int s){
        boolean[] visited = new boolean[V];

        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[s] = true;
        dist[s] = 0;

        queue.add(s);

        while(queue.size() != 0){

            s = queue.poll();
            System.out.print(s+" ");
            Iterator<Integer> i = adj[s].listIterator();

                while (i.hasNext()) {
                    int n = i.next();
                    if (!visited[n]) {
                        visited[n] = true;
                        dist[n] = dist[s] + 1;
                        parent[n] = s;
                        queue.add(n);
                    }
                }
            }

        System.out.println("\n" + dist[3]);
    }

    private void printPath(int v , int w){
        while(v!=w){
            System.out.print(w + " <- ");
            w = parent[w];
        }
        System.out.print(v);
    }
    public static void main(String[] args) {
        BFS g = new BFS(4);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(3,0);
        g.addEdge(0,2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.bfs(0);
        g.printPath(0 , 3);

    }

}