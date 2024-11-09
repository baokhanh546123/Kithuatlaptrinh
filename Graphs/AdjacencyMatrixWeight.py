class Graph_Weight:
    def __init__(self , size ):
        self.size = size
        self.matrix = [[None] * size for _ in range(size)]
        self.vertex_data = [" "] * size 
    def addEgde(self,i,j,weight):
        self.matrix[i][j] = weight
    def addVertex(self,vertex,data):
        if (0 < vertex <= self.size ):
            self.vertex_data[vertex] = data
        
    def printGraph(self):
        print("Adjacency Matrix")
        for row in self.matrix:
                print(" ".join(map(lambda x : str(x) if x is not None else "0" , row)))
        print("\nVertex Data")
        for vertex , data in enumerate(self.vertex_data):
            print(f"Vertex {vertex} : {data}")
