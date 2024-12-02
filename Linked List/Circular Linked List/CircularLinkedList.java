package LinkedList;
class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class CircularLinkedList {
    static Node add_to_empty(Node last, int data) {
        if (last != null) {
            return last;
        }
        Node newNode = new Node(data);
        last = newNode;
        last.next = last; 
        return last;
    }
    static Node add_to_end(Node last, int data) {
        if (last == null) {
            return add_to_empty(last, data);
        }
        Node newNode = new Node(data);
        newNode.next = last.next; 
        last.next = newNode; 
        return newNode; 
    }
    static Node add_at_first(Node last , int data){
        Node newNode = new Node(data);
        if (last == null){
            newNode.next = newNode;
            return newNode;
        }
        newNode.next = last.next;
        last.next = newNode;
        return last;
    }
    static Node add_at_end(Node tail , int data){
        Node newNode = new Node(data);
        if (tail == null){
            tail = newNode;
            newNode.next = newNode;
        }else{
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
        return tail;
    }
    static Node add_at_position(Node head , int pos , int data){
        if (head == null){
            if (pos != 1){
                System.out.println("Loi vi tri");
                return head;
            }
            Node newNode = new Node(data);
            head = newNode;
            head.next = head;
            return head;
        }
        Node newNode = new Node(data);
        Node current = head.next;
        if (pos == 1 ){
            newNode.next = current ;
            head.next = newNode;
            return head;
        }
        for (int i = 1 ; i < pos - 1 ; i++){
            current = current.next;
            if (current == head.next){
                System.err.println("Loi vi tri");
                return head;
            }
        }
        newNode.next = current.next;
        current.next = newNode;
        if (current == head){
            head = newNode;
        }
        return head;
    }
    static Node remove_at_first(Node head){
        if (head == null){
            System.out.println("Danh sach rong");;
            return null;
        }
        Node last = head.next;
        if (head == last){
            last = null ;
        }else{
            head.next = last.next;
        }
        return head;
    }
    static Node remove_at_end(Node head){
        if (head == null){
            System.out.println("Danh sach rong");
            return null;
        }
        Node last = head.next ;
        if (head == last){
            head = null;
            return head;
        }
        Node current = last;
        while (current.next != head){
            current = current.next;
        }
        current.next = last;
        head = current;
        return head;
    }
    static void display(Node last) {
        if (last == null) {
            return;
        }
        Node head = last.next;
        while (true) {
            System.out.print(head.data + " ");
            head = head.next;
            if (head == last.next) {
                break; 
            }
        }
        System.out.println();
    }
    static boolean search(Node head , int x ){
        if (head == null){
            return false;
        }
        Node current = head ;

        do {
            if (current.data == x){
                return true;
            }
            current = current.next;
        }while(current != head);
        return false;
    }
    static Node remove_at_position(Node head , int pos){
        if (head == null){
            System.out.println("Danh sach rong");
            return null;
        }
        Node current = head.next;
        Node prev = head;
        if (pos == 1){
            return remove_at_first(head);
        }
        for (int i = 1 ; i < pos; i++){
            if (current == head){
                System.out.println("Nut cua du lieu " + pos + " khong ton tai");
                return head;
            }
            prev = current;
            current = current.next;
        }
        prev.next = current.next;
        if (current == head){
            return prev;
        }
        return head;
    }

    public static void main(String[] args) {
        Node last = null; 
        last = add_to_empty(last, 30);
        last = add_at_end(last, 40);
        last = add_at_end(last, 50);
        System.out.println("Them vao danh sach rong");
        display(last);

        last = add_at_first(last, 20);
        last = add_at_first(last, 10);
        System.out.println("Them vao vi tri dau tien");
        display(last);

        last = add_at_position(last, 3, 25);
        System.out.println("Them vao vi tri thu 3 cua danh sach ");
        display(last);
        
        
        last = remove_at_first(last);
        System.out.println("Xoa vi tri dau tien");
        display(last);

        last = remove_at_end(last);
        System.out.println("Xoa vi tri cuoi cung");
        display(last);

        last = remove_at_position(last, 1);
        System.out.println("Xoa vi tri thu 2 cua danh sach");
        display(last);

        int x = 25;
        boolean result = search(last, x);
        if (result){
            System.out.println("Gia tri " + x  + " ton tai trong danh sach ");
        }else{
            System.out.println("Gia tri " + x  + " khong ton tai trong danh sach ");
        }
    }
}
