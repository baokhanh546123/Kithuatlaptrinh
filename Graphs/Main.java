package DSA;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graphs graphs = new Graphs(4);
		graphs.addVertex(0,"A");
		graphs.addVertex(1,"B");
		graphs.addVertex(2,"C");
		graphs.addVertex(3,"D");
		
		graphs.addEgde(0,1);
		graphs.addEgde(1, 3);
		graphs.addEgde(3, 2);
		graphs.addEgde(0, 2);
		graphs.addEgde(2, 1);
		graphs.addEgde(0,3);
		
		graphs.display();
		
		System.out.println();
		graphs.start_dfs(3);
		System.out.println();
		graphs.start_bfs(2);
		System.out.println();
		System.out.println(graphs.isConnected(0, 2) ? "Co ket noi " : "Khong ket noi");
		
		Graphs_Weight weight = new Graphs_Weight(4);
		weight.addEgde(0, 1, 5);
		weight.addEgde(1, 3 ,2);
		weight.addEgde(3, 2, 3);
		weight.addEgde(0,2, 4);
		weight.addEgde(2,1,1);
		
		weight.addVertex(0,"A");
		weight.addVertex(1,"B");
		weight.addVertex(2,"C");
		weight.addVertex(3,"D");
		weight.Print();
	}

}
