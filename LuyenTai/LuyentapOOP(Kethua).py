class SQ:
    def __init__(self, size):
        self.size = size
        self.Array = [None] * size
        self.index = -1

    def isEmpty(self):
        return self.index == -1

    def isFull(self):
        return self.index == self.size - 1


class Stack(SQ):
    def __init__(self, size):
        super().__init__(size)

    def push(self, i):
        if self.isFull():
            print("Full")
        else:
            self.index += 1
            self.Array[self.index] = i
            print("Add to: ", i)

    def pop(self):
        if self.isEmpty():
            print("Empty")
            return -1
        else:
            valid = self.Array[self.index]
            self.index -= 1
            print("Pop is: ", valid)
            return valid


class Queue(SQ):
    def __init__(self, size):
        super().__init__(size)
        self.front = -1
        self.rear = -1

    def isFull(self):
        return (self.front == 0 and self.rear == self.size - 1) or (self.front == self.rear + 1)

    def isEmpty(self):
        return self.front == -1

    def push(self, i):
        if self.isFull():
            print("Full")
        else:
            if self.front == -1:
                self.front = 0
            self.rear = (self.rear + 1) % self.size
            self.Array[self.rear] = i
            print("Add to: ", i)

    def pop(self):
        if self.isEmpty():
            print("Empty")
            return -1
        else:
            ele = self.Array[self.front]
            if self.front == self.rear:
                self.front = -1
                self.rear = -1
            else:
                self.front = (self.front + 1) % self.size
            print("Pop is: ", ele)
            return ele


if __name__ == "__main__":
    print("Testing Stack:")
    stack = Stack(3)
    stack.push(1)
    stack.push(2)
    stack.push(3)
    stack.push(4)  # This should print "Full"
    stack.pop()
    stack.pop()
    stack.pop()
    stack.pop()  # This should print "Empty"

    print("\nTesting Queue:")
    queue = Queue(3)
    queue.push(1)
    queue.push(2)
    queue.push(3)
    queue.push(4)  # This should print "Full"
    queue.pop()
    queue.pop()
    queue.pop()
    queue.pop()  # This should print "Empty"
