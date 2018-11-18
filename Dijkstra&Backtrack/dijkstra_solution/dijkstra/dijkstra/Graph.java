package dijkstra;

public class Graph {
	
	private Vertex[] vertices;
	public int num_vertices;
	
	
	
	
	public Graph(int n,Vertex[] vs) {
		vertices = vs;
		num_vertices = n;
		
		
	}



	public Vertex[] getVertices() {
		return vertices;
	}



	


	public int getNum_vertices() {
		return num_vertices;
	}



	

}
