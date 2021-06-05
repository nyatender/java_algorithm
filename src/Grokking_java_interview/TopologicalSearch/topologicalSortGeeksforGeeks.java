package Grokking_java_interview.TopologicalSearch;
import java.io.*;
import java.util.*;
public class topologicalSortGeeksforGeeks {
    // A Java program to print topological
    // sorting of a DAG
    // No. of vertices
    private int V;

    // Adjacency List as ArrayList of ArrayList's
    private ArrayList<ArrayList<Integer> > adj;

    // Constructor
    topologicalSortGeeksforGeeks(int v)
    {
        V = v;
        adj = new ArrayList<ArrayList<Integer> >(v);
        for (int i = 0; i < v; ++i)
            adj.add(new ArrayList<Integer>());
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) { adj.get(v).add(w); }

    // A recursive function used by topologicalSort
    void topologicalSortUtil(int v, boolean visited[],
                             Stack<Integer> stack)
    {
        // Mark the current node as visited.
        visited[v] = true;

        // Recur for all the vertices adjacent
        // to this vertex
        for (Integer child : adj.get(v)) {
            if (!visited[child])
                topologicalSortUtil(child, visited, stack);
        }

        // Push current vertex to stack
        // which stores result
        stack.push(v);
    }

    // The function to do Topological Sort.
    // It uses recursive topologicalSortUtil()
    void topologicalSort()
    {
        Stack<Integer> stack = new Stack<Integer>();

        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];

        // Call the recursive helper
        // function to store
        // Topological Sort starting
        // from all vertices one by one
        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack);

        // Print contents of stack
        while (stack.empty() == false)
            System.out.print(stack.pop() + " ");
    }

    // Driver code
    public static void main(String args[])
    {
        // Create a graph given in the above diagram
        topologicalSortGeeksforGeeks g = new topologicalSortGeeksforGeeks(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological "
                + "sort of the given graph");
        // Function Call
        g.topologicalSort();
    }
}
// This code is contributed by Aakash Hasija
