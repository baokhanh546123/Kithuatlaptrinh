class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

    def traverse_linked_list(self, head):
        current = head
        while current is not None:
            print(current.data, end=" --> " if current.next else "")
            current = current.next
        print()

    def search_linked_list(self, head, target):
        while head is not None:
            if head.data == target:
                return True
            head = head.next
        return False

    def find_linked_list(self, head):
        length = 0
        current = head
        while current is not None:
            length += 1
            current = current.next
        return length

    def add_first(self, head, value):
        new_node = Node(value)
        new_node.next = head
        head = new_node
        return head

    def add_final(self, head, value):
        new_node = Node(value)
        if head is None:
            return new_node
        current = head
        while current.next is not None:
            current = current.next
        current.next = new_node
        return head

    def add(self, head, pos, data):
        if pos < 1:
            print("Sai vi tri")
            return head
        if pos == 1:
            return self.add_first(head, data)

        count = 1
        current = head
        while count < pos - 1 and current is not None:
            count += 1
            current = current.next
        if current is None:
            print("Sai vi tri")
            return head
        temp = Node(data)
        temp.next = current.next
        current.next = temp
        return head

    def remove_first(self, head):
        if head is None:
            return None
        temp = head
        head = head.next
        temp = None
        return head

    def remove_last(self, head):
        if head is None:
            return None
        if head.next is None:
            return None
        second_last = head
        while second_last.next and second_last.next.next:
            second_last = second_last.next
        second_last.next = None
        return head

    def remove(self, head, pos):
        if pos < 1 or head is None:
            return head
        if pos == 1:
            temp = head
            head = head.next
            temp = None
            return head

        current = head
        for i in range(1, pos - 1):
            current = current.next
            if current is None:
                return head
        if current is None or current.next is None:
            return head
        temp = current.next
        current.next = current.next.next
        temp = None
        return head

    def __str__(self):
        return str(self.data)


if __name__ == '__main__':
    node1 = Node(10)
    node2 = Node(20)
    node3 = Node(30)

    node1.next = node2
    node2.next = node3

    print("Danh sach ban dau:")
    node1.traverse_linked_list(node1)

    print("\nNut tiep theo cua 1 la ", node1.next)
    print("Nut tiep theo cua 2 la ", node2.next)
    print("Nut tiep theo cua 3 la ", node3.next)

    print("\nTime kiem 20 trong danh sach :", node1.search_linked_list(node1, 20))
    print("Tim kiem 40 trong danh sach:", node1.search_linked_list(node1, 40))

    print("\n Do dai cua danh sach:", node1.find_linked_list(node1))

    node1 = node1.add_first(node1, 5)
    print("\n Them vao dau danh sach:")
    node1.traverse_linked_list(node1)

    node1 = node1.add_final(node1, 40)
    print("\n Them vao cuoi danh sach:")
    node1.traverse_linked_list(node1)

    print("\n Them vao danh sach:")
    node1 = node1.add(node1, 3, 38)
    node1.traverse_linked_list(node1)

    print("\n Xoa dau :")
    node1 = node1.remove_first(node1)
    node1.traverse_linked_list(node1)

    print("\n Xoa cuoi:")
    node1 = node1.remove_last(node1)
    node1.traverse_linked_list(node1)

    print("\n Xoa trong danh sach:")
    node1 = node1.remove(node1, 2)
    node1.traverse_linked_list(node1)
