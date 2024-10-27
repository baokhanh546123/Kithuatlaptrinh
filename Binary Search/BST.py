class Node:
    def __init__(self, data):
        self.data = data 
        self.left = self.right = None
    def add_element(self, root, x):
        if root is None:
            return Node(x)
        if root.data == x:
            return root
        if root.data < x:
            root.right = self.add_element(root.right, x)
        else:
            root.left = self.add_element(root.left, x)
        return root 

    def add_element_for_loop(self, root, data):
        temp = Node(data)
        if root is None:
            return temp 
        parent = None 
        current = root 
        while current is not None: 
            parent = current 
            if current.data > data:
                current = current.left 
            elif current.data < data:
                current = current.right
            else:
                return root  
        if parent.data > data:
            parent.left = temp 
        else: 
            parent.right = temp 
        return root

    def search(self, root, x):
        if root is None or root.data == x:
            return root
        if x > root.data: 
            return self.search(root.right, x)
        return self.search(root.left, x)

    def get_successor(self, node):
        current = node.right
        while current.left is not None: 
            current = current.left 
        return current

    def delete(self, root, x):
        if root is None:
            return root 
        if root.data > x:
            root.left = self.delete(root.left, x)
        elif root.data < x:
            root.right = self.delete(root.right, x)
        else:
            if root.left is None: 
                return root.right 
            if root.right is None:
                return root.left 
            root.data = self.minvalue(root.right)
            root.right = self.delete(root.right , root.data)
        return root

    def minvalue(self, root):
        if root is None:
            return -1
        current = root 
        while current.left is not None : 
            current = current.left 
        return current.data

    def maxvalue(self,root):
        if root is None :
            return -1 
        current = root 
        while current.right is not None :
            current = current.right 
        return current.data

    def floor(self,root , x):
        floor_value = -1 
        while root is not None : 
            if root.data == x:
                return root.data 
            if x > root.data : 
                root = root.right 
            else :
                floor_value = root.data 
                root = root.left 
        return floor_value
    
    def ceil(self,root , x ):
        ceils = -1
        while root : 
            if root.data == x :
                return root.data
            elif x > root.data :
                root = root.right 
            else:
                ceils = root.data
                root = root.left
        return ceils
    
    def inorder(self, root):
        if root:
            self.inorder(root.left)
            print(f"{root.data}", end=" ")
            self.inorder(root.right)
if __name__ == "__main__":
    root = Node(50)
    root.left = Node(30)
    root.right = Node(70)
    root.left.left = Node(20)
    root.left.right = Node(40)
    root.right.left = Node(60)
    root.right.right = Node(30)

    print("Duyet theo thu tu: ")
    root.inorder(root)

    x = 68
    print(f"\nThem gia tri {x}")
    root = root.add_element(root, x)
    root.inorder(root)

    x = 43
    print(f"\nThem gia tri {x}")
    root = root.add_element_for_loop(root, x)
    root.inorder(root)

    a = 68
    if root.search(root, a):
        print(f"\nTim thay gia tri {a}")
    else:
        print(f"\nKhong tim thay gia tri {a}")

    x = 70
    print(f"\nXoa gia tri {x}")
    root = root.delete(root, x)
    root.inorder(root)

    min_val = root.minvalue(root)
    print(f"\nGia tri nho nhat la: {min_val}")
    
    max_val = root.maxvalue(root)
    print(f"\nGia tri nho nhat la: {max_val}")

    x = 41
    floor_val = root.floor(root,x)
    print(f"\nGia tri san la {floor_val}")

    x = 7
    ceil_val = root.ceil(root,x)
    if ceil_val is not None : 
        print(f"Gia tri ceil cua {x} la {ceil_val}")

    


