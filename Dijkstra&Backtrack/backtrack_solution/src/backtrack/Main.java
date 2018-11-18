package backtrack;

import java.io.*;
import java.util.*;

/**
 program to find shortest path using the backtrack search algorithm
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
			
			
			
		}
		
		
		
		
		
	
		reader.close();		
		in.close();
		String[] split = last.split(" ");
		int start_node = Integer.parseInt(split[0]);
		int end_node = Integer.parseInt(split[1]);
		Path path = new Path(vertices[start_node],vertices[end_node],vertices);
		
		
		path.backtrack(path.start);
		
		if (path.getBPL()!=Integer.MAX_VALUE) {
		System.out.println("Shortest distance from vertex "+start_node+" to vertex "+end_node+" is "+path.getBPL());

		System.out.println("Shortest path: ");
		
		for (Integer i : path.getBest_path()) {
			System.out.print(i+" ");
		}
		}else {
			System.out.println("There is no path from "+start_node +" to "+end_node);
		}
		long end = System.currentTimeMillis();
		System.out.println("\nElapsed time: " + (end - start) + " milliseconds");
	}
}
	
