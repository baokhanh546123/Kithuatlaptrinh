package Vidu;

public class stack {
	int size , index ; 
	int [] Stack;
	public stack(int size) {
		this.size = size ; 
		this.index = -1 ; 
		Stack = new int [size];
	}
	public boolean isEmpty(){
		return index == -1 ;
	}
	public boolean isFull() {
		return index == size - 1 ;
	}
	public void add(int i ) {
		if (isFull()) {
			System.out.println("FUll");
		}else { 
			index ++;
			Stack[index] = i ;
			System.out.println("Added to :" + i );
			
		}
	}
	public int pop() {
		if (isEmpty()) {
			System.out.println("EMPTY");
			return -1;
		}else {
			int valid = Stack[index];
			index --;
			System.out.println("Pop is :" + valid);
			return valid;
		}
	}
	public void display() {
		if (isEmpty()) {
			System.out.println("Empty");
		}else {
			for (int i = 0 ; i<=index;i++) {
				System.out.print(Stack[i]+"->");
			}
			System.out.println("None");
		}
	}
}
