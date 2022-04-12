import java.util.Scanner;
class PrimsMST {
    // Number of vertices in the graph passed in through the constructor 
    private int V;
    public PrimsMST(int M){
        V=M;
    }
// A function that helps us to keep track of visited Nodes and get the minimum valued Key 
    int minKey(int key[], Boolean mstSet[])
    {
        // Initialize the required values 
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int v = 0; v < V; v++)
            if (mstSet[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }
        return min_index;
    }
 // to print the MST 
    void printMST(int parent[], int graph[][])
    {
        System.out.println("Edge \tWeight");
        for (int i = 1; i <V ; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }
 
// using this function to make a MST and print that 
    void primMST(int graph[][])
    {
        // Array to store constructed MST
        int parent[] = new int[V];
        // Key values used to pick minimum weight edge in cut
        int key[] = new int[V];
        // To represent set of vertices which are included in the tree 
        Boolean mstSet[] = new Boolean[V];
        // Initialize all keys as INFINITE
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
        // Always include first 1st vertex in MST.
        key[0] = 0; // Make key 0 so that this vertex is always first one 
        parent[0] = -1; // First node is always root of MST
 
        // The MST will have V nodes
        for (int count = 0; count < V - 1; count++) {
           // add those keys from the vertices that are not added in BST and are minimum
            int u = minKey(key, mstSet);
            // Add the picked vertex to the MST Set
            mstSet[u] = true;
            //update the values and ick only the non-picked 
            for (int v = 0; v < V; v++)
                //update the value in key[] from graph[u][v] iff minimum
                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }
        // print the constructed MST
        printMST(parent, graph);
    }
    public static void main(String[] args)
    {
        int M;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Number of Nodes in the graph");
        M=sc.nextInt();
        PrimsMST t = new PrimsMST(M);
        int graph[][] = new int[M][M];
        System.out.println("Enter the elements of the Graph in matrix format");
            for (int i = 0; i < M; i++)
                for (int j = 0; j < M; j++)
                    graph[i][j] = sc.nextInt();
 
        // Print the solution
        t.primMST(graph);
    }
}
