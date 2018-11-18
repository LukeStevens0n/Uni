package dijkstra;
import java.util.LinkedList;

public class Vertex {
	
	private LinkedList<AdjListNode>adjlist;
	private int index; //index of vertex in graph
	
	
	public Vertex(int i) {
		
		adjlist = new LinkedList <AdjListNode>();
		this.index=i;
		
	}
	
	
	public LinkedList<AdjListNode> getAdjlist() {
		return adjlist;
	}


	


	public int getIndex() {
		return index;
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
