package dijkstra;
import java.io.*;
import java.util.*;

/**
 program to find shortest path using Dijkstra's algorithm
 */
public class Main {

	public static void main(String[] args) throws IOException {
		
		
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a filepath: ");
		
		
		String inputFileName = scan.next();
		
		scan.close();
		
		FileReader reader = new FileReader(inputFileName);
		long start = System.currentTimeMillis();
		Scanner in = new Scanner(reader);
		
		// read in the data here and create graph here
		
		int no_of_nodes = in.nextInt();
		
		System.out.println(in.nextLine());
		String adjacency_list=in.nextLine();
		String last = "";
	
		
		Vertex[] vertices = new Vertex[no_of_nodes];
		
		for (int i =0;i<no_of_nodes;i++) {
			
			//create node and make adjacency list //
			Vertex v = new Vertex(i);
			v.addToAdjList(adjacency_list);
			vertices[i]=v;
			adjacency_list= in.nextLine();
			if (i>=no_of_nodes-1) {
				last = last +adjacency_list;
				
			}
			vertices[i].toString();
			
			
		}
		
		Graph graph = new Graph(no_of_nodes,vertices);
		
	
		reader.close();		
		in.close();
		String[] split = last.split(" ");
		int start_node = Integer.parseInt(split[0]);
		int end_node = Integer.parseInt(split[1]);
		Dijkstra d = new Dijkstra(start_node,end_node,graph);
		
		d.main();
		
		// do the work here
		
		// end timer and print total time
		long end = System.currentTimeMillis();
		System.out.println("\nElapsed time: " + (end - start) + " milliseconds");
	}

}
