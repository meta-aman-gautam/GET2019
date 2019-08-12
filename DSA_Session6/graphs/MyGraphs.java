package graphs;


import java.util.*;

public class MyGraphs {

	List<Edge> graph[] ;
	
	public MyGraphs(int vertex){
		graph = new LinkedList[vertex];
		for(int count_i=0;count_i<vertex;count_i++){
			graph[count_i] =new LinkedList<Edge>();
		}
	}
	
	public void addEdge(int source , int destination ,int weight){
		
		graph[source].add(0,new Edge(destination,weight));
		graph[destination].add(0,new Edge(source,weight));
	}
	
	public boolean isConnected(int source ,int destination){
		
		for(Edge everyEdge : graph[source]){
			if(everyEdge.vertex==destination)
				return true;
		}
		return false;
	}
	
	
	@Override
	public String toString(){
	String result="";
		for(int count_i=0;count_i<graph.length;count_i++){
			result+=count_i+"===>"+graph[count_i]+"\n";
		}
		return result;		
	}
	
	
}
