package Vidu;

public class queue {
	int front , rear , size ; 
	int [] Q ; 
	public queue(int size) {
		this.size = size ; 
		this.front = -1;
		this.rear = -1 ;
		this.Q = new int [size];
	}
	public boolean isEmpty() {
		return front == -1 ;
	}
	public boolean isFull() {
		return (front == 0 && rear == size - 1) || (front == rear + 1);
	}
	public void push(int i ) {
		if (isFull()) {
			System.out.println("Empty");
			return;
		}else {
			if (front == -1) {
				front = 0 ;
			}
			rear = (rear + 1 ) % size ;
			Q[rear] = i;
			System.out.println("Added to " + i);
			}
		}
	public int pop() {
		if (isEmpty()) {
			System.out.println("Empty");
			return -1;
		}else {
			int element = Q[front];
			if (front == rear ) {
				front = -1 ; 
				rear = -1  ; 
			}else {
				front = (front + 1 ) % size;
			}
			System.out.println("Pop is " + element);
			return element;
		}
	}
	public void display() {
		if (isEmpty()) {
			System.out.println("Empty");
		}else {
			int i = front ;
			while(true) {
				System.out.print(Q[i] + "->");
				if (i == rear ) {
					break;
				}
				i = (i+1) % size ; 
			}
			System.out.println("None");
		}
	}
}
