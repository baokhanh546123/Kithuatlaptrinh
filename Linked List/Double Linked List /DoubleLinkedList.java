package LinkedList;

class DoubleLinkedList {
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }

        static void display(Node head) {
            Node current = head;
            while (current != null) {
                System.out.print(current.data);
                if (current.next != null) {
                    System.out.print("-->");
                }
                current = current.next;
            }
            System.out.println();
        }

        static void traverse_forward(Node head) {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }

        static void traverse_backward(Node tail) {
            Node current = tail;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.prev;
            }
            System.out.println();
        }

        static int find_length(Node head) {
            int length = 0;
            Node current = head;
            while (current != null) {
                length++;
                current = current.next;
            }
            return length;
        }

        static Node add_first(Node head, int data) {
            Node new_node = new Node(data);
            new_node.next = head;
            if (head != null) {
                head.prev = new_node;
            }
            return new_node;  // new head
        }

        static Node add_last(Node head, int data) {
            Node new_node = new Node(data);
            if (head == null) {
                head = new_node;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = new_node;
                new_node.prev = current;
            }
            return head;
        }

        static Node add(Node head, int pos, int data) {
            if (pos == 1) {
                return add_first(head, data);
            }

            Node new_node = new Node(data);
            Node current = head;

            for (int i = 1; i < pos - 1; i++) {
                if (current == null) {
                    System.out.println("Out of bounds");
                    return head;
                }
                current = current.next;
            }

            if (current == null) {
                System.out.println("Out of bounds");
                return head;
            }

            new_node.prev = current;
            new_node.next = current.next;
            if (current.next != null) {
                current.next.prev = new_node;
            }
            current.next = new_node;
            return head;
        }

        static Node remove_first(Node head) {
            if (head == null) {
                return null;
            }
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return head;
        }

        static Node remove_last(Node head) {
            if (head == null) {
                return null;
            }
            if (head.next == null) {
                return null;
            }
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            if (current.prev != null) {
                current.prev.next = null;
            }
            return head;
        }

        static Node remove(Node head, int pos) {
            if (head == null || pos <= 0) {
                return head;
            }
            Node current = head;
            for (int i = 1; i < pos; i++) {
                if (current == null) {
                    return head;
                }
                current = current.next;
            }
            if (current == null) {
                return head;
            }

            if (head == current) {
                head = current.next;
                if (head != null) {
                    head.prev = null;
                }
            } else {
                if (current.prev != null) {
                    current.prev.next = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                }
            }
            return head;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(30);
        
        node1.next = node2;
        node2.next = node3;
        node2.prev = node1;
        node3.prev = node2;

        System.out.println("Danh sach ban dau :");
        Node.display(node1);

        System.out.println("Duyet o vi tri truoc :");
        Node.traverse_forward(node1);

        System.out.println("Duyet nguoc:");
        Node.traverse_backward(node3);

        System.out.println("Do dai cua danh sach: " + Node.find_length(node1));

        System.out.println("\nThem vao vi tri dau:");
        node1 = Node.add_first(node1, 8);
        Node.display(node1);

        System.out.println("\nThem vao vi tri cuoi:");
        node1 = Node.add_last(node1, 40);
        Node.display(node1);

        System.out.println("\nThem vao vi tri thu 3 :");
        node1 = Node.add(node1, 3, 22);
        Node.display(node1);

        System.out.println("\nXoa o vi tri dau:");
        node1 = Node.remove_first(node1);
        Node.display(node1);

        System.out.println("\nXoa o vi tri cuoi:");
        node1 = Node.remove_last(node1);
        Node.display(node1);

        System.out.println("\nXoa o vi tri thu 2 :");
        node1 = Node.remove(node1, 2);
        Node.display(node1);
    }
}
