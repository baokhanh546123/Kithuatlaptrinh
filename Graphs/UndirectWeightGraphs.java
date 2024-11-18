package DSA;

import java.util.*;

public class GraphsUndirectedWeight {
	int size;
	int[][] matrix;
	String[] vertex_data;

	public GraphsUndirectedWeight(int size) {
		// TODO Auto-generated constructor stub
		this.size = size;
		this.matrix = new int[size][size];
		this.vertex_data = new String[size];
	}

	void addEgde(int i, int j, int w) {
		if (i >= 0 && i < size && j >= 0 && j < size)
			matrix[i][j] = w;
		matrix[j][i] = w;
	}

	void addVertex(int vertex, String data) {
		if (vertex >= 0 && vertex < size)
			vertex_data[vertex] = data;
	}

	public void dfs_util(int v, boolean[] visited) {
		visited[v] = true;
		System.out.print(vertex_data[v] + " ");
		for (int i = 0; i < size; i++) {
			if (matrix[v][i] > 0 && !visited[i])
				dfs_util(i, visited);

		}
	}

	public void dfs(int startVertex) {
		boolean[] visited = new boolean[size];
		dfs_util(startVertex, visited);
	}

	void bfs(int startVertex) {
		boolean[] visited = new boolean[size];
		Queue<Integer> queue = new LinkedList<Integer>();
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

	public void dijkstra(int startVertex) {
		int[] distance = new int[size];
		boolean[] visited = new boolean[size];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[startVertex] = 0;
		for (int i = 0; i < size; i++) {
			int u = -1;
			for (int j = 0; j < size; j++) {
				if (!visited[j] && (u == -1 || distance[j] < distance[i]))
					u = j;
			}
			if (distance[u] == Integer.MAX_VALUE)
				break;
			visited[u] = true;
			for (int v = 0; v < size; v++) {
				if (matrix[u][v] != 0 && !visited[v]) {
					int newDist = distance[u] + matrix[u][v];
					if (newDist < distance[v])
						distance[v] = newDist;
				}
			}
		}
		System.out.println("Khoảng cách từ đỉnh " + vertex_data[startVertex] + " đến các đỉnh khác ");
		for (int i = 0; i < size; i++) {
			System.out.println("Đỉnh " + vertex_data[i] + ": "
					+ (distance[i] == Integer.MAX_VALUE ? "Không thể tiếp cận" : distance[i]));
		}
	}

	void dijkstra_advance(int startVertex, int endVertex) {
		boolean[] visited = new boolean[size];
		int[] predecessors = new int[size];
		int[] distances = new int[size];

		Arrays.fill(distances, Integer.MAX_VALUE);
		distances[startVertex] = 0;

		for (int i = 0; i < size; i++) {
			int u = -1;

			for (int j = 0; j < size; j++) {
				if (!visited[j] && (u == -1 || distances[j] < distances[u])) {
					u = j;
				}
			}

			if (distances[u] == Integer.MAX_VALUE) {
				break;
			}

			visited[u] = true;

			if (u == endVertex) {
				break;
			}

			for (int v = 0; v < size; v++) {
				if (matrix[u][v] != 0 && !visited[v]) {
					int newDist = distances[u] + matrix[u][v];
					if (newDist < distances[v]) {
						distances[v] = newDist;
						predecessors[v] = u;
					}
				}
			}
		}

		System.out.println("Khoảng cách từ đỉnh " + vertex_data[startVertex] + " đến đỉnh " + vertex_data[endVertex]
				+ ": " + (distances[endVertex] == Integer.MAX_VALUE ? "Không thể tiếp cận" : distances[endVertex]));

		if (distances[endVertex] != Integer.MAX_VALUE) {
			System.out.print("Đường đi: ");
			int current = endVertex;
			StringBuilder path = new StringBuilder();
			while (current != startVertex) {
				path.insert(0, vertex_data[current]);
				current = predecessors[current];
			}
			path.insert(0, vertex_data[startVertex]);
			System.out.println(path.toString());
		}
	}

	void display() {
		System.out.println("Vertex");
		for (int i = 0; i < size; i++) {
			System.out.println(vertex_data[i] + " : " + i);
		}
		System.out.println("Adjacency Matrix");
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		GraphsUndirectedWeight graphs = new GraphsUndirectedWeight(5);
		graphs.addEgde(0, 1, 4);
		graphs.addEgde(0, 2, 2);
		graphs.addEgde(1, 2, 3);
		graphs.addEgde(1, 3, 2);
		graphs.addEgde(2, 4, 5);
		graphs.addEgde(2, 3, 4);
		graphs.addEgde(0, 4, 6);

		graphs.addVertex(0, "A");
		graphs.addVertex(1, "B");
		graphs.addVertex(2, "C");
		graphs.addVertex(3, "D");
		graphs.addVertex(4, "E");

		graphs.display();

		System.out.println("\nDFS : ");
		graphs.dfs(1);
		System.out.println("\nBFS : ");
		graphs.bfs(1);
		System.out.println("\nDijktra : ");
		graphs.dijkstra(2);
		System.out.println("\nDijktra : ");
		graphs.dijkstra_advance(1, 4);

	}
}
