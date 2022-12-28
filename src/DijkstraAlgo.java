import java.util.ArrayList;
import java.util.List;

public class DijkstraAlgo {

    public static int INFINITY = Integer.MAX_VALUE;

    public static void main(String args[])
    {

        int N = 5;  // number of vertices
        int distances[] = new int[N];

        List<String> nameList = new ArrayList<>();
        nameList.add("A");
        nameList.add("B");
        nameList.add("C");
        nameList.add("D");
        nameList.add("E");


        // int[][] cost	= new int[N][N];

        int[][] cost	= {
                { INFINITY,    5,    3, INFINITY,    2},
                { INFINITY, INFINITY,    2,    6, INFINITY},
                { INFINITY,    1, INFINITY,    2, INFINITY},
                { INFINITY, INFINITY, INFINITY, INFINITY, INFINITY},
                { INFINITY,    6,   10,    4, INFINITY}  };


        // WE CALL THE METHOD TO FIND DISTANCES OF OTHER VERTICES TO VERTEX A
        DistanceDijkstra(N,cost, distances);  // DistanceDijkstra methodunu çağırıyoruz

        for (int i=0; i<distances.length; ++i)  // distance array bastırıyoruz
            System.out.println("Distance of A to "+nameList.get(i)+": "+distances[i]);
    }


    // DIJKSTRA'S SHORTEST PATH ALGORITHM METHOD
    public static void DistanceDijkstra(int N, int[][] cost, int[] D)
    {

        int w, v, minDistance;

        boolean isVisited[] = new boolean[N];

        D[0] = 0;
        for(v=1; v<N; v++) {
            isVisited[v] = false;
            D[v] = cost[0][v];
        };

        for(int i=1; i<N; ++i)
        {
            minDistance = INFINITY;
            for(w=1; w<N; w++)
                if(!isVisited[w])
                    if(D[w]<minDistance) {
                        v = w;
                        minDistance = D[w];
                    }

            isVisited[v] = true;

            for(w=1; w<N; w++)
                if(!isVisited[w])
                    if(minDistance+cost[v][w] < D[w])
                        D[w] = minDistance + cost[v][w];
        }

    }

}