package DSA;

import java.util.*;

public class Graphs {
	int size;
	int[][] matrix;
	String[] vertex_data;

	public Graphs(int size) {
		this.size = size;
		this.matrix = new int[size][size];
		this.vertex_data = new String[size];
	}

	public void addEdge(int i, int j) {
		if ((i >= 0 && i < size) && (j >= 0 && j < size)) {
			matrix[i][j] = 1;
			matrix[j][i] = 1;
		} else {
			System.out.println("Loi");
			System.exit(0);
		}
	}

	public void addVertex(int vertex, String data) {
		if (vertex >= 0 && vertex < size) {
			vertex_data[vertex] = data;
		} else {
			System.out.println("Loi");
			System.exit(0);
		}
	}

	public boolean isConnected(int i, int j) {
		if (i < 0 || i >= size || j < 0 || j >= size) {
			return false;
		}
		return matrix[i][j] == 1;
	}

	public void dfs_util(int v, boolean[] visited) {
		visited[v] = true;
		System.out.print(vertex_data[v] + " ");
		for (int i = 0; i < size; i++) {
			if (matrix[v][i] == 1 && !visited[i])
				dfs_util(i, visited);
		}
	}

	public void dfs(int startVertex) {
		boolean[] visited = new boolean[size];
		dfs_util(startVertex, visited);
	}

	public void bfs(int startVertex) {
		boolean[] visited = new boolean[size];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(startVertex);
		visited[startVertex] = true;
		while (!queue.isEmpty()) {
			int currentVertex = queue.poll();
			System.out.print(vertex_data[currentVertex] + " ");
			for (int i = 0; i < size; i++) {
				if (matrix[currentVertex][i] != 0 && !visited[i])
					queue.add(i);
				visited[i] = true;
			}
		}
	}

	public void display() {
		System.out.println("Vertex Data :");
		for (int vertex = 0; vertex < size; vertex++) {
			System.out.printf("Vertex %d: %s%n", vertex, vertex_data[vertex]);
		}

		System.out.println("Adjacency Matrix :");
		for (int[] row : matrix) {
			for (int value : row) {
				System.out.print(value + " ");
			}
			System.out.println();
		}

	}
}
