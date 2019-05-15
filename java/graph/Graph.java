package graph;

import java.util.LinkedList;
import java.util.List;

public class Graph {

    private final int v;

    private final List<Integer>[] adj;

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (List<Integer> edges : adj) {
            edges = new LinkedList<>();
        }
    }

    public void add(int s, int t) {
        adj[s].add(t);
    }

    public void topologySortKahn() {
        int[] indegrees = new int[v];
        for (int i = 0; i < v; i++) {
            List<Integer> edges = adj[i];
            for (int t : edges) {
                indegrees[t]++;
            }
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int currV = queue.poll();
            System.out.print(currV + " -> ");
            for (int nextV : adj[currV]) {
                if (--indegrees[nextV] == 0) {
                    queue.add(nextV);
                }
            }
        }
    }

    public void topologySortDFS() {

    }
}
