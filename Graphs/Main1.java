from AdjacencyMatrixWeight import Graph_Weight
n = 5 
graph = Graph_Weight(n)
graph.addVertex(0, "A")
graph.addVertex(1, "B")
graph.addVertex(2, "C")
graph.addVertex(3, "D")
graph.addVertex(4, "E")

graph.addEdge(0, 1, 10)  
graph.addEdge(0, 3, 30)  
graph.addEdge(1, 2, 50)  
graph.addEdge(2, 3, 20)  
graph.addEdge(2, 4, 10)  
graph.addEdge(3, 4, 60)  


graph.printGraph()

print("\nBFS")
graph.bfs("A")

distances = graph.dijkstra("A")
print("\nDijkstra:", distances)

start = "B"
end = "C"
distance, path = graph.singleDestinationVertex(start, end)
print(f"\nKhoảng cách ngắn nhất {start} đến {end}: {distance}")
print(f"Phần từ {n - n } to {n - 1}:", " -> ".join(path))
