// Bellman Ford (CLRS algo) https://web.stanford.edu/class/archive/cs/cs161/cs161.1168/lecture14.pdf

import java.util.Vector;
import java.util.Iterator;
import java.util.Arrays;

class Main {
    static int findMinPath(int graph[][], int V, int E,
                int src, int dest)
    {
    // Init D as infinity for all nodes
    int d[] = new int[V];
    for (int i = 0; i < V; i++)
        d[i] = Integer.MAX_VALUE;

    // D for Source init as 0
    d[src] = 0;


    // DP Loop (n^3 ,or rather V.E)
    for (int i = 0; i < V - 1; i++)
    {
        for (int j = 0; j < E; j++)
        {
            if (d[graph[j][0]] + graph[j][2] < d[graph[j][1]])
                d[graph[j][1]] = d[graph[j][0]] + graph[j][2];
        }
    }

    // B.F. kas basic funda ye hota tha ki once you have performed the DP for V-1 iterations you should reach the final o/p if there is a neg weight cycle on one further iteration the length of cycle will reduce.
    for (int i = 0; i < E; i++)
    {
        int x = graph[i][0];
        int y = graph[i][1];
        int weight = graph[i][2];
        if (d[x] != Integer.MAX_VALUE && d[x] + weight < d[y])
            System.out.println("Negative weight cycle detected");
    }
     return d[dest];

    }


    public static void main(String[] args) {
        int V = 5;
        int E = 8; //test case from gfg.

        int graph[][] = { { 0, 1, -1 }, { 0, 2, 4 },
                    { 1, 2, 3 }, { 1, 3, 2 },
                    { 1, 4, 2 }, { 3, 2, 5 },
                    { 3, 1, 1 }, { 4, 3, -3 } };


        int graph2[][] = { { 0, 1, -1 }, { 0, 2, 4 }, // test case constructed to check if negative weight cycle is detected
                    { 1, 2, 3 }, { 1, 3, 2 },
                    { 1, 4, 2 }, { 3, 2, 5 },
                    { 3, 1, -3 }, { 4, 3, -3 } };


        //int pathLen = findMinPath(graph, V, E, 0, 0);
        //int pathLen = findMinPath(graph, V, E, 0, 1);
        //int pathLen = findMinPath(graph, V, E, 0, 2);
        //int pathLen = findMinPath(graph, V, E, 0, 3);
        //int pathLen = findMinPath(graph, V, E, 0, 4);

        int pathLen = findMinPath(graph2, V, E, 0, 3); //assuming dest as 3; Also the correct way to implement was to make a global DP table (and in C++/Python I would have probably done that, but this code works for single destinations and I do not want to trifle with it too much, lest it breaks.)
        System.out.println(pathLen);
    }
}
