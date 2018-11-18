package backtrack;
import java.util.LinkedList;

public class Vertex {
	
	private LinkedList<AdjListNode>adjlist;
	private int index; //index of vertex in graph
	private boolean visited;
	
	
	public Vertex(int i) {
		
		adjlist = new LinkedList <AdjListNode>();
		this.index=i;
		this.visited=false;
		
	}
	
	
	public LinkedList<AdjListNode> getAdjlist() {
		return adjlist;
	}


	


	public int getIndex() {
		return index;
	}

	public boolean getVisited() {
		return visited;
	}
	
	

	


	public void setVisited(boolean visited) {
		this.visited = visited;
	}


	@Override
	public String toString() {
		return "Vertex [adjlist=" + adjlist + ", index=" + index + "]";
	}


	public void addToAdjList(String list) {
		
		String[] split = list.split("\\s+");
		int vertex_number;
		int weight;
		
		
		
		for (int i=0;i<split.length;i++) {
			
			if (Integer.parseInt(split[i])!=0){
				vertex_number=i;
				weight= Integer.parseInt(split[i]);
				
				AdjListNode node = new AdjListNode(vertex_number,weight);
				
				adjlist.addLast(node);
				
				
			}
		}
		
		
		
	}


	


	
	

}



