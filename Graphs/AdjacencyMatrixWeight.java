package DSA;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graphs_Weight {
    int size;
    int[][] matrix;
    String[] vertex_data;
    public Graphs_Weight(int size) {
        this.size = size;
        this.matrix = new int[size][size];
        this.vertex_data = new String[size];
    }
    public void addEdge(int i, int j, int weight) {
        if ((i >= 0 && i < size) && (j >= 0 && j < size)) {
            if (weight > 0)
                matrix[i][j] = weight;
            else
                System.out.println("Trọng số phải là số dương.");
        }
    }
    public void addVertex(int vertex, String data) {
        if (vertex >= 0 && vertex < size) {
            vertex_data[vertex] = data;
        }
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

    
    public void bfs(int startVertex) {
        boolean[] visited = new boolean[size];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);
        visited[startVertex] = true;

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(vertex_data[currentVertex] + " ");
            for (int i = 0; i < size; i++) {
                if (matrix[currentVertex][i] > 0 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

	
    public int getMinDistance(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < size; i++) {
            if (!visited[i] && dist[i] < min) {
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
    public int dijkstra(String start_vertex_data) {
        int start_vertex = -1;
        for (int i = 0; i < vertex_data.length; i++) {
            if (vertex_data[i].equals(start_vertex_data)) {
                start_vertex = i;
                break; 
            }
        }
        if (start_vertex == -1) {
            System.out.println("Không tìm thấy đỉnh với dữ liệu: " + start_vertex_data);
            return -1;
        }
        int[] dist = new int[size];
        Arrays.fill(dist, Integer.MAX_VALUE); // inf 
        dist[start_vertex] = 0; // luon bat dau voi dinh = 0

        boolean[] visited = new boolean[size];

        //Duyet graphs
        for (int i = 0; i < size; i++) {
            int u = getMinDistance(dist, visited); 
            visited[u] = true;
            for (int v = 0; v < size; v++) {
                if (!visited[v] && matrix[u][v] > 0 && dist[u] != Integer.MAX_VALUE && dist[u] + matrix[u][v] < dist[v]) {
                    dist[v] = dist[u] + matrix[u][v];
                }
            }
        }
        System.out.println("Khoảng cách từ đỉnh " + start_vertex_data + " đến các đỉnh khác:");
        for (int i = 0; i < size; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println(vertex_data[i] + ": Không thể đến");
            } else {
                System.out.println(vertex_data[i] + ": " + dist[i]);
            }
        }
        return 0;
    }
    public void print() {
    	 System.out.println("Dữ liệu các đỉnh:");
         for (int i = 0; i < size; i++) {
             System.out.println(vertex_data[i] + " : " + i);
         }
        System.out.println("Ma trận kề:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

       
    }
}
