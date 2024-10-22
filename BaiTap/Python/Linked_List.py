class LinkedList:
    def __init__(self, c):
        self.size = c
        self.values = [None] * self.size
        self.next = [-1] * self.size
        self.head = -1 
        self.index = 0 
        
    def isEmpty(self):
        return self.head == -1 
        
    def isFull(self):
        return self.index == self.size 
        
    def add(self, i):
        if self.isFull():
            print("Full")
            return 
        
        new = self.index 
        self.values[new] = i 
        self.next[new] = -1
        if self.head == -1:
            self.head = new 
        else:
            current = self.head 
            while self.next[current] != -1:
                current = self.next[current]
                
            self.next[current] = new 
        self.index += 1 
        print("Added:", i)
    
    def pop(self, i):
        if self.isEmpty():
            print("Empty")
            return
        
        # Case when the value to remove is at the head
        if self.values[self.head] == i:
            self.head = self.next[self.head]
            self.index -= 1
            print("Popped:", i)
            return
            
        current = self.head 
        prev = -1 
        
        # Traverse the list to find the value to remove
        while current != -1 and self.values[current] != i:
            prev = current 
            current = self.next[current]
            
        if current == -1:
            print("Value not found")
            return

        # Remove the element by skipping it in the next references
        self.next[prev] = self.next[current]
        self.index -= 1
        print("Popped:", i)
    
    def display(self):
        if self.isEmpty():
            print("List is empty.")
            return

        current = self.head
        while current != -1:
            print(self.values[current], end=" -> ")
            current = self.next[current]
        print("None")
            
if __name__ == '__main__':
    l = LinkedList(3)
    l.add(2)
    l.add(4)
    l.add(8)
    l.isFull()
    l.pop(2)
    l.pop(8)
    l.pop(4)
    l.display()
    print(l.isEmpty())
