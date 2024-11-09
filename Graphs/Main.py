from AdjacencyMatrix import Graph
from AdjacencyMatrixWeight import Graph_Weight
if __name__ == '__main__':
    ad =Graph(3)
    print("Ma tran lien ke khong huong khong trong so ")
    ad.addEgde(0,1)
    ad.addEgde(0,2)
    ad.addEgde(1,2)

    ad.addVertex(0,"A")
    ad.addVertex(1,"B")
    ad.addVertex(2,"C")
    ad.display()


    weight = Graph_Weight(3)
    print("Ma tran lien ke co huong co trong so")
    weight.addEgde(0,1,20)
    weight.addEgde(0,2,12)
    weight.addEgde(1,2,39)
    weight.addEgde(2,1,30)
    weight.addEgde(2,2,7)
    

    
    weight.addVertex(0,"A")
    weight.addVertex(1,"B")
    weight.addVertex(2,"C")
    weight.printGraph()
