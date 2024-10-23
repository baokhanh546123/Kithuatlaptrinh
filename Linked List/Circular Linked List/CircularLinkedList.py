class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

    def add_to_empty(self, last, data):
        if last is not None:
            return last
        new_node = Node(data)
        last = new_node
        last.next = last
        return last

    def add_to_end(self, last, data):
        if last is None:
            return self.add_to_empty(last, data)
        new_node = Node(data)
        new_node.next = last.next
        last.next = new_node
        return new_node

    def add_at_first(self, last, data):
        new_node = Node(data)
        if last is None:
            new_node.next = new_node
            return new_node
        new_node.next = last.next
        last.next = new_node
        return last

    def add_at_position(self, last, pos, data):
        if last is None:
            if pos != 1:
                print("Loi sai vi tri")
                return last
            return self.add_to_empty(last, data)

        new_node = Node(data)
        current = last.next
        if pos == 1:
            return self.add_at_first(last, data)

        for i in range(1, pos - 1):
            current = current.next
            if current == last.next:
                print("Loi sai vi tri")
                return last

        new_node.next = current.next
        current.next = new_node
        return last

    def remove_at_first(self, last):
        if last is None:
            print("Danh sach rong")
            return None
        if last == last.next:  
            return None
        last.next = last.next.next
        return last

    def remove_at_end(self, last):
        if last is None:
            print("Danh sach rong")
            return None
        if last == last.next:  
            return None
        current = last.next
        while current.next != last:
            current = current.next
        current.next = last.next
        return current

    def remove_at_position(self, last, pos):
        if last is None:
            print("danh sach rong")
            return None

        current = last.next
        prev = last
        if pos == 1:
            return self.remove_at_first(last)

        for i in range(1, pos):
            if current == last:
                print(f"nut tai vi tri {pos} khong ton tai")
                return last
            prev = current
            current = current.next

        prev.next = current.next
        if current == last:
            return prev
        return last
    def search(self,head,x):
        if head is None :
            return False
        current = head
        if current.data == x :
            return True
        current = current.next
        while current != head:
            if current.data == x :
                return True
            current = current.next
        return False 
    def display(self, last):
        if last is None:
            print("Danh sach rong ")
            return
        head = last.next
        current = head
        while True:
            print(current.data, end=" ")
            current = current.next
            if current == head:
                break
        print()
if __name__ == '__main__':
    node = Node(0)
    last = None

    last = node.add_to_empty(last, 3)
    last = node.add_to_end(last, 4)
    print("Them vao danh sach trong")
    node.display(last)

    last = node.add_at_first(last, 2)
    last = node.add_at_first(last, 1)
    print("Them vao dau")
    node.display(last)

    last = node.add_at_position(last, 3, 2.5)
    print("Them vao vi tri thu 3")
    node.display(last)

    last = node.remove_at_first(last)
    print("Xoa dau")
    node.display(last)

    last = node.remove_at_end(last)
    print("Xoa cuoi")
    node.display(last)

    last = node.remove_at_position(last, 2)
    print("Xoa o vi tri thu 2")
    node.display(last)

    x = 2
    result = node.search(last,x)
    if result :
        print(f"{x} ton tai trong danh sach ")
    else:
        print(f"{x} khong ton tai trong danh sach ")
