
class Graph:
    def __init__(self,size):
        self.size = size 
        self.matrix = [[0] * size for _ in range(size)]
        self.vertex_data = [" "] * size 
    def addEgde(self,i,j):
        if 0 <= i < self.size and 0 <= j < self.size:
            self.matrix[i][j] = 1
            self.matrix[j][i] = 1
    def addVertex(self,vertex,data):
        if 0 <= vertex < self.size:
            self.vertex_data[vertex] = data
    def dfs_util(self,v , visited):
        visited[v] = True 
        print(self.vertex_data[v] , end = " ")

        for i in range(self.size):
            if self.matrix[v][i] == 1 and not visited[i]:
                self.dfs_util(i,visited)
    def dfs(self,startVertex):
        visited = [False] * self.size
        startVertex = self.vertex_data.index(startVertex)
        self.dfs_util(startVertex,visited)
    def bfs(self, startVertexData):
        queue = [self.vertex_data.index(startVertexData)]
        visited = [False] * self.size
        visited[queue[0]] = True

        while queue:
            current_vertex = queue.pop(0)
            print(self.vertex_data[current_vertex], end=' ')
            for i in range(self.size):
                if self.matrix[current_vertex][i] is not None and not visited[i]:  # Edge exists
                    queue.append(i)
                    visited[i] = True
    def display(self):
        print("Adjacency Matrix")
        for row in self.matrix:
                print(" ".join(map(str,row)))
        print("\nVertex Data")
        for vertex , data in enumerate(self.vertex_data):
            print(f"Vertex {vertex} : {data}")
