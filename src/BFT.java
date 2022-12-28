// Breadth-First Traverse

import java.util.*;

public class BFT {

    private int n; // number of vertices
    Boolean[] visited;
    int[][] adjList;

    public BFT(int n){
        this.n = n;
    }


    public void bft(int s){

        visited = new Boolean[n];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0){
            s = queue.poll();
            System.out.println(s+" ");

            for(int i : queue){

                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }

    }


    public static void main(String[] args) {

        BFT bft = new BFT(4);
        int[][] graphList = new int[][]{{ 0, 1}, { 0, 2}, { 1, 2}, { 2, 0}};

        bft.bft(2);
    }

}
