class Graph_Weight:
    def __init__(self, size):
        self.size = size
        self.matrix = [[None] * size for _ in range(size)]  
        self.vertex_data = [" "] * size  # List to store vertex data
    
    def addEdge(self, i, j, weight):
        if 0 <= i < self.size and 0 <= j < self.size and weight > 0:
            self.matrix[i][j] = weight
    
    def addVertex(self, vertex, data):
        if 0 <= vertex < self.size:
            self.vertex_data[vertex] = data

    def dfs_util(self, v, visited):
        visited[v] = True
        print(self.vertex_data[v], end=" ")

        for i in range(self.size):
            if self.matrix[v][i] is not None and not visited[i]:  
                self.dfs_util(i, visited)
    
    def dfs(self, startVertexData):
        visited = [False] * self.size
        startVertex = self.vertex_data.index(startVertexData)
        self.dfs_util(startVertex, visited)

    def bfs(self, startVertexData):
        queue = [self.vertex_data.index(startVertexData)]
        visited = [False] * self.size
        visited[queue[0]] = True

        while queue:
            current_vertex = queue.pop(0)
            print(self.vertex_data[current_vertex], end=' ')
            for i in range(self.size):
                if self.matrix[current_vertex][i] is not None and not visited[i]:  
                    queue.append(i)
                    visited[i] = True
    
    def dijkstra(self, startVertexData):
        startVertex = self.vertex_data.index(startVertexData)
        distance = [float('inf')] * self.size
        distance[startVertex] = 0
        visited = [False] * self.size

        for _ in range(self.size):
            min_distance = float('inf')
            u = None
            for i in range(self.size):
                if not visited[i] and distance[i] < min_distance:
                    min_distance = distance[i]
                    u = i

            if u is None:
                break

            visited[u] = True

            for v in range(self.size):
                if self.matrix[u][v] is not None and not visited[v]:
                    alt = distance[u] + self.matrix[u][v]
                    if alt < distance[v]:
                        distance[v] = alt

        return distance
    
    def singleDestinationVertex(self, startVertexData, endVertexData):
        startVertex = self.vertex_data.index(startVertexData)
        endVertex = self.vertex_data.index(endVertexData)
        
        distances = [float('inf')] * self.size
        predecessors = [None] * self.size
        distances[startVertex] = 0
        visited = [False] * self.size

        for _ in range(self.size):
            min_distance = float('inf')
            u = None
            for i in range(self.size):
                if not visited[i] and distances[i] < min_distance:
                    min_distance = distances[i]
                    u = i
            
            if u is None or u == endVertex:
                break

            visited[u] = True

            for v in range(self.size):
                if self.matrix[u][v] is not None and not visited[v]: 
                    alt = distances[u] + self.matrix[u][v]
                    if alt < distances[v]:
                        distances[v] = alt
                        predecessors[v] = u
        
        path = []
        current = endVertex
        while current is not None:
            path.insert(0, self.vertex_data[current])
            current = predecessors[current]

        return distances[endVertex], path
    
    def printGraph(self):
        print("Adjacency Matrix:")
        for row in self.matrix:
            print(" ".join(map(lambda x: str(x) if x is not None else "0", row)))  
        print("\nVertex Data:")
        for vertex, data in enumerate(self.vertex_data):
            print(f"Vertex {vertex}: {data}")
