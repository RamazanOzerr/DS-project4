public class PrimsMST {

    private static final int n = 9; // number of nodes/vertices in the graph
    private static final String[] verticeList = {"a","b","c","d","e","f","g","h","i"};

    // tüm vertice lerin üzerinde dolaşıp min olanın index ini döndüren method
    public int findMinKeyVertex(int[] keys, Boolean[] visited){

        int minIndex = -1;
        int minValue = Integer.MAX_VALUE; // we use this to create an infinitive int

        // tüm vertice lerin üzerinde dolaşıyoruz, min value bulmak için
        for(int vertex = 0; vertex < n; vertex++){
            if(visited[vertex] == false && keys[vertex] < minValue){
                minValue = keys[vertex];
                minIndex = vertex;
            }
        }

        return minIndex;
    }

    // display method
    public void displayMST(int[] mstList, int[][] graphList){

        System.out.println("Edge \t\tWeight"); // have no clue wth im doin
        for(int j = 1; j<n; j++){
            System.out.println(verticeList[mstList[j]] + " - "+ verticeList[j] + "\t\t" + graphList[j][mstList[j]]);

        }
    }

    // asıl Prim's algorithm uyguladığımız kısım
    public void designMST(int[][] graphList){

        int[] mstList = new int[n];
        int[] keys = new int[n]; // create keys[] array for selecting an edge having minimum weight in cut
        Boolean[] visited = new Boolean[n];

        // key lerin value larını infitine yaptık
        for(int i = 0; i<n; i++){
            keys[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        keys[0] = 0;
        mstList[0] = -1;

        for(int i = 0; i<n-1; i++){

            // daha önce uğranmamış ve min değere sahip node bulundu
            int edge = findMinKeyVertex(keys,visited); // index değeri
            visited[edge] = true; // artık uğramış olduk
            for(int vertex = 0; vertex<n; vertex++){
                if(graphList[edge][vertex] != 0 && visited[vertex] == false &&
                        graphList[edge][vertex]< keys[vertex]){

                    mstList[vertex] = edge;
                    keys[vertex] = graphList[edge][vertex];

                }
            }

            displayMST(mstList,graphList);

        }


    }



// main method for testing the code
    public static void main(String[] args) {

        PrimsMST mst = new PrimsMST();

        int[][] graphList = new int[][]{{ 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 }};

        mst.designMST(graphList);


    }

}
