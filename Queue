package BaiTap;
public class queue { 
    int size; 
    int[] Q;
    int front; 
    int rear; 

    public queue(int size) {
        this.size = size;
        Q = new int[size];
        front = -1; 
        rear = -1; 
    }
    
    // front co index  -1 va rear index  -1 tuc la mang rong 
    public boolean isEmpty() {
        return (front == -1);
    }

    // front nam o index 0 va rear co index 4 (voi dieu kien size = 5)
    // hay index cua front hon index cua rear 1 don vi 
    public boolean isFull() {
        return (front == 0 && rear == size - 1) || (front == rear + 1);
    }
    
    public void push(int i) {
        if (isFull()) {
            System.out.println("Queue is Full");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size; // dam bao lap day 
            Q[rear] = i;
            System.out.println("Inserted " + i);
        }
    }

    
    public int pop() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1; // tra ve gia tri loi
        } else {
            int element = Q[front];
            // neu front bang rear tuc la rong thi khi push chi so index nhay theo rear 
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % size; // lap day 
            }
            return element;
        }
    }


}
// file Main.java 
package BaiTap;
public class Main { 
    public static void main (String[] args) {
        queue q = new queue(5);
        q.push(22);
        q.pop();
        System.out.println("Is Empty: " + q.isEmpty());
        q.push(2);
        q.push(3);
        q.push(4);
        q.push(5);
        q.push(6); // Should show "Queue is Full"
        System.out.println("full is " + q.isFull());
        q.pop();
        q.pop();
        q.pop();
        q.pop();
        q.pop();
        System.out.println("Is Empty: " + q.isEmpty());
    }
}
