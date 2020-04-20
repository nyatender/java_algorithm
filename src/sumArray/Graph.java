

import java.util.*;

public class Graph {

	private int V;
	private LinkedList<Integer> adj[];
	
	public Graph(int v)
	{
		V= v;
		adj = new LinkedList[v];
		for(int i = 0; i < v;i++) 
		{
			adj[i] = new LinkedList<>();
		}
	}
	public void addEdge(int v, int w)
	{
		adj[v].add(w);		
	}
	
	public void BFS(int v)
	{
		boolean visited[] = new boolean[V];
		LinkedList<Integer>Queue = new LinkedList<>();
		
		visited[v] = true;
		Queue.add(v);
		while(!Queue.isEmpty())
		{
			v = Queue.poll();
			System.out.println(v+" ");
			Iterator<Integer>It = adj[v].listIterator();
			while(It.hasNext())
			{
				int item = It.next();
				if(!visited[item]) {
					visited[item] = true;
					Queue.add(item);
				}
			}
			
		}
		
	}
	
	public void DFSUtils(int v, boolean visited[])
	{

		visited[v] = true;
		System.out.println(v+" ");
		Iterator<Integer> it = adj[v].listIterator();
		while(it.hasNext())
		{
			int item = it.next();
			if(!visited[item])
			{
				DFSUtils(item, visited);
			}
		}		
	}
	
	public void DFS(int v)
	{
		boolean visited[] = new boolean[V];
		
		DFSUtils(v, visited);	
		
	}
	
	public static void main(String[] args) {
		
		Graph g = new Graph(4);

        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  
        System.out.println("Following is Breadth First Traversal "+ 
                           "(starting from vertex 2)"); 
  
        g.DFS(2);
	}
}
