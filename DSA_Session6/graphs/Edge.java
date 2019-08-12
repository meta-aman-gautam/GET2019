package graphs;

public class Edge {

	int vertex ;
	int weight ;
	public Edge(int vertex , int weight){
		this.vertex=vertex;
		this.weight = weight ;
	}
	
	@Override
	public String toString(){
		return "("+vertex+","+weight+")";
	}
	
}
