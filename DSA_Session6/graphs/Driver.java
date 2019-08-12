package graphs;

public class Driver {

  public static void main(String []args){
	  MyGraphs graphs =new MyGraphs(5);
	  System.out.println(graphs.toString());
	  
	  graphs.addEdge(1, 0, 10);
	  graphs.addEdge(2, 1, 15);
	  graphs.addEdge(0, 3, 10);
	  graphs.addEdge(1, 4, 20);
	  graphs.addEdge(4, 2, 15);
	  graphs.addEdge(3, 4, 15);
	  graphs.addEdge(4, 4, 15);
	  
	  System.out.println(graphs.toString());
	  
	  System.out.println(graphs.isConnected(1, 3));
  }
	
}
