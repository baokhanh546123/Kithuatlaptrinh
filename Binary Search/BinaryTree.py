from collections import deque
class Node:
    def __init__(self, data):
        self.data = data  
        self.left = self.right = None 

    def preorderDFS(self,node):
        if node is None :
            return 
        print(node.data , end = " ")
        self.preorderDFS(node.left)
        self.preorderDFS(node.right)
    
    def inorderDFS(self,node):
        if node is None : 
            return 
        self.inorderDFS(node.left)
        print(node.data , end = " ")
        self.inorderDFS(node.right)
    
    def postorderDFS(self,node):
        if node is None :
            return
        self.postorderDFS(node.left)
        self.postorderDFS(node.right)
        print(node.data , end = " ")

    def bfs(root):
        if root is None:
            return
        queue = [root]
        while queue:
            node = queue.pop(0)
            print(node.data, end=' ')
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)
    def add_binary_tree(root,data):
        if root is None : 
            return Node(data)
        queue = deque([root])
        queue.append(root)
        while len(queue) > 0 : 
            temp = queue.popleft()
            if temp.left is None : 
                temp.left = Node(data)
                break
            else:
                queue.append(temp.left)
            if temp.right is None : 
                temp.right = Node(data)
                break
            else:
                queue.append(temp.right)
        return root
    def searchDFS(self , root , x ):
            if root is None :
                return False
            if root.data == x :
                return True 
            left_res = self.searchDFS(root.left , x);
            right_res = self.searchDFS(root.right , x )
            return left_res or right_res
    def delete(self,root , x ):
        if root is None :
            return None 
        queue = deque([root])
        target = None 
        while queue:
            current = queue.popleft()
            if current.data == x:
                target = current 
                break
            if current.left :
                queue.append(current.left)
            if current.right :
                queue.append(current.right)
        if target is None :
            return root 
        lastNode = None 
        lastParent = None 
        queue = deque([(root, None)])
        while queue : 
            current,parent=queue.popleft()
            lastNode = current 
            lastParent = parent
            if current.left :
                queue.append((current.left , current))
            if current.right :
                queue.append((current.right , current))
        target.data = lastNode.data
        if lastParent :
            if lastParent.left == lastNode:
                lastParent.left = None 
            else:
                lastParent.right = None 
        else:
            return None 
        return root
if __name__ == '__main__':
    root = Node(84)
    root.left = Node(32)
    root.right = Node(21)
    root.left.left  = Node(48)
    root.left.right = Node(74)

    print("Duyet truoc")
    root.preorderDFS(root)

    print("\nDuyet theo thu tu tu truoc ra sau " )
    root.inorderDFS(root)
    
    print("\nDuyet theo thu tu tu sau ra truoc " )
    root.postorderDFS(root)

    key = 83
    root = Node.add_binary_tree(root, key)
    print("\nSau khi them :")
    root.inorderDFS(root)

    key = 95
    root = Node.add_binary_tree(root,key)
    print("\nSau khi chen : ")
    root.inorderDFS(root)

    x = 48
    if (root.searchDFS(root,x)):
        print(f"\n{x} ton tai trong cay nhi phan")
    else:
        print(f"\n{x} khong ton tai trong cay nhi phan")
    
    x = 48
    root = root.delete(root , x )
    print(f"Sau khi xoa {x}")
    root.inorderDFS(root)

    x = 48
    if (root.searchDFS(root,x)):
        print(f"\n{x} ton tai trong cay nhi phan")
    else:
        print(f"\n{x} khong ton tai trong cay nhi phan")
    


    
