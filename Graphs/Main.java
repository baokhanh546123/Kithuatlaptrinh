package DSA;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graphs graphs = new Graphs(8);
		graphs.addVertex(0,"A");
		graphs.addVertex(1,"B");
		graphs.addVertex(2,"C");
		graphs.addVertex(3,"D");
		graphs.addVertex(4,"E");
		graphs.addVertex(5,"F");
		graphs.addVertex(6,"G");
		graphs.addVertex(7,"K");
		
		graphs.addEdge(0, 1);
		graphs.addEdge(1, 3);
		graphs.addEdge(3, 2);
		graphs.addEdge(0, 2);
		graphs.addEdge(2, 1);
		graphs.addEdge(0, 3);
		graphs.addEdge(4, 5);
		graphs.addEdge(4, 6);
		graphs.addEdge(4, 7);
		graphs.addEdge(5, 6);
		graphs.addEdge(5, 7);
		graphs.addEdge(6, 7);
		graphs.addEdge(0, 4);
		graphs.addEdge(0, 6);
		graphs.addEdge(2, 5);
		graphs.addEdge(2, 7);
		
		
		
		graphs.display();
		
		System.out.println();
		graphs.dfs(3);
		System.out.println();
		graphs.bfs(2);
		System.out.println();
		System.out.println(graphs.isConnected(0, 2) ? "Co ket noi " : "Khong ket noi");
		
		graphs.dijkstra(0);
		
	}

}
