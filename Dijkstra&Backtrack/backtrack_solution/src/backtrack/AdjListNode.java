package backtrack;

/**
 class to represent an entry in the adjacency list of a vertex
 in a graph
*/
public class AdjListNode {

	private int vertexIndex; //i.e v0
	private int weight;
	// could be other fields, for example representing
	// properties of the edge - weight, capacity, . . .

    /* creates a new instance */
	public AdjListNode(int i,int w){
		vertexIndex = i;
		weight = w;
		
	}

	

	public int getVertexIndex(){
		return vertexIndex;
	}

	@Override
	public String toString() {
		return "AdjListNode [vertexIndex=" + vertexIndex + ", weight=" + weight + "]";
	}



	public void setVertexIndex(int n){
		vertexIndex = n;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}

