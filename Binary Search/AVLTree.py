class Node:
    def __init__(self,data):
        self.data = data 
        self.left = None 
        self.right = None
        self.height = 1 
    def getHeight(self,node):
        if node is None : 
            return 0 
        return node.height
    def getBalance(self,node):
        if node is None :
            return 0 
        return self.getBalance(node.left) - self.getBalance(node.right)
    def rightRotate(self,y):
        print("Rotate right on node " , y.data)
        x = y.left 
        T2 = x.right 
        x.right = y 
        y.left = T2 
        y.height = 1 + max(self.getHeight(y.left),self.getHeight(y.right))
        x.height = 1 + max(self.getHeight(x.left),self.getHeight(x.right))
        return x
    def leftRotate(self,x):
        print("Rotate left on node " , x.data)
        y = x.right 
        T2 = y.left 
        y.left = x 
        x.right = T2 
        x.height = 1 + max(self.getHeight(x.left),self.getHeight(x.right))
        y.height = 1 + max(self.getHeight(y.left),self.getHeight(y.right))
        return y
    def insert(self,node,data):
        if not node:
            return Node(data)
        
        if data <  node.data :
            node.left = self.insert(node.left , data)
        elif data > node.data :
            node.right = self.insert(node.right , data)
        node.height = 1 + max(self.getHeight(node.left),self.getHeight(node.right))
        balance = self.getBalance(node)

        if balance > 1 and data > node.left.data:
            return self.rightRotate(node)
        if balance < -1 and data < node.right.data:
            return self.leftRotate(node)
        if balance > 1 and data < node.left.data:
            node.left = self.leftRotate(node.left)
            return self.rightRotate(node)
        if balance < -1 and data > node.right.data:
            node.right = self.rightRotate(node.right)
            return self.leftRotate(node)
        return node
    def minValue(self,node):
        current = node 
        while current.left is not None :
            current = current.left 
        return current
    def delete(self,node,data):
        if not node :
            return node

        if data < node.data :
            node.left = self.delete(node.left , data)
        elif data > node.data :
            node.right = self.delete(node.right , data)
        else:
            if node.left is None:
                temp = node.left
                node = None 
                return temp 
            elif node.right is None:
                temp = node.right
                node = None 
                return temp 
            temp = self.minValue(node.right)
            node.data = temp.data
            node.right = self.delete(node.right , temp.data) 
    def preOrders(self,node):
        if node is None :
            return 
        print(node.data , end = " ")
        self.preOrders(node.left)
        self.preOrders(node.right)
    def inOrders(self,node):
        if node is None :
            return 
        self.inOrders(node.left)
        print(node.data , end = " ")
        self.inOrders(node.right)
    def postOrders(self,node):
        if node is None :
            return 
        self.postOrders(node.left)
        self.postOrders(node.right)
        print(node.data , end = " ")
if __name__ == "__main__":
    root = Node(3)
    root.insert(root,1)
    root.insert(root,5)
    root.insert(root,3)
    root.insert(root,7)
    root.insert(root,9)
    print("Duyet truoc")
    root.preOrders(root)
    print("\nDuyet tu truoc ra sau ")
    root.inOrders(root)
    print("\nDuyet tu sau ra truoc ")
    root.postOrders(root)
    print("\nSau khi them ")
    root.inOrders(root)
    print("\nSau khi xoa ")
    root.delete(root,1)
    root.inOrders(root)

    
