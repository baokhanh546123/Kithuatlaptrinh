from AdjacencyMatrix import Graph

if __name__ == '__main__':
    ad =Graph(3)
    print("Ma tran liên kề không hướng không trọng số ")
    ad.addEgde(0,1)
    ad.addEgde(0,2)
    ad.addEgde(1,2)

    ad.addVertex(0,"A")
    ad.addVertex(1,"B")
    ad.addVertex(2,"C")
    ad.display()
    print("Duyệt DFS")
    ad.dfs("B")
    print("\nDuyệt BFS")
    ad.bfs("B")
