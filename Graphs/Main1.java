package DSA;

public class Main1 {
	public static void main(String[] args) {
		Graphs_Weight graph = new Graphs_Weight(5);
		graph.addVertex(0, "A");
		graph.addVertex(1, "B");
		graph.addVertex(2, "C");
		graph.addVertex(3, "D");
		graph.addVertex(4, "E");
		graph.addEdge(0, 1, 25);
		graph.addEdge(0, 2, 22);
		graph.addEdge(1, 3, 12);
		graph.addEdge(1, 4, 10);
		graph.addEdge(2, 4, 6);
		graph.print();
		System.out.println("\nDFS bắt đầu từ đỉnh A:");
		graph.dfs(0);
		System.out.println("\nBFS bắt đầu từ đỉnh A:");
		graph.bfs(0);
		System.out.println("\nChạy thuật toán Dijkstra từ đỉnh A:");
		graph.dijkstra("B");

	}
}
