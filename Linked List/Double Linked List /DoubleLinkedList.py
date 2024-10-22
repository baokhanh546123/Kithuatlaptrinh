class Node:
    def __init__(self, data):
        self.data = data
        self.prev = None
        self.next = None

    def traverse_forward(self, head):
        current = head
        while current is not None:
            print(current.data, end=" ")
            current = current.next
        print("\n")

    def traverse_backward(self, tail):
        current = tail
        while current is not None:
            print(current.data, end=" ")
            current = current.prev
        print("\n")

    def find_length(self, head):
        length = 0
        current = head
        while current is not None:
            length += 1
            current = current.next
        return length

    def add_first(self, head, data):
        new_node = Node(data)
        new_node.next = head
        if head is not None:
            head.prev = new_node
        return new_node

    def add_last(self, head, data):
        new_node = Node(data)
        if head is None:
            head = new_node
        else:
            current = head
            while current.next is not None:
                current = current.next
            current.next = new_node
            new_node.prev = current
        return head

    def add(self, head, pos, data):
        if pos == 1:
            return self.add_first(head, data)
        
        new_node = Node(data)
        current = head
        for _ in range(1, pos - 1):
            if current is None:
                print("Out of bounds")
                return head
            current = current.next
        if current is None:
            print("Out of bounds")
            return head
        new_node.prev = current
        new_node.next = current.next
        if current.next:
            current.next.prev = new_node
        current.next = new_node
        return head

    def remove_first(self, head):
        if head is None:
            return None
        head = head.next
        if head:
            head.prev = None
        return head

    def remove_last(self, head):
        if head is None:
            return None
        current = head
        while current.next:
            current = current.next
        if current.prev:
            current.prev.next = None
        return head

    def remove(self, head, pos):
        if head is None or pos <= 0:
            return head
        current = head
        for i in range(1, pos):
            if current is None:
                print("Out of bounds")
                return head
            current = current.next
        if current is None:
            return head
        if head == current:
            head = current.next
            if head:
                head.prev = None
        else:
            if current.prev:
                current.prev.next = current.next
            if current.next:
                current.next.prev = current.prev
        return head

    def display(self, head):
        current = head
        while current is not None:
            print(current.data, end=" ")
            current = current.next
        print()

if __name__ == '__main__':
    head = Node(10)
    node2 = Node(20)
    node3 = Node(30)

    head.next = node2
    node2.next = node3
    node2.prev = head
    node3.prev = node2

    print("Danh sach luc ban dau:")
    head.display(head)

    print("Duyet ve phia truoc:")
    head.traverse_forward(head)

    print("Duyet nguoc :")
    head.traverse_backward(node3)

    print("Chieu dai cua danh sach:", head.find_length(head))

    head = head.add_first(head, 5)
    print("Them vao dau:")
    head.display(head)

    head = head.add_last(head, 40)
    print("Them vao cuoi:")
    head.display(head)

    head = head.add(head, 3, 25)
    print("Them vao vi tri thu 3 :")
    head.display(head)

    head = head.remove_first(head)
    print("Xoa o vi tri dau:")
    head.display(head)

    head = head.remove_last(head)
    print("Xoa o vi tri cuoi :")
    head.display(head)

    head = head.remove(head, 2)
    print("Xoa o vi tri thu 2:")
    head.display(head)
