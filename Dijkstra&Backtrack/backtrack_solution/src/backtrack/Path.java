package backtrack;
import java.util.*;

public class Path {
	
	Vertex start;
	Vertex destination;
	int current_path_length;
	int best_path_length;
	Vertex [] vertices;
	private LinkedList<Integer> current_path=new LinkedList<>();
	private LinkedList<Integer> best_path=new LinkedList<>();
	
	

	
	
	
	public void backtrack(Vertex n) {

		for (int i=0; i< n.getAdjlist().size();i++) {
			//for each unvisited vertex adjacent to last vertex in path
			
			AdjListNode neighbour = n.getAdjlist().get(i);
			
			Vertex neighbour_vertice = vertices[neighbour.getVertexIndex()];
			if (!(neighbour_vertice.getVisited())) {
				
				// update current path with the weight between our starting node and neighbour
				
				current_path.addLast(neighbour_vertice.getIndex());
				current_path_length = current_path_length+ n.getAdjlist().get(i).getWeight();
				
				neighbour_vertice.setVisited(true);
				
				if (current_path_length<best_path_length) {
					
					
				
					if (neighbour_vertice.getIndex()==destination.getIndex()) {//shorter path found
						// if current < best, set best to current
						best_path_length = current_path_length;
						
						//if current path as of line 31 ends with our destination vertex
						//set best path to current path
						best_path = new LinkedList<>(current_path);
				
					}
					else {
						
					backtrack(neighbour_vertice); //move up one position in list
					
					}
				}
				//in the case of the current path not being successful, reset the values to before they were changed (31&32)
				current_path_length = current_path_length- n.getAdjlist().get(i).getWeight();
				current_path.removeLast();
				neighbour_vertice.setVisited(false);
			}
			
			
		}}
		
		
	
	
	public LinkedList<Integer> getBest_path() {
		return best_path;
	}

	

	public Path(Vertex start, Vertex dest,Vertex[] v) {
		this.start = start;
		this.destination =dest;
		this.vertices=v;
		this.best_path_length=Integer.MAX_VALUE;
		this.current_path_length=0;
		current_path.add(start.getIndex());
	}

	public Vertex getStart() {
		return start;
	}

	public void setStart(Vertex start) {
		this.start = start;
	}

	public Vertex getDestination() {
		return destination;
	}

	public void setDestination(Vertex destination) {
		this.destination = destination;
	}

	public int getBPL() {
		return this.best_path_length;
	}

	
	
	
	
	

}
