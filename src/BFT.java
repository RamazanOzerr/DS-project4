// Breadth-First Traverse
import java.util.*;

public class BFT {

    private int n; // total number of nodes in the graph
    private LinkedList<Integer> adj[];  // adjacency list
    private Queue<Integer> queue;

    public BFT(int n){
        this.n = n;
        adj = new LinkedList[n];
        for(int i=0; i<n; i++){
            adj[i] = new LinkedList<>();
        }queue = new LinkedList<>();
    }

    public void insertEdge(int v, int w){
        adj[v].add(w);
    }

    public void BFT(int v){

        Boolean[] visited = new Boolean[n];
        // set all the vertices as unvisited
        for(int i = 0; i<n; i++){
            visited[i] = false;
        }

        // we started from the vertix given as a parameter
        int index = 0;
        visited[v] = true;
        queue.add(v);  // ilk node u ekledik
        while (queue.size() != 0){
            v = queue.poll(); // delete the element front and assign it to v
            System.out.print(v+" ");
            for(int j=0; j<adj[v].size(); j++){
                index = adj[v].get(j);
                if(!visited[index]){
                    visited[index] = true;
                    queue.add(index);
                }
            }
        }


    }

    // test for Breadth-First Traverse in graphs
    public static void main(String[] args) {

        BFT bft = new BFT(6);
        bft.insertEdge(0, 1);
        bft.insertEdge(0, 3);
        bft.insertEdge(0, 4);
        bft.insertEdge(4, 5);
        bft.insertEdge(3, 5);
        bft.insertEdge(1, 2);
        bft.insertEdge(1, 0);
        bft.insertEdge(2, 1);
        bft.insertEdge(4, 1);
        bft.insertEdge(3, 1);
        bft.insertEdge(5, 4);
        bft.insertEdge(5, 3);

        for(int i = 0; i< bft.n; i++){
            System.out.print(i+". vertex: ");
            bft.BFT(i);
            System.out.println();
        }
    }
}
