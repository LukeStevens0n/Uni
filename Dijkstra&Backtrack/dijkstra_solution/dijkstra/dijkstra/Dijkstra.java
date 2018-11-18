package dijkstra;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Dijkstra {

private int start;
private int end;
private Graph graph;




public Dijkstra(int s, int e, Graph g) {
        start = s;
        end = e;
        graph = g;

}

public void main () {
	
	// check if start & end nodes have no outgoing/incoming
	// nodes, so that we can confirm if there isn't a path from s -> e
	Vertex v[]= graph.getVertices();
	
	boolean path_exists=false;
	
	for (Vertex node:v) {
		for (AdjListNode neighbour: node.getAdjlist()) {
			if (neighbour.getVertexIndex()==end) {
				path_exists = true;
			}
		}
	}
	
	if (v[start].getAdjlist()==null) {
		path_exists=false;
	}
	
	
	
	Set<Vertex> unsettled_nodes = new HashSet<Vertex>();
	
	int dist[] = new int[graph.getNum_vertices()];
	Vertex prev[] = new Vertex[graph.getNum_vertices()]; //list of each nodes previous value
	
	//initialise distances
	for (int i=0;i<graph.getVertices().length;i++) {
		dist[i]=Integer.MAX_VALUE;
		
		unsettled_nodes.add(v[i]);
		
	}
	dist[start]=0;
	
	
	int min_index =0;
	//calculate min distances for each of the unsetted nodes
	for (int i=0;i<unsettled_nodes.size();i++) {
		
	
		int min=Integer.MAX_VALUE;
		
		for (int j=0;j< dist.length;j++) {
			if ((unsettled_nodes.contains(v[j]))){
				if (dist[j]<min) {
					min = dist[j];
					min_index =j;
					
				}
			}
		}
	
		
		unsettled_nodes.remove(v[min_index]);
		
		
		
		
		LinkedList<AdjListNode> adjacent = v[min_index].getAdjlist();
		
		// loop through removed node (the min distance from start or next node in path) and find the smallest distance from removed node
		for (AdjListNode node : adjacent) {
			if (unsettled_nodes.contains(v[node.getVertexIndex()])){
				
				int new_distance = dist[min_index]+ node.getWeight();
				if (new_distance<dist[node.getVertexIndex()]) {
					
					dist[node.getVertexIndex()]=new_distance;
					prev[node.getVertexIndex()]= v[min_index];
				}
			}
			
		}
		
	}
	

	
	
	//go backwards through the list of vertices and add previous values, creating the path
	LinkedList<Vertex>path = new LinkedList<Vertex>();
	
	Vertex u = v[end];
	
	if (prev[u.getIndex()]!=null || u == v[start]) {
		while (u!=null) {
			path.addFirst(u);
			u = prev[u.getIndex()];
	}
}
	
	
	
	
	if (!(path_exists)) {
		System.out.println("There is no path from vertex "+start+" to vertex "+end);
	}
	else {
		System.out.println("Shortest distance from vertex "+start+" to vertex "+end+" is "+dist[end]);
		System.out.print("Shortest path:");
		for (Vertex node : path) {System.out.print(" "+node.getIndex());}
		}
}
}
