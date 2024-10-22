package LinkedList;

public class SinglyListLined {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data ;
            this.next = null;
        }
        static void traverse(Node head){
            Node current = head;
            while (current != null){
                System.err.print(current.data + " ");
                current = current.next;
            }
            System.out.println();

        }
        static boolean search(Node head , int target){
            while (head != null){
                if (head.data == target){
                    return true;
                }
                head = head.next;
            }
            return false;
        }
        static int find (Node head){
            int length = 0;
            Node current = head;
            while (current != null) {
                length++;
                current = current.next;
            }
            return length;
        }
        static Node add_first(Node head , int value){
            Node new_Node = new Node(value);
            new_Node.next = head;
            head = new_Node;
            return head;
        }
        static Node add_final(Node head, int value) {
            Node new_node = new Node(value);
            if (head == null) {
                return new_node;
            }
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new_node;
            return head;
        }
        static Node add(Node head , int pos , int data){
            if (pos < 1){
                System.out.println("Vi tri khong phu hop");
                return head;
            }
            if (pos == 1){
                add_first(head, data);
            }
            Node prev = head;
            int count = 1;
            while (count < pos - 1 && prev != null) {
                prev = prev.next;
                count++;
            }
            if (prev == null){
                System.out.println("Sai vi tri");
                return head;
            }
            Node temp = new Node(data);
            temp.next = prev.next;
            prev.next = temp;
            return head;
            
        }
        static Node remove_first(Node head){
            if (head == null){
                return null;
            }
            Node temp = head;
            head = head.next;
            return head;
        }
        static Node remove_last(Node head){
            if (head == null){
                return null;
            }
            if (head.next == null){
                head = null;
                return null;
            }
            Node second_last = head;
            while (second_last.next.next != null){
                second_last = second_last.next;
            }
            second_last.next = null;
            return head;
        }
        static Node remove(Node head , int pos){
            if (head == null || pos < 1){
                return head;
            }
            if (pos == 1){
                Node temp = head ;
                head = head.next;
                temp = null; 
                return head ;
            }
            Node current = head ;
            for(int i = 1 ; i < pos - 1 && current != null;i++){
                current = current.next;
            }
            if (current == null || current.next == null){
                return head;
            }
            Node temp = current.next;
            current.next = current.next.next;
            temp = null;
            return head;
        }
        static void display (Node head){
            Node current = head;
            while (current != null) {
                System.out.print(current.data);
                if (current != null){
                    System.out.print("-->");
                }
                current = current.next;
            }
            System.err.println();
        }
    }
    public static void main(String[] args) {
        Node node1 = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(30);
        node1.next = node2 ;
        node2.next = node3 ;
        //node1 =  Node.remove_first(node1);
        //Node.display(node1);
        //node1 = Node.remove_last(node3);
        //Node.display(node3);
        node1 = Node.remove(node1, 2);
        Node.display(node1);
    }
}