class queue : 
    def __init__(self , size ):
        self.size = size ; 
        self.front = -1 ; 
        self.rear = -1 ; 
        self.Q = [None]  * size ; 
    
    def isEmpty(self):
        if (self.front == -1) : 
            return True ; 
        return False;
    
    def isFull(self):
        if (self.front == 0 and self.rear == self.size - 1 ) or (self.front == self.rear + 1 ) : 
            return True 
        return False
    
    def push(self,i):
        if self.isFull():
            print("Full")
        else:
            if self.front == -1 : 
                self.front = 0 ;
            self.rear = (self.rear + 1 ) % self.size
            self.Q[self.rear]= i 
            print("Add " + str(i) )
        
    def pop(self):
        if self.isEmpty():
            print("Empty")
            return -1 
        else : 
            element = self.Q[self.front]
            if (self.front == self.rear ):
                self.front = -1 
                self.rear =  -1 
            else :
                self.front = (self.front + 1) + self.size 
            return element

if __name__ == '__main__' : 
    q = queue(2)
    q.push(2)
    q.push(3)
    print(q.isFull())
    q.pop()
    print(q.isEmpty())
    
