
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
    def addVertexWeight(self,vertex ,data):
        if 0 <= vertex < self.size:
            self.vertex_data[vertex] = data
    def display(self):
        print("Adjacency Matrix")
        for row in self.matrix:
                print(" ".join(map(str,row)))
        print("\nVertex Data")
        for vertex , data in enumerate(self.vertex_data):
            print(f"Vertex {vertex} : {data}")
    def printGraph(self):
        print("Adjacency Matrix")
        for row in self.matrix1:
                print(" ".join(map(lambda x : str(x) if x is not None else "0" , row)))
        print("\nVertex Data")
        for vertex , data in enumerate(self.vertex_data):
            print(f"Vertex {vertex} : {data}")
if __name__ == '__main__':
    graph = Graph(4)
    graph.addVertex(0,"A")
    graph.addVertex(1,"B")
    graph.addVertex(2,"C")
    graph.addVertex(3,"D")
    graph.addEgde(0,1)
    graph.addEgde(0,2)
    graph.addEgde(1,2)
    graph.addEgde(2,3)
    graph.display()
