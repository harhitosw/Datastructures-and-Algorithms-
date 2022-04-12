import java.util.Scanner;
public class DjikstrasSPA
{
    private int V;
    //pass the number of vertices in graph in a constructor 
    public DjikstrasSPA(int M){
        V=M;
    }
    // first we will create a fucntion that gives us a shortest path
    int getMindistance(int dist[],Boolean vistedset[]){
        int min=Integer.MAX_VALUE,minindex=-1;
        for(int i=0;i<V;++i){
            if(vistedset[i]==false && dist[i]<=min){
                min=dist[i];
                minindex=i;
            }
        }
        return minindex;
        
    }
    // an function to print the Data from all nodes 
    void printSolution(int dist[],int src)
    {
        System.out.println("Vertex \t\t Distance from Source Node Numbered "+src);
        for (int i = 0; i < V; i++){
        // handling those cases where the path is reachable or no edge exists
            if(dist[i]==2147483647){
                System.out.println(i+" \t\t"+"INFINITY / NOT REACHABLE");
            }
            else{
                System.out.println(i + " \t\t " + dist[i]);
            }
        }
    }
 
    void getShortestPath(int graph[][],int src){
        //first initialize the given values
        int dist[]=new int[V];
        Boolean[] vistedset=new Boolean[V];
        //now we initialize all the distances from the source to Infinity
        for(int i=0;i<V;++i){
            dist[i]=Integer.MAX_VALUE;
            vistedset[i]=false;
        }
        // now let the source be at the 0 distance from itself
        dist[src]=0;
        // now we start the shoretest path algorithms for each  vertex in the graph 
        for(int i=0;i<V;++i){
            int u=getMindistance(dist,vistedset);
            vistedset[u]=true;
            for(int k=0;k<V;++k)
            if(!vistedset[k] && graph[u][k]!=0 && dist[u]!=Integer.MAX_VALUE && dist[u]+graph[u][k]<dist[k]){
                // update the value of that particular path 
                dist[k]=dist[u]+graph[u][k];
            }
        }
        printSolution(dist,src);
    }
	public static void main(String[] args) {
		int M,source;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Number of Nodes in the graph");
        M=sc.nextInt();
        System.out.println("Enter source vertex");
        source=sc.nextInt();
        DjikstrasSPA t = new DjikstrasSPA(M);
        int graph[][] = new int[M][M];
        System.out.println("Enter the elements of the Graph in matrix format");
            for (int i = 0; i < M; i++)
                for (int j = 0; j < M; j++)
                    graph[i][j] = sc.nextInt();
        
        t.getShortestPath(graph,source);
	}
}
