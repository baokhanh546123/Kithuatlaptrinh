package DSA;

public class Graphs_Weight {
	int size ; 
	int [][] matrix ; 
	String [] vertex_data ; 
	public Graphs_Weight(int size) {
		this.size = size ;
		this.matrix = new int [size][size];
		this.vertex_data = new String[size];
	}
	
	public void addEgde(int i , int j , int weight) {
		if ((i >= 0 && i < size) && (j >= 0 && j < size)) {
			if (weight > 0 )
				matrix[i][j] = weight ;
			else
				System.out.print("Loi");
		}
		else {
			System.out.println("Loi");
			System.exit(0);
		}
	}
	public void addVertex(int vertex ,String data) {
		if (vertex >= 0 && vertex < size) {
			vertex_data[vertex] = data;
		}else {
			System.out.println("Loi");
			System.exit(0);
		}
	}
	public void Print() {
		System.out.println("Adjacency Matrix:");
		for (int i = 0 ; i < size ; i++) {
			for (int j = 0 ; j < size ; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("Vertex Data :");
		for (int i = 0 ; i < size ; i++){
			System.out.println(vertex_data[i] + " : " + i);
		}
		
	}
}
