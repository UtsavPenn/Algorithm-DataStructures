class Graph
{
    private int V;   // No. of vertices

    // Array  of lists for Adjacency List Representation
    private LinkedList<Integer> adj[];

    // Constructor
    Graph(int v){
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    //Function to add an edge into the graph
    void addEdge(int v, int w){
        adj[v].add(w);  // Add w to v's list.
    }

    void DFSUtil(int v,boolean[] visited){
        visited[v] = true;
        System.out.print(v+" ");
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
          int n = i.next();
          if(!visited[n]){
            DFSUtil(n,visited);
          }
        }
    }

    void DFS(int v) {
        HashSet <Integer> visited = new HashSet<Integer>();
        DFSUtil(v,visited);
    }

    void BFS(int v){
       boolean visited[] = new boolean[V];
       LinkedList<Integer> queue = new LinkedList<Integer>();
       visited[s] = true;

       queue.add(s);
       while (queue.size() != 0){
         s = queue.poll();
         System.out.print(v+" ");
         Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
              int n  = i.next();
              if (!visited[n]){
                    visited[n] = true;
                    queue.add(n);
              }
          }
       }
    }

  }
