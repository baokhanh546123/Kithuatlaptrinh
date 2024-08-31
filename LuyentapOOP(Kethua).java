//File SQ.java  
public class SQ {
    protected int size , index  ; 
    protected int [] Array ; 
    public SQ(int size){
        this.size = size ; 
        index = -1 ; 
        Array = new int [size];
    }
    public boolean isEmpty(){
        return (index == -1) ;
    }
    public boolean isFull(){
        return index == size - 1;
    }
}
//File stack.java
public class stack extends SQ{
    public stack(int size){
        super(size);
    }
    public void push(int i ){
        if (isFull()){
            System.out.println("Full");
        }else{
            index += 1;
            Array[index] = i;
            System.out.println("Add to :" + i);
        }
    }
    
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        } else {
            int value = Array[index];
            index -= 1;
            System.out.println("Popped from stack: " + value);
            return value;
        }
    }
}
//File queue.java
public class queue extends SQ{
    int front , rear ; 
    public queue(int size ){
        super(size);
        this.front = -1;
        this.rear = -1;
    }
    public boolean isFull(){
        return ((front == 0 && rear == size - 1) || (front == rear + 1));
    }
    public void push(int i){
        if (isFull()){
            System.out.println("Full");
        }else{
            if (front == -1 ){
                front = 0;
                rear = (rear + 1) % size;
                Array[rear] = i ;
                System.out.println("Add to :" + i);
            }
        }
    }
    
    public int pop() {
    if (front == -1) {
        System.out.println("Queue is Empty");
        return -1;
    } else {
        int temp = Array[front];
        if (front == rear) {
            // Only one element was present, so reset the queue
            front = -1;
            rear = -1;
        } else {
            // Move front to the next position in the circular manner
            front = (front + 1) % size;
        }
        System.out.println("Popped element is: " + temp);
        return temp;
    }
  }
}
//Main.java
public class Main
{
	public static void main(String[] args) {
		stack s = new stack(2);
		s.push(4);
		s.push(5);
		System.out.println("Is full :" + s.isFull());
		s.pop();
		s.pop();
		System.out.println("Is empty :" + s.isEmpty());
		System.out.println("-------------------------");
		queue q = new queue(5);
		q.push(7);
		q.push(4);
		System.out.println("Is full :" + q.isFull());
		q.pop();
		q.pop();
		System.out.println("Is empty :" + q.isEmpty());
	    
	}
}
